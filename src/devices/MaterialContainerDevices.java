package devices;

import java.util.List;
import java.util.Vector;

import consumables.Cup;
import tuc.ece.cs201.vm.hw.device.Device;
import tuc.ece.cs201.vm.hw.device.DeviceType;
import tuc.ece.cs201.vm.hw.device.MaterialContainerDevice;

public class MaterialContainerDevices extends ContainerDevices implements MaterialContainerDevice{

	
	
	public MaterialContainerDevices(String name, DeviceType type,Cup cp) {
		super(name, type,cp);
		
	}


	
	
	public void releaseMaterial(Device dev) {
		
		System.out.println(this.getContent().getName()+" was put into "+dev.getType());
		
		
		
	}

}
