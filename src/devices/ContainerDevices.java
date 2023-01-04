package devices;

import java.util.List;

import consumables.Consumable;
import tuc.ece.cs201.vm.hw.device.ContainerDevice;
import tuc.ece.cs201.vm.hw.device.Device;
import tuc.ece.cs201.vm.hw.device.DeviceType;

public class ContainerDevices extends Devices implements ContainerDevice{

	protected boolean opened;
	protected static int capacity = 300;
	protected Consumable content;
	// maybe  it is needed to put a member variable consumable
	
	public ContainerDevices(String name,DeviceType type,Consumable content) {
		super(name,type);
		this.opened = false;
		//this.capacity = capacity; 
		this.content = content;
		//content.setQuantity(capacity);
		
	}
	
	public ContainerDevices(String name,DeviceType type) {
		super(name,type);
		this.opened = false;
		//this.capacity = capacity; 
		
		
	}
	
     public Consumable getContent() {
			return content;
		}

	
	public void close() {
		this.opened = false;
		
	}


	public int getCapacity() {
		
	
		return capacity;
	}


	public boolean isOpen() {
	
		return opened;
	}

	
	public void open() {
	this.opened = true;
		
	}
	
	private   Consumable  findConsumable(String consumableName) {
		
		
		return null;
		
	}

}
