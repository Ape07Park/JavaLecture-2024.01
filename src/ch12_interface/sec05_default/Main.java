package ch12_interface.sec05_default;
// default 메소드 사용 잘 안함

public class Main {

	public static void main(String[] args) {
		A a = new B();
		a.abc();
		a.def();
		
		a = new C();
		a.abc();
		a.def();
		
		A.ghi();
	}

}
