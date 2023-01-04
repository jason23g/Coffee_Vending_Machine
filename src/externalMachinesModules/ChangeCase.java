package externalMachinesModules;


import exceptions.LockedModuleException;
import machine.Module;
import tuc.ece.cs201.vm.hw.device.ChangeCaseDevice;


public class ChangeCase<T extends ChangeCaseDevice> extends Module<ChangeCaseDevice>{
	
	public ChangeCase (T chDevice) {
		super(chDevice);
	}
	
	public void setChange(int change) throws LockedModuleException{
		
		this.Device.unLock();
		if(this.Device.isLocked()) {
			throw new LockedModuleException("....");
		}
		this.Device.giveChange(change);
		this.Device.lock();
		
	
	}

	public void removeChange() throws LockedModuleException{
		
		this.Device.unLock();
		if(this.Device.isLocked()) {
			throw new LockedModuleException("....");
		}
		this.Device.removeChange();
		
		this.Device.lock();
		
		System.out.println(" Please take your change");
		
		
		
	}
	
	
}
