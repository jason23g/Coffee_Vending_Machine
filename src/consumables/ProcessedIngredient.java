package consumables;

import java.util.HashMap;


public class ProcessedIngredient extends Ingredient{
	
	
	private HashMap<String, Ingredient> ingredients;
	
	
	public ProcessedIngredient(String name) {
		super(name,0);
		ingredients = new HashMap<String, Ingredient>();
		
	}
	
	
	public void resetIngredients() {
		ingredients = new HashMap<String, Ingredient>();
	}
	
	public void addIngredient(Ingredient i){
		ingredients.put(i.getName(), i);
		this.setQuantity(this.getQuantity()+i.getQuantity());
	}
	
	
	public String getName(){
		String name= super.getName()+"(";

		for (Ingredient ing : ingredients.values())
			name += ing.getName()+",";

		name = name.substring(0,name.length()-1);
		name +=")";
		return name;
	}

	
	public ProcessedIngredient clone() throws CloneNotSupportedException {
		ProcessedIngredient clone = (ProcessedIngredient) super.clone();
		clone.resetIngredients();
		for (Ingredient ig : ingredients.values())
			clone.addIngredient((Ingredient)ig.clone());
		return clone;
	}

}
