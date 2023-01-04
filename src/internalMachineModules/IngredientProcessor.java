package internalMachineModules;

import consumables.Consumable;
import consumables.Ingredient;
import devices.ProcessorDevices;
import tuc.ece.cs201.vm.hw.device.ProcessorDevice;


public class IngredientProcessor extends FlowContainer implements Processor{
	
	public IngredientProcessor(ProcessorDevice prDevice) {
		super(prDevice);
	}
	
	public void process(int duration) {
		try {
	              ((ProcessorDevice)this.Device).operateStart();
		Thread.sleep(duration*1000);
		
		System.out.println("your product is being prepared...");
		((ProcessorDevice)this.Device).operateStop();
		
		}catch(InterruptedException e) {
			
		}
	}
	
	public void load(Consumable con) {
		//((ProcessorDevices)Device).getContent().setQuantity(con.getQuantity() + ((ProcessorDevices)Device).getContent().getQuantity());
		
		((ProcessorDevices)Device).getProcessedIngredient().addIngredient((Ingredient)con);
		
	}
	
	public boolean accepts(Consumable consumable) {
		if(((ProcessorDevices)Device).getContent().equals(consumable)){
		return true;
		}
		return false;
	}
}
