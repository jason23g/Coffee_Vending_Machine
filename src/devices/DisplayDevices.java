package devices;




import tuc.ece.cs201.vm.hw.device.DeviceType;
import tuc.ece.cs201.vm.hw.device.DisplayDevice;

public class DisplayDevices extends Devices implements DisplayDevice{
	
	
	
	
	public DisplayDevices(String name,DeviceType type) {
		super(name,type);
	}

	
	
	
	public void clear() {
		  System.out.println("Clearing Screen...");
	        final String ANSI_CLS = "\u001b[2J";
	        final String ANSI_HOME = "\u001b[H";
	        System.out.print(ANSI_CLS + ANSI_HOME);
	        System.out.flush();
		
	}


	public void displayMsg(String arg0) {
		
		System.out.println(arg0);
	}

}
