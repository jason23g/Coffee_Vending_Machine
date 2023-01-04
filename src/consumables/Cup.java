package consumables;

public class Cup extends Material{
	
	private String size;
	
	
	public Cup(String name, int quantity,String size) {
        super(name,quantity);
        this.size = size;
		
	}

	public String getSize() {
		return size;
	}

	
}
