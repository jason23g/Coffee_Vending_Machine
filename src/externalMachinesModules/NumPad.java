package externalMachinesModules;

import consumables.Product;
import exceptions.LockedModuleException;
import machine.Module;
import tuc.ece.cs102.util.StandardInputRead;
import tuc.ece.cs201.vm.hw.device.NumPadDevice;



public class NumPad<T extends NumPadDevice> extends Module<NumPadDevice>{
	
	public NumPad( T npDevice) {
		super(npDevice);
	}

	public int  readCode(int length) throws LockedModuleException{
		 String code = "";
		
		this.Device.unLock();
		if(this.Device.isLocked()) {
			throw new LockedModuleException("the numPad device is locked");
		}
		
		
		
		 while(code.length() < length) {
			 StandardInputRead si = new StandardInputRead();
		        String digit = si.readString("give digit to complete the code of youre coffee ");
			 code += Device.readDigit(digit);
			 System.out.println(code);
		 }
		 System.out.println("the code of your coffee "+code);
		this.Device.lock();
		
		return (Integer.parseInt(code));
		
		/*Product pr = null;
		
		do {
			
			StandardInputRead si = new StandardInputRead();
	        String code = si.readString("give the code of the cofee you want  to order ");
	
	        if(code == pr.getCode()) {
	        	length =  Integer.parseInt(code);
	        	return length;
	        }
			
			
			
		}while(true);
		
		*/
		
		
	}
}
