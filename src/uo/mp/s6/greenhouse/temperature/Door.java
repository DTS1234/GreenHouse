package uo.mp.s6.greenhouse.temperature;

/**
 * <p>Title: Door</p>
 * <p>Description: Class that simulates a door.</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author Lectures of Programming Methodology
 * @version 1.0
 */
public abstract class Door {

	private boolean opened = false;
	private int id;
	
	public Door(int id) {
		this.id = id;
	}

	public boolean isOpened() {
		return this.opened;
	}
	
	public void open(){
		if ( ! opened) {
			showOpeningMessage();
			opened = true;
		}
	}

	public void close(){
		if ( opened) {
			showClosingMessage();
			opened = false;
		}
	}

	abstract void showOpeningMessage();
	abstract void showClosingMessage();

	public int getId() {
		return id;
	}
	
}
