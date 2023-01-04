package devices;

import java.util.List;

import consumables.Ingredient;
import consumables.LiquidIngredient;
import tuc.ece.cs201.vm.hw.device.Device;
import tuc.ece.cs201.vm.hw.device.DeviceType;
import tuc.ece.cs201.vm.hw.device.FlowContainerDevice;

public class FlowContainerDevices extends ContainerDevices implements FlowContainerDevice{

	private static int velocity = 5;
	private LiquidIngredient li;
	
	public FlowContainerDevices(String name, DeviceType type,Ingredient li) {
		super(name, type,li);
		
	}

	public FlowContainerDevices(String name, DeviceType type) {
		super(name, type);
		
	}



	
	public void streamOut(Device dev) {
		
		System.out.println(li.getName()+" has been put into "+dev.getName());
	}


	public int streamRate() {
		
		return velocity;
	}

}
