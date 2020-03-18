package uo.mp.s6.scanner;

import java.util.List;

public class DeviceScanner {
	
	List<Checkable> devices;
	
	public DeviceScanner(List<Checkable> devices) {
		this.devices = devices;
	}

	public void scan() {
		
		int counter = 0;
		
		for(Checkable device : devices) {
			boolean goodState = device.check();
			if(! goodState ) {
				warnFailure(device);
				counter++;
			}
		}
		
		if(counter == 0) {
			System.out.println("Everything is working good.");
		}
		
	}
	
	private void warnFailure(Checkable device) {
		System.out.println("WARNING the device " +  device);
	}
	
}
