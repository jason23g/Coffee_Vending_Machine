package externalMachinesModules;

import consumables.Consumable;
import consumables.Product;
import internalMachineModules.Consumer;
import machine.Module;
import tuc.ece.cs201.vm.hw.device.ProductCaseDevice;


public class ProductCase<T extends ProductCaseDevice> extends Module<ProductCaseDevice> implements Consumer{
	
	private Product pr;
	
	public ProductCase( T pcDevice) {
		super(pcDevice);
	}
	
	public Product getProduct() {
		return null;
	}
	
	public void load(Consumable con) {
		
	}

	public boolean accepts(Consumable consumable) {
		return true;
	}
}
