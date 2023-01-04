package devices;

import java.util.List;

import tuc.ece.cs201.vm.hw.device.Device;
import tuc.ece.cs201.vm.hw.device.DeviceType;
import tuc.ece.cs201.vm.hw.device.NumPadDevice;

public class NumPadDevices extends LockableDevices implements NumPadDevice{
	
	
	
	public NumPadDevices(String name,DeviceType type) {
		super(name,type);
		
	}

	
	

	
	public int readDigit(String str) {
		
		
		
		return (Integer.parseInt(str));
	}

}
