package dao;


import exceptions.MalformedRecipeException;
import recipe.Recipe;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FsRecipeDao implements RecipeDAO {

    private String recipeFolder;    

    public FsRecipeDao(String recipesFolder) {
        this.recipeFolder = recipesFolder;
    }

    @Override
    public List<Recipe> loadRecipes() {
        List<Recipe> r = new LinkedList<Recipe>();

        File folder = new File(recipeFolder);
        if (folder.canRead()) {
            for (final File fileEntry : folder.listFiles()) {
                if (!fileEntry.isDirectory()) {
                    try {
                        r.add(this.loadRecipe(fileEntry));
                    } catch (Exception ex) {
                        System.out.println("Could not load recipe " + fileEntry.getName());
                    }
                }
            }
        }
        return r;
    }

    @Override
    public boolean storeRecipe(Recipe recipe) {
        File rFile = new File(this.recipeFolder + File.separator + recipe.getCode());
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(rFile));
            writer.write(recipe.marshal());
        } catch (IOException e) {
            System.out.println("Could not store recipe " + recipe.getCode());
            return false;
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
                
            }
        }
        return true;
    }

    @Override
    public boolean deleteRecipe(int code) {
        File rFile = new File(this.recipeFolder+File.separator+code);
        if (rFile.isFile()){
            rFile.delete();
            System.out.println("Recipe " + code + " deleted.");
            return true;
        }else{
        	System.out.println("Could not find recipe " + code + " to delete.");
            return false;
        }
    }

    private Recipe loadRecipe(File rFile) throws IOException, MalformedRecipeException {
        String fileText = "";
        Recipe recipe = new Recipe(Integer.parseInt(rFile.getName()));
        try {
            if (rFile.canRead()) {
                BufferedReader inputStream = new BufferedReader(new FileReader(rFile));
                String tempStr = inputStream.readLine();
                while (tempStr != null) {
                    fileText += tempStr + "\n";
                    tempStr = inputStream.readLine();
                }
                fileText = fileText.substring(0,fileText.lastIndexOf("\n"));
                inputStream.close();
                recipe.unMarshal(fileText);
            }else{
            	System.out.println("Recipe " + rFile.getName() + " not found.");
            }
        } catch (NumberFormatException ex) {
            throw new MalformedRecipeException("Bad Recipe Code: " + rFile.getName());
        } catch (IOException ioex) {
            throw new MalformedRecipeException("Recipe " + rFile.getName() + " could not be read.");
        }
        return recipe;
    }

    /*Just for Testing*/
    /*public static void main(String[] args) {
        FsRecipeDao rDao = new FsRecipeDao("recipes");
        List<Recipe> recipes = rDao.loadRecipes();
        Recipe r = recipes.get(0);
        r.setCode(100);
        rDao.storeRecipe(r);
    }*/
}
