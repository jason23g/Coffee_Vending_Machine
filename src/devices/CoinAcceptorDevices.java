package devices;

import java.util.List;

import tuc.ece.cs201.vm.hw.device.CoinAcceptorDevice;
import tuc.ece.cs201.vm.hw.device.Device;
import tuc.ece.cs201.vm.hw.device.DeviceType;

public class CoinAcceptorDevices extends LockableDevices  implements CoinAcceptorDevice{
	
	
	
	public CoinAcceptorDevices(String name,DeviceType type) {
		super(name,type);
		
	}

	
	
	public int acceptCoin(int coin) {
		
		int sum = 0;
	
		sum += coin;
		
		System.out.println("you have paid "+sum);
		
		
		return sum;
	}
	
	

}
