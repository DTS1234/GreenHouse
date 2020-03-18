package uo.mp.s6.greenhouse.temperature;

import java.util.Random;

import uo.mp.s6.greenhouse.scanner.Checkable;

public class AutomaticDoor extends Door implements Checkable {

	public AutomaticDoor(int id) {
		super(id);
		
	}

	@Override
	public boolean check() {
		return new Random().nextDouble() >= 0.005;
	}

	@Override
	void showOpeningMessage() {
		System.out.println ("  Automatically, opened the door " + getId());
	}

	@Override
	void showClosingMessage() {
		System.out.println ("  Automatically, closed the door " + getId());
	}

	@Override
	public String toString() {
		return "AutomaticDoor ["+ getId() +"]";
	}
	
	
	
	
}
