package internalMachineModules;


import java.util.ArrayList;

import devices.ContainerDevices;
import machine.Module;
import tuc.ece.cs201.vm.hw.device.ContainerDevice;
import tuc.ece.cs201.vm.hw.device.DispenserDevice;


public class ConsumableDispenser<T extends Container> extends Module<DispenserDevice<ContainerDevice>> implements Dispenser{
	
	
	ArrayList<T> containers;
	private boolean isPlugged;
	public ConsumableDispenser( DispenserDevice dispDevice) {
		super(dispDevice);
		containers = new ArrayList<>();
		isPlugged =false; 
		
	}
	
	public Provider prepareContainer(String conName,Consumer conRef) {
		
		
		
		ContainerDevices contDev = this.findContainerDeviceByName(conName);
	
		this.Device.prepareContainer(contDev);
		//conRef.load(contDev.getContent());
		Container container = this.findContainerByName(contDev.getName());
		//container.provide(conRef);
		return container;
	}
	
	public void addContainer(Container container) {
		
		containers.add((T) container);
		
	}
	
	public Container removeContainer(String conName) {
		Container cont = null;
		ContainerDevice contDev =  null;
		
		contDev = this.findContainerDeviceByName(conName);
		for(Container c : containers) {
			if(c.getName() == contDev.getName()) {
				cont =c;
				containers.remove(c);
				return c;
			}
			
		}
		return null;
		
	}
	
	public int getCurrentQuanity(String contName) {
		
		
		ContainerDevices contDev =  null;
		
		contDev = this.findContainerDeviceByName(contName);
		
		return contDev.getContent().getQuantity();
		
			
		}
	
	
    public void plug(Consumer consumer) {
    	IngredientProcessor ingPro = (IngredientProcessor)consumer;
	     this.Device.connect(ingPro.getDevice());
	     isPlugged = true;
  }
	
	public void unPlug(Consumer consumer) {
		IngredientProcessor ingPro = (IngredientProcessor)consumer;
	     this.Device.disconnect(ingPro.getDevice());
	     isPlugged = false;
	}
	
	public void unPlugAll() {
		this.Device.disconnectAll();
		
	}
	
	public boolean isPlugged() {
		
		return isPlugged;
	}
	
	private ContainerDevices  findContainerDeviceByName(String name) {
		
		ContainerDevice cont = null;
		
		try {
			for(ContainerDevice con : this.getDevice().listContainers()) {
				
				if(con.getName().equalsIgnoreCase(name)) {
			         cont = con;
				}
			}
		}catch(NullPointerException e) {
			
		}
		return (ContainerDevices)cont;
		
	}
	
	//the access modifier must be private
	public Container findContainerByName(String name) {
		
         Container cont = null;
		
		try {
			for(Container con : containers) {
				
				if(con.getDevice().getName().equalsIgnoreCase(name)) {
			         cont = con;
				}
			}
		}catch(NullPointerException e) {
			
		}
		return cont;
		
	}
	
	

}
