package uo.mp.s6.greenhouse;

import java.util.ArrayList;
import java.util.List;

import uo.mp.s6.greenhouse.humidity.HumidityController;
import uo.mp.s6.greenhouse.humidity.HumiditySensor;
import uo.mp.s6.greenhouse.scanner.Checkable;
import uo.mp.s6.greenhouse.scanner.DeviceScanner;
import uo.mp.s6.greenhouse.temperature.Door;
import uo.mp.s6.greenhouse.temperature.TemperatureController;
import uo.mp.s6.greenhouse.temperature.TemperatureSensor;

/**
 * <p>
 * Title: GreenHouse
 * </p>
 * <p>
 * Description: Class that simulates a greenhouse.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2012
 * </p>
 * <p>
 * Computer Science Engineering School
 * </p>
 * <p>
 * Programming Methodology
 * </p>
 * 
 * @author Lectures of Programming Methodology
 * @version 1.0
 */
public class GreenhouseController {
	private TemperatureController tempCtrl = new TemperatureController();
	private List<Checkable> devices = new ArrayList<Checkable>();
	private HumidityController hmCtrl = new HumidityController();

	public void add(TemperatureSensor sensor) {

		tempCtrl.add(sensor);
		devices.add(sensor);

	}

	public void add(HumiditySensor hsensor) {

		hmCtrl.add(hsensor);
		devices.add(hsensor);

	}

	public void add(Door door) {

		tempCtrl.add(door);

		if (door instanceof Checkable) {
			devices.add((Checkable) door);
		}

	}

	public void start() {
		while (true) {

			System.out.println("TEMPERATURE RAPORT: ");
			tempCtrl.monitor();
			System.out.println();
			System.out.println("HUMIDITY RAPORT: ");
			hmCtrl.monitorHumidity();
			System.out.println();
			System.out.println("DEVICES RAPORT: ");
			new DeviceScanner(devices).scan();
			System.out.println("-----------------------");
			sleep(2000);
		}
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// Ignore it
		}
	}

}
