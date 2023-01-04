package devices;

import java.util.ArrayList;
import java.util.List;

import tuc.ece.cs201.vm.hw.HardwareMachine;
import tuc.ece.cs201.vm.hw.device.Device;

public class Machine implements HardwareMachine{
	
   ArrayList<Device> devs;
	
	public Machine() {
		this.devs = new ArrayList<>();
	}
	
	public void addDevices(Device d) {
		this.devs.add(d);
		
	}
	
	public String getModel() {
		String model ="";
		
		
		return model;
	}

	
	public List<Device> listDevices() {
		
		return this.devs;
	}

}
