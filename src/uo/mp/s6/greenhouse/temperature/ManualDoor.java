package uo.mp.s6.greenhouse.temperature;

public class ManualDoor extends Door {	
	
	public ManualDoor(int id) {
		super(id);
	}
	
	@Override	
	public void showOpeningMessage() {
		System.out.println ("  Please, open the door " + getId());
	}
	
	@Override
	public void showClosingMessage() {
		System.out.println ("  Please, close the door " + getId());
	}

	
}
