package machine;

import tuc.ece.cs201.vm.hw.device.Device;

public abstract class Module<T extends Device> {
	
	
	
	protected T Device;
	protected String name;
	
	public Module( T dev) {
		this.name = name;
		Device = dev;
	}

	public String getName() {
		return Device.getName();
	}
	
	public T getDevice() {
		return (T)Device;
	}
	
	
	

}
