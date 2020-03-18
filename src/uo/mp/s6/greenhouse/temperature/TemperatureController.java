package uo.mp.s6.greenhouse.temperature;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Lectures of Programming Methodology
 * @version 1.0
 */
public class TemperatureController {
	public static final double MAX_TEMPERATURE = 22;
	public static final double MIN_TEMPERATURE = 19;

	private List<TemperatureSensor> sensors = new ArrayList<>();
	private List<Door> doors = new ArrayList<>();

	public void add(TemperatureSensor sensor) {
		this.sensors.add(sensor);
	}

	public void add(Door door) {
		this.doors.add(door);
	}

	/**
	 * Handles the doors to keep the temperature under control
	 */
	public void monitor() {

		double temp = getAverageTemperature();

		System.out.println("actual temperature: " + temp);
		
		if (isToHot(temp)) {
			heat(temp);
		} else if (isToCold(temp)) {
			cool(temp);
		} else {
			System.out.println(sendMessage(temp, "Average temperature is "));
		}
		
	}

	private void heat(double temperature) {

		int doorsToBeOpened = (int) (temperature - MAX_TEMPERATURE) * 2;
		openDoors(doorsToBeOpened);

	}

	private void cool(double temperature) {

		int doorsToBeClosed = (int) (MIN_TEMPERATURE - temperature) * 2;
		closeDoors(doorsToBeClosed);

	}

	private boolean isToHot(double temp) {
		if(temp > MAX_TEMPERATURE && temp - MAX_TEMPERATURE >= 1) {
			return true;
		}
		return false;
	}
	
	private boolean isToCold(double temp) {
		
		if(temp < MIN_TEMPERATURE && MIN_TEMPERATURE - temp >= 1)
			return true;
		
		return false;
	}
	
	private String sendMessage(double doubleArg, String message) {

		String result = String.format(message + ": %d", (int) doubleArg);

		return result;
	}

	/**
	 * Gets the average temperature in the greenhouse.
	 * 
	 * @return The average temperature in the greenhouse.
	 */
	private double getAverageTemperature() {
		double addition = 0;
		for (TemperatureSensor sensor : sensors) {
			addition += sensor.getTemperature();
		}
		return addition / sensors.size();
	}

	private void openDoors(int numDoors) {

		int counter = 0;

		for (Door door : doors) {

			if (counter >= numDoors) {
				System.out.println(sendMessage(numDoors, "Number of doors to be opened: "));
				break;
			}

			if (!door.isOpened()) {
				door.open();
				counter++;
			}
		}

		if (counter < numDoors) {
			System.out.println("DANGER all doors are opened and it is still to HOT!!!");
		}
	}

	private void closeDoors(int numDoors) {

		int counter = 0;

		for (Door door : doors) {

			if (counter >= numDoors) {
				System.out.println(sendMessage(numDoors, "Number of doors to be closed: "));
				break;
			}

			if (door.isOpened()) {
				door.close();
				counter++;
			}
		}

		if (counter < numDoors) {
			System.out.println("DANGER all doors are closed and it is still to COLD !!!");
		}
	}


}
