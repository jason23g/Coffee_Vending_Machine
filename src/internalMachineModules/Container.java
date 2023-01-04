package internalMachineModules;

import consumables.Consumable;
import devices.ContainerDevices;
import machine.Module;
import tuc.ece.cs201.vm.hw.device.ContainerDevice;
import builder.*;


public class Container extends Module<ContainerDevice> implements Provider{
	
	protected int capacity;
    
	
	private Consumable content;
	public boolean isPlugged;
	
	public Container(ContainerDevice conDevice){ 
		super(conDevice);
		//this.capacity = capacity;
		//this.content = content;
	    isPlugged = false;
		
	}
	
	public void  provide(Consumer confRef,int quantity) {
       this.Device.open();
		
		if(!this.Device.isOpen()) {
			System.out.println("the dosing container is closed....");
		}
		
	try {	
	  int  quantity1 = ((ContainerDevices)this.Device).getContent().getQuantity();
		
		quantity1 = quantity1 - quantity;
		
		
		
		((ContainerDevices)this.Device).getContent().setQuantity(quantity1);
		
		Consumable con = ((ContainerDevices )Device).getContent().clone();
		con.setQuantity(quantity);
		
		confRef.load(con);
		try {
		System.out.println(this.Device.getName()+" has provided "+quantity+" of "+
		((ContainerDevices)this.Device).getContent().getName()+" into the "+((IngredientProcessor)confRef).getName());
		}catch(Exception e) {
			System.out.println(this.Device.getName()+" has provided "+quantity+" of "+
					((ContainerDevices)this.Device).getContent().getName()+" into the "+((CupCase)confRef).getName());
		}
	}catch(CloneNotSupportedException e) {
		
	}
		this.Device.close();
		}
	
	
	
	public void provide(Consumer conRef){
     this.Device.open();
		
		if(!this.Device.isOpen()) {
			System.out.println("the container is closed....");
		}
		
		conRef.load(((ContainerDevices )Device).getContent());
		try {
		System.out.println("The "+this.Device.getName()+" has  provided with "+((ContainerDevices )Device).getContent().getQuantity()+" of "
		+((ContainerDevices )this.Device).getContent().getName()+" into "+ ((IngredientProcessor)conRef).getName());
		}catch(Exception e) {
			System.out.println("The "+this.Device.getName()+" has  provided with "+((ContainerDevices )Device).getContent().getQuantity()+" of "
					+((ContainerDevices )this.Device).getContent().getName()+" into "+ ((CupCase)conRef).getName());
		}
		 this.Device.close();
		
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

	

	public int getCapacity() {
		return this.Device.getCapacity();
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Consumable getContent() {
		return content;
	}

	public void setContent(Consumable content) {
		this.content = content;
	}
	
	
}
