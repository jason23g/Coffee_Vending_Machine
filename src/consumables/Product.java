package consumables;

import java.util.List;
import java.util.Vector;

public class Product {
	
	private String code;
	private String name;
	private int cost;
	
	private Vector<Consumable> listOfConsumables;	
	public Product(String code, String name,int cost) {
		this.code = code;
		this.name = name;
		this.cost = cost;
		listOfConsumables = new Vector<>();	
		
	}
	
	public Product() {
		listOfConsumables = new Vector<>();	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getCode() {
		return code;
	}
	
	public Product findProductByCode(String code1) {
		 Product p = null;
		if(this.code.equals(code1)) {
			return p;
		}
		return null;
		
	}
	
	public void addConsumable(Consumable con) {
		this.listOfConsumables.add(con);
	}
	
	public List<Consumable> getConsumables() {
		
		return this.listOfConsumables;
	}
	
	public Consumable getConsumable(String name) {
		for(Consumable c : listOfConsumables) {
			if(c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}

}