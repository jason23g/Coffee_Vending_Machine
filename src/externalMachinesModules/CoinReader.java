package externalMachinesModules;


import exceptions.LockedModuleException;
import machine.Module;
import tuc.ece.cs102.util.StandardInputRead;
import tuc.ece.cs201.vm.hw.device.CoinAcceptorDevice;



public class CoinReader <T extends CoinAcceptorDevice> extends Module<CoinAcceptorDevice>{
	
	//int money = 0;
	int remain = 0;
	
	
	public CoinReader( T dev) {
		super(dev);
	}

	public int receiveMoney(int min) throws LockedModuleException{
		int money = 0;
		int sum =0;
		this.Device.unLock();
		
		if(this.Device.isLocked()) {
			throw new LockedModuleException("....");
		}
		
		while(sum < min) {
			StandardInputRead sr = new StandardInputRead();
			money = sr.readPositiveInt("give the money for the product");
			sum += Device.acceptCoin(money);
		}
		System.out.println("thank you for your purchase");
		this.Device.lock();
		
		
		return  sum;
		
		
		
	}
	
	
}
