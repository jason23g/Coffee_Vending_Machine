package devices;

import java.util.List;

import consumables.Cup;
import consumables.Material;
import consumables.Product;
import tuc.ece.cs201.vm.hw.device.Device;
import tuc.ece.cs201.vm.hw.device.DeviceType;
import tuc.ece.cs201.vm.hw.device.ProductCaseDevice;

public class ProductCaseDevices extends LockableDevices implements  ProductCaseDevice{
	
	private Product prd;
	private Cup cp;
	
	public ProductCaseDevices(String name,DeviceType type) {
		super(name,type);
	}

	
	

	
	public void loadIngredient(String ingredientName) {
	   
		System.out.println(ingredientName+" has been loaded");
		
		
	}

	
	public void putMaterial(String arg0) {
		
		
	}
	
	

}
