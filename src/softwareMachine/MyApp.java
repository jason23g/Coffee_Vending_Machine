package softwareMachine;

import java.util.LinkedList;
import java.util.List;

import builder.CupCase;
import consumables.*;
import dao.FsRecipeDao;
import devices.*;
import exceptions.LockedModuleException;
import externalMachinesModules.*;
import internalMachineModules.ConsumableDispenser;
import internalMachineModules.Consumer;
import internalMachineModules.Container;
import internalMachineModules.Dispenser;
import internalMachineModules.IngredientProcessor;
import internalMachineModules.MaterialContainer;
import machine.VendingMachine;
import tuc.ece.cs201.vm.hw.device.DeviceType;
import recipe.OperateStep;
import recipe.Recipe;
import recipe.RecipeManager;
import recipe.RecipeStep;
import recipe.TransferStep;


public class MyApp {
	
	public static void main(String[] args) {
		
		Machine hMachine = new Machine();
		DispenserDevices dispDev = new DispenserDevices("Powders",DeviceType.DosingDispenser);
		dispDev.addContainer(new DosingContainerDevices("Coffee",DeviceType.DosingContainer,new PowderIngredient("coffee",100)));
		dispDev.addContainer(new DosingContainerDevices("Sugar",DeviceType.DosingContainer,new PowderIngredient("sugar",100)));
		DispenserDevices dispDev2 = new DispenserDevices("Liquids",DeviceType.FlowDispenser);
		dispDev2.addContainer(new FlowContainerDevices("milk",DeviceType.FlowContainer,new LiquidIngredient("milk",300)));
		dispDev2.addContainer(new FlowContainerDevices("water",DeviceType.FlowContainer,new LiquidIngredient("water",220)));
		DispenserDevices dispDev3 = new DispenserDevices("Cups",DeviceType.MaterialDispenser);
		dispDev3.addContainer(new MaterialContainerDevices("Big_Cup", DeviceType.MaterialContainer, new Cup("Big_Cup",0,"Big")));
		dispDev3.addContainer(new MaterialContainerDevices("Medium_Cup", DeviceType.MaterialContainer, new Cup("Medium_Cup",0,"Medium")));
		dispDev3.addContainer(new MaterialContainerDevices("Small_Cup", DeviceType.MaterialContainer, new Cup("Small_Cup",0,"Small")));
		hMachine.addDevices(dispDev);
		hMachine.addDevices(dispDev2);
		hMachine.addDevices(dispDev3);
		hMachine.addDevices(new ProcessorDevices("Mixer",DeviceType.Processor,new ProcessedIngredient("Blended")));
		hMachine.addDevices(new ProcessorDevices("Boiler",DeviceType.Processor,new ProcessedIngredient("Hot")));
		hMachine.addDevices(new ProcessorDevices("cooler",DeviceType.Processor,new ProcessedIngredient("Cold")));
		hMachine.addDevices(new FlowContainerDevices("Buffer",DeviceType.FlowContainer,new LiquidIngredient("water",14)));
		hMachine.addDevices(new NumPadDevices("NumPad",DeviceType.NumPad));
		hMachine.addDevices(new DisplayDevices("Display Panel",DeviceType.Display));
		hMachine.addDevices(new CoinAcceptorDevices("Coin Reader",DeviceType.CoinReader));
		hMachine.addDevices(new ChangeCaseDevices("Change Case",DeviceType.ChangeCase));
		hMachine.addDevices(new ProductCaseDevices("Product case",DeviceType.ProductCase));
		VendingMachine sm = VendingMachine.getInstance();
		sm.initMachine(hMachine); // We are allowed to call initMachine only once, otherwise an assertion is thrown
		
		// .....
		// .....
		
		VendingMachine sm1 = VendingMachine.getInstance();
		VendingMachine sm2 = VendingMachine.getInstance();
		// The getInstance returns every time the same single instantiation of SoftwareMachine
		DisplayPanel  display	= (DisplayPanel)sm.findModuleByName("Display Panel");
		NumPad numPad = (NumPad)sm.findModuleByName("NumPad");
		CoinReader coinReader = (CoinReader)sm.findModuleByName("Coin Reader");
		ChangeCase changeCase = (ChangeCase)sm.findModuleByName("Change Case");
		Recipe recipe = null;
		
		try {
			//FsRecipeDao rDao = new FsRecipeDao("recipes");
	        //List<Recipe> recipes = rDao.loadRecipes();
			RecipeManager rManager = new RecipeManager();
			rManager.loadRecipes();
			display.displayMsg("The drinks tha we can serve you are the following :");
			System.out.println("\nPlease Choose a Drink:");
			for (Recipe r: rManager.getRecipes()) {
				
				display.displayMsg(r.getName()+" " + r.getCode());
				
			}
			
			display.displayMsg("Please enter the code of your coffee you wish to order :");
			int code = numPad.readCode(3);
			int price = 0;
            for (Recipe r: rManager.getRecipes()) {
				
				if(r.getCode() == code) {
					 price = r.getCost();
					 recipe = r;
				}
				
			}
            
            display.displayMsg("The price of the product is " + price);
           
		int money = coinReader.receiveMoney(price);
         
		changeCase.setChange(money-price);
		changeCase.removeChange();
		display.displayMsg("Please wait for your coffee.....");
		
		LinkedList<Ingredient> ingredients = null;
		LinkedList<RecipeStep> recipeSteps = null;
		 Container container = null;
		ConsumableDispenser dispenser =null;
		IngredientProcessor processor = null;
		IngredientProcessor processor1 = null;
		CupCase cupCase = new CupCase("Cup Case");
		MaterialContainer materialContainer = null;
		ConsumableDispenser materialDispenser = null;
		
		for (Recipe r: rManager.getRecipes()) {
			
			if(r.getCode() == code) {
			 ingredients =  (LinkedList<Ingredient>) r.getIngredients();
				 recipeSteps = (LinkedList<RecipeStep>)r.getRecipeSteps();
			}
			
		}
        
		 TransferStep ts = null;
		 OperateStep os = null;
		
		for(RecipeStep r : recipeSteps) {
			if(Class.forName("recipe.TransferStep").isInstance(r)) {
				ts = (TransferStep)r;
           
        	   try {
        	   if(!ts.getFrom().equalsIgnoreCase("Cups")) {
        		   for(Ingredient i : ingredients) {
        		   if(ts.getWhat().equals(i.getName())) {
        	//we will use the method  provide	to transfer the consumables
        			     
        			  dispenser =  (ConsumableDispenser) sm.findModuleByName( ts.getFrom().toUpperCase());
        			  
        			// container =  (Container) dispenser.findContainerByName(ts.getWhat());
        			  
        	 container =  (Container) dispenser.prepareContainer(ts.getWhat().toUpperCase(), (Consumer)sm.findModuleByName( ts.getTo().toUpperCase()));
        	 
        	 
        	 
        		
        			 container.provide((Consumer)sm.findModuleByName(ts.getTo().toUpperCase()), ts.getQuantity());
        		   }
        			      }
        	   }
        	   
        	   
        			     else {
        			    	  materialDispenser = (ConsumableDispenser)sm.findModuleByName(ts.getFrom());
               	           
                	          materialContainer =  (MaterialContainer)materialDispenser.prepareContainer(ts.getWhat(),(Consumer)sm.findModuleByName(ts.getTo()));
                	           
                	          materialContainer.provide(cupCase,ts.getQuantity());
        			      }}catch(Exception e) {
        			    	  
        			      }
        			 
        		   
           
        		 try {
        			 
        			 
           processor = (IngredientProcessor)sm.findModuleByName(ts.getFrom());
           processor1 = (IngredientProcessor)sm.findModuleByName(ts.getTo());
           if(!ts.getTo().equalsIgnoreCase("CUP_CASE")) {
           processor.provide(processor1);
           }
           else
           {
        	   processor.provide(cupCase);
        	   
        	   
        	
        	   
        	   
           }
        		 }catch(Exception e) {
        			// System.out.println("problem.........");
        		 }
        		   
        		
        		
        	        		   
           
        		   
			}	   
        	   else if(Class.forName("recipe.OperateStep").isInstance(r)) {
        		   
        		   os= (OperateStep)r;
        		    
        		   processor = (IngredientProcessor)sm.findModuleByName(os.getProcessor());
        		   
        		   processor.process(os.getDuration());
        		   
        		//   System.out.println("you have now "+(IngredientProcessor)processor.getDevice().get);
        	   }
			
		}
		cupCase.prepareProduct("HOT",recipe.getName() , recipe.getCost());
		
		//System.out.println("we did it");
            
			
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch(LockedModuleException e1) {
			e1.printStackTrace();
		}catch(ClassNotFoundException e) {
			
		}
			
			
			
		}
		
	
}
		
	


