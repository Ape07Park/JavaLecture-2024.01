package ch12_interface.sec03_multiple;

import ch12_interface.sec02_interface.RemoteControllable; // 2개의 인터페이스 상속 받음 

public class SmartTV implements RemoteControllable, Searchable {

	private int volume;

	@Override
	public void search(String url) {

		System.out.println(url + "을 검색");
	}

	@Override
	public void turnOn() {
		System.out.println("TV 켜짐");

	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV 꺼짐");
	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControllable.MAX_VOLUME) {
			this.volume = RemoteControllable.MAX_VOLUME;
		} else if (volume < RemoteControllable.MIN_VOLUME) {
			this.volume = RemoteControllable.MIN_VOLUME;
		} else {
			this.volume = volume;
		}

		System.out.println("현재 TV 볼륨 :" + this.volume);
	}

}
