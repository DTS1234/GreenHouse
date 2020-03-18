package uo.mp.s6;

import uo.mp.s6.greenhouse.GreenhouseController;
import uo.mp.s6.greenhouse.humidity.HumiditySensor;
import uo.mp.s6.greenhouse.temperature.AutomaticDoor;
import uo.mp.s6.greenhouse.temperature.ManualDoor;
import uo.mp.s6.greenhouse.temperature.TemperatureSensor;

/**
 * <p>Title: Application</p>
 * <p>Description: Class that executes the program.</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Computer Science Engineering School</p>
 * <p>Programming Methodology</p>
 * 
 * @author Lectures of Programming Methodology
 * @version 1.0
 */
public class Main {
	
	private GreenhouseController greenhouse;

	/**
	 * Main method that launches the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}

	private Main configure() {
		greenhouse = new GreenhouseController();
		
		for (int i = 0; i < 10; i++) {
			greenhouse.add( new TemperatureSensor(i) );
			greenhouse.add( new AutomaticDoor(i) );
			greenhouse.add(new HumiditySensor(i));
		}
		
		for (int i = 0; i < 10; i++) {
			greenhouse.add(new ManualDoor(i+10));
		}
		
		return this;
	}

	/**
	 * Method that executes the application.
	 */
	public void run() {
		greenhouse.start();
	}

}
