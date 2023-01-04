package machine;

import java.util.Vector;

import javax.annotation.processing.SupportedSourceVersion;

import devices.Machine;
import softwareMachine.ModuleFactory;

import tuc.ece.cs201.vm.hw.device.Device;

public class VendingMachine {
	
    private Vector<Module> modules;//maybe i can use hashMap
	
	private static VendingMachine instance;
	
	private VendingMachine() {
		this.modules  = new Vector<>();
	}
	
	private VendingMachine(Machine machine) {
		this.modules  = new Vector<>();
		this.probeHardware(machine);
		
	}
	
	public void initMachine(Machine machine) {
		if (!modules.isEmpty())
			throw new AssertionError("Software Machine has already been initialized based on a HardwareMachine");
		probeHardware(machine);
		
	}
	
	public static VendingMachine getInstance() {
		if(instance!=null) {
			return instance;
		}
		else {
			instance = new VendingMachine();
		}
		
		return instance;
	}

	public void addModule(Module m) {
		this.modules.add(m);
	}
	
	private void probeHardware(Machine machine) {
		for(Device dev: machine.listDevices()) {
			this.addModule(ModuleFactory.createModule(dev));
		}
		
	}
	
	
	
	
	public Module  findModuleByName(String name) {
		Module mod = null;
		try {
		for(Module m : this.modules) {
			if(m.getDevice().getName().equalsIgnoreCase(name)) {
              mod = m;	
			}
		
		}
		
	}catch(NullPointerException e)
	{
		System.out.println("there is no module with this name");
	}
	return mod;

}
	
}
