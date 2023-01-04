package recipe;

import exceptions.MalformedRecipeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import dao.DAOFactory;
import dao.RecipeDAO;

public class RecipeManager {    
    DAOFactory daoFactory;
    RecipeDAO recipeDAO;    
    private int numOfEnabled;
    private boolean loaded;
    private HashMap<Integer,Recipe> recipes;

    public RecipeManager() throws IllegalAccessException {
        daoFactory = DAOFactory.getDAOFactory("FS");
        this.recipes = new HashMap<>();
        this.numOfEnabled =0;
        this.loaded=false;
    }

    public void loadRecipes(){
        recipeDAO = daoFactory.getRecipeDAO();
        for (Recipe r : recipeDAO.loadRecipes()){
            this.recipes.put(r.getCode(),r);
        }
        this.loaded=true;        
    }

    public int getNumOfEnabled() {
        return numOfEnabled;
    }

    public Recipe getRecipe(Integer code){
        return recipes.get(code);
    }

    public List<Recipe> getRecipes(){
        if (!loaded){
            this.loadRecipes();
        }
        return new ArrayList<>(this.recipes.values());
    }

}
