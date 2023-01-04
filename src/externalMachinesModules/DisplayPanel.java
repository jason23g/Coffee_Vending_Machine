package externalMachinesModules;


import machine.Module;
import tuc.ece.cs201.vm.hw.device.DisplayDevice;


public class DisplayPanel extends Module<DisplayDevice>{
	
	public DisplayPanel( DisplayDevice disDevice) {
		super(disDevice);
	}

	public void displayMsg(String msg) {

		
		this.Device.displayMsg(msg);
		
		//System.out.println(msg);
		
	}
	
	public void clear() {
		this.Device.clear();
	}
	
	
}
