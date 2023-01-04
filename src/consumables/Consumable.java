package consumables;

import java.util.HashMap;

public class Consumable implements Cloneable{

	private String name;
	private int quantity;
	
	
	public Consumable(String name,int quantity) {
		this.name = name;
		this.quantity = quantity;
		
	}

	public String getName() {
	
		return name;
	}
	
	public void setName(String sName) {
		this.name = sName;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	public Consumable getPart(int quantity) {
		try{
			Consumable part = (Consumable) this.clone();
			part.setQuantity(quantity);
			this.setQuantity(this.quantity - quantity);
			return part;
		}catch (CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return null;
	}

	
	
	public   Consumable clone() throws CloneNotSupportedException {
		return  (Consumable) super.clone();
	}
	
}
