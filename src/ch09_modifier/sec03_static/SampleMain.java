package ch09_modifier.sec03_static;

public class SampleMain {

	public static void main(String[] args) {
		// 인스턴스 필드, 메서드를 사용하는 방법
		Sample sample = new Sample();

		System.out.println(sample.instanceFeild);
		sample.instanceMethod();
		
		// 스태틱 필드, 메소드 사용법, 거의 안씀 
		System.out.println(sample.STATIC_FIELD);
		sample.staticMethod();
	}

}
