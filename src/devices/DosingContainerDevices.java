

package devices;

import java.util.List;

import consumables.PowderIngredient;
import tuc.ece.cs201.vm.hw.device.Device;
import tuc.ece.cs201.vm.hw.device.DeviceType;
import tuc.ece.cs201.vm.hw.device.DosingContainerDevice;

public class DosingContainerDevices extends ContainerDevices implements DosingContainerDevice{

	private static int dose  = 10;
	private PowderIngredient pi;
	
	public DosingContainerDevices(String name, DeviceType type,PowderIngredient pi) {
		super(name, type,pi);
	
	}

	public DosingContainerDevices(String name, DeviceType type) {
		super(name, type);
	
	}
	


	public int doseSize() {
		
		return dose;
	}


	public void releaseDose(Device dev) {
		this.connect(dev);
		pi.setQuantity(pi.getQuantity() - dose);
		
		System.out.println("the quantity of "+dose+" "+pi.getName()+" ingredient has been put into "+dev.getName());
		
		
	}

}
