package builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import consumables.Consumable;
import consumables.Cup;
import internalMachineModules.Consumer;

public class CupCase implements Consumer{
	
	private HashMap<String,Cup> listOfCups;
	private Vector<ProductBuilder> listOfBuilders;
	private ProductBuilder pb;
	private String name;
	
	public CupCase(String name) {
		listOfCups = new HashMap<>();
		listOfCups.put("Big Cup", new Cup("Big cup",50,"Big"));
		listOfBuilders = new Vector<>();
		pb = new HotDrinkBuilder();
		this.name = name;
		
	}
	
	public void prepareProduct(String type,String name,int cost) {
		
		if(type.equalsIgnoreCase("hot")) {
		 pb = new HotDrinkBuilder();
			this.addBuilder(pb);
			pb.setCost(cost);
			pb.setName(name);
			//make it with try and catch
			
				System.out.println("Your "+name+" is ready.Please take it......");
			
				
			
			
		}
		else if(type.equalsIgnoreCase("cold")) {
			pb = new ColdDrinkBuilder();
			this.addBuilder(pb);
			
			pb.setCost(cost);
			pb.setName(name);
			//make it with try and catch
			
				System.out.println("Your "+ name +" is ready.Please take it......");
			
		}
		else {
			
		}
		
	}


	public void load(Consumable con) {
		
     pb.addConsumable(con);//we load the consumable in product builder
	System.out.println(con.getName()+" has been loaded to the product");
	}



	public boolean accepts(Consumable consumable) {


		return true;
	}
	
	public void addBuilder(ProductBuilder pb) {
		this.listOfBuilders.add(pb);
	}
	
	public List<ProductBuilder> getBuilders(){
		
		return this.listOfBuilders;
	}
	
	public ProductBuilder getBuilder(String productName ) {
		for(ProductBuilder pbr : listOfBuilders) {
			if(pbr.getProduct().getName().equals(productName)) {
			return pbr;
			}
		}
		return null;
	}
	public String getName() {
		return name;
	}
	
	

}
