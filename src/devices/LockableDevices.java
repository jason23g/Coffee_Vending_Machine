package devices;

import java.util.List;

import tuc.ece.cs201.vm.hw.device.Device;
import tuc.ece.cs201.vm.hw.device.DeviceType;
import tuc.ece.cs201.vm.hw.device.LockableDevice;

public class LockableDevices extends Devices implements LockableDevice{

	protected boolean locked;

	public LockableDevices(String name, DeviceType type) {
		super(name, type);
		locked = true;
	
	}



	
	public boolean isLocked() {
		
		return locked;
	}

	
	public void lock() {
		this.locked = true;
		
	}

	
	public void unLock() {
		this.locked = false;
		
	}

}
