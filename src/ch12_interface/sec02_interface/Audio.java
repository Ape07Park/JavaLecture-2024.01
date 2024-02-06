package ch12_interface.sec02_interface;

public class Audio implements RemoteControllable {
	private int volume;
	
	// 인터페이스의 3가지 메서드 오버라이드 
	@Override
	public void turnOn() {
		System.out.println("Audio 켜짐");
		
	}

	@Override
	public void turnOff() {
		
		System.out.println("Audio 꺼짐");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if(volume > RemoteControllable.MAX_VOLUME) {
			this.volume = RemoteControllable.MAX_VOLUME;
		}else if (volume < RemoteControllable.MIN_VOLUME) {
			this.volume = RemoteControllable.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		
		System.out.println("현재 Audio 볼륨 :" + this.volume );
	}

}
