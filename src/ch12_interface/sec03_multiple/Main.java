package ch12_interface.sec03_multiple;

import ch12_interface.sec02_interface.RemoteControllable;

public class Main {

	public static void main(String[] args) {
		// up casting 
		RemoteControllable rc = new SmartTV();
		rc.turnOn();
		rc.setVolume(9);
		rc.turnOff();
		
		// up casting
		Searchable sc = new SmartTV();
		sc.search("youtube");
		
		
		SmartTV stv = new SmartTV();
		stv.turnOn();
		stv.setVolume(9);
		stv.search("daum");
		stv.turnOff();
		
		
	}

}
