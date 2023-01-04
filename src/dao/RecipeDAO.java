package dao;

import java.util.List;

import recipe.Recipe;

public interface RecipeDAO {
    List<Recipe> loadRecipes();
    boolean storeRecipe(Recipe recipe);
    boolean deleteRecipe(int code);
}
