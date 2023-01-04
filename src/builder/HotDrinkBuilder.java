package builder;

import consumables.Consumable;
import consumables.Product;

public class HotDrinkBuilder extends ProductBuilder{

	
	public HotDrinkBuilder() {
		super();
	}
	
	public void setCost(int cost) {
		
		
		pr.setCost(cost);
	}

	
	public void setName(String name) {
	
		pr.setName(name);
		
		
	}

	
	public void addConsumable(Consumable con) {
		//pr.getConsumables().add(con);
		pr.addConsumable(con);
		
	}

	
	public Product getProduct() {
		
		return pr;
	}
	
	

}
