package uo.mp.s6.greenhouse.humidity;

public enum IrrigationSystem {
	
	OFF(0), FIRST(1), SECOND(2), THIRD(3);
	
	private int irrigationlevel;
	
	IrrigationSystem(int level) {
		irrigationlevel = level;
	}

	public int getIrrigationlevel() {
		return irrigationlevel;
	}
	
	public void setFull() {
		System.out.println("Setting irigation full");
		irrigationlevel = 3;
	}
	
	public void setOff() {
		System.out.println("Setting irigation off");
		irrigationlevel = 0;
	}
	
	public void increase() {
		switch (this.getIrrigationlevel()) {

		case (0):
			this.irrigationlevel = 1;
			break;
		case (1):
			this.irrigationlevel = 2;
			break;
		case (2):
			this.irrigationlevel = 3;
		case (3):
			System.out.println("DANGER it is still dry and irrigation level is turned up on max");
			break;
		default:
			reportIrrigationLevel();
		}
	}
	
	public void decrease() {
		switch (this.getIrrigationlevel()) {
		case (2):
			this.irrigationlevel = 1;
			break;
		case (3):
			this.irrigationlevel = 2;
			break;
		case (1):
			this.irrigationlevel = 0;
		case (0):
			System.out.println("DANGER humidity level is to big even though irrigation level is turned OFF");
			break;
		default:
			reportIrrigationLevel();
		}
	}
	
	private void reportIrrigationLevel() {
		System.out.println("Irrrigation level : " + this);
	}
	
}
