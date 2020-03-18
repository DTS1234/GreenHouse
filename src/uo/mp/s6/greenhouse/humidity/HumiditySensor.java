package uo.mp.s6.greenhouse.humidity;

import java.util.Random;

import uo.mp.s6.scanner.Checkable;

public class HumiditySensor implements Checkable{

	private int id;
	
	public HumiditySensor(int id) {
		this.id = id;
	}

	public int getHumidity() {		
		return new Random().nextInt(100);		
	}
	
	@Override
	public boolean check() {
		return new Random().nextDouble() >= 0.005;
	}


	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "HumiditySensor [id=" + id + "]";
	}
	
	
	
}
