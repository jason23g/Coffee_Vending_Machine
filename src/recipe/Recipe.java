package recipe;

import exceptions.MalformedRecipeException;

import java.util.*;



import consumables.Ingredient;
import consumables.LiquidIngredient;
import consumables.PowderIngredient;

public class Recipe {
    private String name;
    private int code;
    private int cost;    
    private boolean active;
    private String type;
    private LinkedList<RecipeStep> steps;
    private LinkedList<Ingredient> ingredients;

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Recipe() {
        this.active=true;
        this.steps = new LinkedList<>();    
        this.ingredients = new LinkedList<>();
        type = "DefaultDrink";
    }

    public Recipe(String name) {
        this();
        this.name = name;
    }

    public Recipe(String name, int code) {
        this(name);
        this.code = code;
    }

    public Recipe(int code){
        this();
        this.code=code;
    }

    public Recipe(String name, int code, int cost) {
        this(name,code);
        this.cost = cost;

    }

    public Recipe(String name, int code, int cost, String type) {
        this(name, code, cost);
        this.type = type;
    }
    
    public void addIngredient(Ingredient i) {
        this.ingredients.add(i);
    }

    public List<Ingredient> getIngredients(){
        return this.ingredients;
    }
    
    public List<RecipeStep> getRecipeSteps(){
    	return this.steps;
    }

    public void addStep(RecipeStep step) {
        this.steps.add(step);
    }

    public boolean isEnabled() {
        return active;
    }

    public void enable() {
        this.active = true;
    }

    public void disable(){
        this.active=false;
    }

    public boolean hasMoreSteps() {
        return false;
    }

    public RecipeStep getNextStep() {      
            return null;      
    }

