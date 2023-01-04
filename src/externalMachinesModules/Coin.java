package externalMachinesModules;

public enum Coin {
	
	EURO2("1 euro",2), EURO1("2 euro",1), CENT50(" 50 cents",0.50), CENT20("20 cents",0.20), CENT10("10 cents",0.10), CENT5("5 cents",0.05), CENT2("2 cents",0.02), CENT1("1 cent",0.01);
	
	 private double cost;
	 private String coinName;
	   
	    private Coin(String coinName,double cost){
	        this.cost = cost;
	        this.coinName = coinName;
	    }
	   
	    public double getCost(){
	        return cost;
	    }

	    
	    public String getCoinName() {
	    	return coinName;
	    }
       


	

}
