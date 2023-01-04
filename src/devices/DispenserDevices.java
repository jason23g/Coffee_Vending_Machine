package devices;

import java.util.ArrayList;
import java.util.List;

import tuc.ece.cs201.vm.hw.device.ContainerDevice;
import tuc.ece.cs201.vm.hw.device.DeviceType;
import tuc.ece.cs201.vm.hw.device.DispenserDevice;

public class DispenserDevices extends Devices implements DispenserDevice<ContainerDevice>{

	
	protected String name;
	protected DeviceType type;
	
	protected ArrayList<ContainerDevice> listOfContainers;
	

	public DispenserDevices(String name,DeviceType type) {
		super(name,type);
		listOfContainers = new ArrayList<>();
	}
	


	public void addContainer(ContainerDevice cont) {
		this.connect(cont);
		this.listOfContainers.add(cont);
		
		
	}


	public List<ContainerDevice> listContainers() {
		
		return listOfContainers;
	}


	public void prepareContainer(ContainerDevice arg0) {
	   arg0.open();
	   this.connect(arg0);
	   
	   System.out.println("the "+this.getName()+" connected to "+arg0.getName());
	   
		
	}


	public void removeContainer(String arg0) {
	this.listOfContainers.remove(findContainerByName(arg0));
	this.disconnect(findContainerByName(arg0));
		
	}

	private ContainerDevice findContainerByName(String contName) {
		
		
		for(ContainerDevice contDev : listOfContainers) {
			if(contDev.getName().equals(contName)) {
				return contDev;
			}
			
			
		}
		return null;
		
	}



	


}
