package ch12_interface.sec02_interface;

public class Main {

	public static void main(String[] args) {
		Audio audio = new Audio();
		audio.turnOn();
		audio.setVolume(12);
		audio.turnOff();
		
		Television tv = new Television();
		tv.turnOn();
		tv.setVolume(5);
		tv.turnOff();
		
		// 인터페이스도 다형성 방법으로 타입 부여 o
		
		// 구현 객체가 무엇이든 간에 동일한 코드 사용
		RemoteControllable rc = new Audio();
		rc.turnOn(); rc.setVolume(5); rc.turnOff();
		
		// 변수의 내용물만 변경  
		rc = new Television();
		rc.turnOn(); rc.setVolume(5); rc.turnOff();
		
		
		
	}

}
