package builder;

import consumables.Consumable;
import consumables.Product;

public abstract class ProductBuilder {
	
   protected Product pr = new Product();
   
   
   public ProductBuilder() {
	  // pr = new Product();
   }
	
	public abstract void setCost(int cost);
	
	public abstract void setName(String name);
	
	public abstract void addConsumable(Consumable con);
	
	public abstract  Product getProduct();

}
