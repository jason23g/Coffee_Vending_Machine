package builder;

import consumables.Consumable;
import consumables.Product;

public class ColdDrinkBuilder extends ProductBuilder{
	

	public ColdDrinkBuilder() {
		super();
	}
	
	public void setCost(int cost) {
		pr.setCost(cost);
		
			
	}


	public void setName(String name) {
	pr.setName(name);
		
	}


	public void addConsumable(Consumable con) {
		pr.addConsumable(con);
		
	}


	public Product getProduct() {
	
		return pr;
	}

}
