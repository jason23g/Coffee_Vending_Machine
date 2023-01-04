package dao;

public abstract class DAOFactory {

    public static DAOFactory getDAOFactory(String type) throws IllegalAccessException {
        if (type.equalsIgnoreCase("FS")){
            return new FsDAOFactory();
        }else{
            throw new IllegalAccessException("Unknown Factory Type");
        }
    }


    public abstract RecipeDAO getRecipeDAO();


}
