package internalMachineModules;

public enum IngredientProcessing {
	
	HOT("hot"),COOL("cool"),MIXED("mixed");
	
	private String name;
	
	private IngredientProcessing(String name) {
		this.name= name;
	}
	
	public String getProcessingLabel() {
		return name;
	}

}