    public void unMarshal(String recipeTxt) throws MalformedRecipeException {
    	
    	
    	
    	
    	System.out.println("\nUnmarshaling Recipe from text: ");
    	System.out.println("|----------------------------------------------------------|");
    	//System.out.println(recipeTxt);
    	this.name = recipeTxt.substring(recipeTxt.indexOf("NAME:")+5, recipeTxt.indexOf("\n"));
    	//System.out.println("the first test");
    	recipeTxt = recipeTxt.substring(recipeTxt.indexOf("TYPE:"),recipeTxt.length());
    	//System.out.println("the second test");
    	this.type = recipeTxt.substring(recipeTxt.indexOf("TYPE:")+5, recipeTxt.indexOf("\n"));
    	//System.out.println("the third test");
    	recipeTxt = recipeTxt.substring(recipeTxt.indexOf("PRICE:"),recipeTxt.length());
    	//System.out.println("the fourth test");
    	this.cost = Integer.parseInt(recipeTxt.substring(recipeTxt.indexOf("PRICE: ")+7, recipeTxt.indexOf("\n")));
    	//System.out.println("the fifth test");
    	recipeTxt = recipeTxt.substring(recipeTxt.indexOf("INGREDIENTS:")+13,recipeTxt.length());
    	String tmp = recipeTxt.substring(0,recipeTxt.indexOf("\n"));
       // System.out.println("the sixth test");
    	String str = "";
    	String str1 = "";
    	while(tmp != "\n") {
    		
    		//System.out.println("the seven test");
    		str = tmp.substring(0, 3);
    		tmp = tmp.substring(tmp.indexOf(":")+1, tmp.length());
    		if((str.equals("PWD"))){
    			str1 = tmp.substring( 0, tmp.indexOf(":"));
    			
    			this.addIngredient(new PowderIngredient(str1,
    					Integer.parseInt(tmp.substring( tmp.indexOf(":")+ 1,tmp.indexOf(",")))));
    			tmp = tmp.substring(tmp.indexOf(",")+1,tmp.length());
    		}
    		else if(str.equals("LIQ")){
    			str1 = tmp.substring( 0, tmp.indexOf(":"));
    			
    			//this.addIngredient(new LiquidIngredient(str1,
    					//Integer.parseInt(tmp.substring( tmp.indexOf(":")+ 1,tmp.indexOf(",")))));
    			
    			try {
    				this.addIngredient(new LiquidIngredient(str1,
        					Integer.parseInt(tmp.substring( tmp.indexOf(":")+ 1,tmp.indexOf(",")))));
    				
    			}catch(StringIndexOutOfBoundsException e) {
    				this.addIngredient(new LiquidIngredient(str1,
        					Integer.parseInt(tmp.substring( tmp.indexOf(":")+ 1,tmp.length()))));
    				
    			}
    			tmp = tmp.substring(tmp.indexOf(",")+1,tmp.length());
    			
    		}
    		else {
    			tmp = "\n";
    		}
    		
    		
    	}
    	
    	
    	
    	recipeTxt = recipeTxt.substring(recipeTxt.indexOf("RECIPE STEPS:")+13,recipeTxt.length());
    	//i have problem
    	String tmp1 = recipeTxt.substring(1,recipeTxt.length());
    	String str0 ="";
    	String str2 ="";
    	String str3 ="";
    	String str4 ="";
    	while(tmp1 != null) {
    		str = tmp1.substring(0,8);
    		str0 = tmp1.substring(0,7);
    		if(str.equals("TRANSFER")) {
    			
    			
    			try {
    			str1= tmp1.substring(tmp1.indexOf(" ")+1, tmp1.indexOf('\n'));
    			
    			str2 = str1.substring(0, str1.indexOf(" "));
    			str1 = str1.substring(str1.indexOf(" ")+1, str1.length());
    			str3 = str1.substring(0, str1.indexOf(" "));
    			str1 = str1.substring(str1.indexOf(" ")+1,str1.length());//wrong
    			str4 = str1.substring(0,str1.indexOf(" "));
    			str1 = str1.substring(str1.indexOf(" ")+1,str1.length());
    			
    			
    			this.addStep(new TransferStep(str2,str3,str4,Integer.parseInt(str1)));
    			

    			tmp1 = tmp1.substring(tmp1.indexOf("\n")+1, tmp1.length());
    			
    			}catch(Exception e) {
    				
    				str1= tmp1.substring(tmp1.indexOf(" ")+1, tmp1.length());
    				
    				str2 = str1.substring(0, str1.indexOf(" "));
        			str1 = str1.substring(str1.indexOf(" ")+1, str1.length());
        			str3 = str1.substring(0, str1.indexOf(" "));
        			str1 = str1.substring(str1.indexOf(" ")+1,str1.length());//wrong
        			str4 = str1.substring(0,str1.indexOf(" "));
        			str1 = str1.substring(str1.indexOf(" ")+1,str1.length());
        			
        			
        			this.addStep(new TransferStep(str2,str3,str4,Integer.parseInt(str1)));
    				
    				
    				
    				
    				tmp1 = null;
    			}
    				//str1= tmp1.substring(tmp1.indexOf(" ")+1, tmp1.length());
    			
    			
    			
    			
    			
    			
    		}
    		else if(str0.equals("OPERATE")) {
    			
    			str1= tmp1.substring(tmp1.indexOf(" ")+1, tmp1.indexOf("\n"));
    			str2 = str1.substring(0, str1.indexOf(" "));
    			str1 = str1.substring(str1.indexOf(" "), str1.length());
    			str3 = str1.substring(str1.indexOf(" ")+1, str1.length());
    			
    			this.addStep(new OperateStep(str2,Integer.parseInt(str3)));
    			
    			tmp1 = tmp1.substring(tmp1.indexOf("\n")+1, tmp1.length());
    			
    			
    			
    		}
    		else {
    			tmp1 = null;
    		}
    		
    		
    	}
    	
    	
         //System.out.println(recipeTxt);
    	System.out.println("|----------------------------------------------------------|");
    	
    }
    
    public String marshal() {
    	 StringBuilder sb=new StringBuilder("");
         sb.append("NAME: ").append(this.name).append("\n");
         sb.append("TYPE: ").append(this.type).append("\n");
         sb.append("PRICE: ").append(this.cost).append("\n");
         sb.append("INGREDIENTS: ");
         for (Ingredient i : this.ingredients){
             if (i instanceof PowderIngredient){
                 sb.append("PWD:");
             }else{
                 sb.append("LIQ:");
             }
             sb.append(i.getName()).append(":").append(i.getQuantity()).append(",");
         }
         sb.delete(sb.lastIndexOf(","),sb.length());
         return sb.toString();
    }
    

    public void print(){
        System.out.println(this.type + ": "+ this.name + ", Price: " + this.cost);
        for (RecipeStep step : steps) {
            step.print();
        }
    }

}