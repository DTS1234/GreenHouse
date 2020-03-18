package uo.mp.s6.greenhouse.humidity;

import java.util.ArrayList;
import java.util.List;

public class HumidityController {

	private static final int MAX_HUMIDITY = 70;
	private static final int MIN_HUMIDITY = 20;

	private List<HumiditySensor> sensors = new ArrayList<HumiditySensor>();
	private IrrigationSystem irrigationLevel = IrrigationSystem.OFF;

	public void add(HumiditySensor sensor) {
		sensors.add(sensor);
	}

	public void monitorHumidity() {

		double humidity = getAverageHumidity();
		System.out.printf("Right now humidity is equal to %d. \n", (int)humidity);

		if (isTooHigh(humidity)) {

			irrigationLevel.setOff();
			
		} else if (isTooLow(humidity)) {
			
			irrigationLevel.setFull();

		} else if (isToHumid(humidity)) {

			irrigationDown();
			
		} else if (isToDry(humidity)) {

			irrigationUp();
			
		} else {

			System.out.println("Humidity is right.");
		}

	}

	private boolean isToHumid(double humidity) {
		if (humidity > MAX_HUMIDITY && humidity - MAX_HUMIDITY >= 1) {
			return true;
		}
		return false;
	}

	private boolean isTooHigh(double humidity) {
		if (isToHumid(humidity) && humidity >= (MAX_HUMIDITY + 0.2 * MAX_HUMIDITY)) {
			return true;
		}
		return false;
	}

	private boolean isTooLow(double humidity) {
		if (isToDry(humidity) && humidity <= (MIN_HUMIDITY - 0.2 * MIN_HUMIDITY)) {
			return true;
		}
		return false;
	}

	private boolean isToDry(double humidity) {
		if (MIN_HUMIDITY > humidity && MIN_HUMIDITY - humidity >= 1) {
			return true;
		}
		return false;
	}

	private double getAverageHumidity() {

		double sum = 0;
		double result = 0;

		for (HumiditySensor hs : sensors) {
			sum += hs.getHumidity();
		}

		result = sum / sensors.size();

		return result;
	}

	private void irrigationUp() {

		irrigationLevel.increase();
	}

	private void irrigationDown() {

		irrigationLevel.decrease();
	}
	
	
}