package consumables;

public enum Ingredients {
	
	MILK("milk"),SUGAR("sugar"),COFFEE("coffee"),WATER("water");
	
	private String ingredientName;
	
	private Ingredients(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	
	public String getIngredientName() {
		return ingredientName;
	}

}
