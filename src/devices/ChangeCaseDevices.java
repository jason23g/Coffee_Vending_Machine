package devices;

import java.util.List;

import consumables.Product;
import tuc.ece.cs201.vm.hw.device.ChangeCaseDevice;
import tuc.ece.cs201.vm.hw.device.DeviceType;

public class ChangeCaseDevices  extends LockableDevices implements ChangeCaseDevice{
	
	
	private int change = 0;
	
	
	
	public ChangeCaseDevices(String name, DeviceType type) {
    super(name,type);		
		
	}



	public void giveChange(int sum) {
		//change = sum - prd.getCost();  //the check of the result it will be in software
		System.out.println("your refund is "+sum);
		//this.removeChange();
	}


	public void removeChange() {
		change = 0;
		
	}



	
	

}
