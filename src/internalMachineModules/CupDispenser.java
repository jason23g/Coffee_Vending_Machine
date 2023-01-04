package internalMachineModules;


import machine.Module;
import tuc.ece.cs201.vm.hw.device.DispenserDevice;


public class CupDispenser<T extends DispenserDevice> extends Module<DispenserDevice>  implements Dispenser{
	
	public CupDispenser(T dispDevice) {
		super(dispDevice);
		
	}
	
	public Provider prepareContainer(String conName,Consumer conRef) {
		return null;
	}
		
		public void addContainer(Container container) {
			
		}
		
		public Container removeContainer(String conName) {
			return null;
		}
		
		public int getCurrentQuanity(String contName) {
			return 0;
		}
		
	    public void plug(Consumer consumer) {
		
	  }
		
		public void unPlug(Consumer consumer) {
			
		}
		
		public void unPlugAll() {
			
		}
		
		public boolean isPlugged() {
			return true;
		}

}
