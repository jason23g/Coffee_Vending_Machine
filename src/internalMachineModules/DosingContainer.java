package internalMachineModules;


import consumables.Consumable;
import tuc.ece.cs201.vm.hw.device.DosingContainerDevice;
import devices.*;

public class DosingContainer extends Container{
	
	public DosingContainer(DosingContainerDevice dcDevice) {
		super(dcDevice);
	}
	
	/*public void provide(Consumer conRef,int quantity) {
		this.Device.open();
		
		if(!this.Device.isOpen()) {
			System.out.println("the dosing container is closed....");
		}
		
		if(quantity <= ((DosingContainerDevices)this.getDevice()).doseSize()) {
			((DosingContainerDevices)this.getDevice()).releaseDose(null);
		}
		else {
			
		}
		this.Device.close();
		
	}*/
	
	

}
