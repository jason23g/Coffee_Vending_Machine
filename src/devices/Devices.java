package devices;

import java.util.ArrayList;
import java.util.List;

import tuc.ece.cs201.vm.hw.device.Device;
import tuc.ece.cs201.vm.hw.device.DeviceType;

public   class Devices implements Device{
	
	//do it constructor
	protected String name;
	protected DeviceType type;
	protected ArrayList<Device> listOfDevices ;
	
	public Devices(String name,DeviceType type) {
		this.name = name;
		this.type = type;
		listOfDevices = new ArrayList<Device>();
		
	}

	
	public void connect(Device dev) {
		this.listOfDevices.add(dev);
		System.out.println("The "+dev.getType().name()+" has connected to "+this.type.name());
	}

	
	public void disconnect(Device dev) {
		
		this.listOfDevices.remove(dev);
		System.out.println("The "+dev.getType().name()+" has disconnected to "+this.type.name());
	}

	
	public void disconnectAll() {
		
		for(Device dev : listOfDevices) {
			this.listOfDevices.remove(dev);	
		}
		System.out.println("all the devices has disconnected from the"+this.type.name());
	}

	
	public String getName() {
		
		return this.name;
	}


	public DeviceType getType() {
		
		return this.type;
	}

	
	public List<Device> listConnectedDevices() {
		
		return listOfDevices;
	}
	
	

}
