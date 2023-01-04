package dao;

public class FsDAOFactory extends  DAOFactory {

    private static final String recipsFolder = "recipes";

    @Override
    public RecipeDAO getRecipeDAO() {
        return new FsRecipeDao(recipsFolder);
    }
}
