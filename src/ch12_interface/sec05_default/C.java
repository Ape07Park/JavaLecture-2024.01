package ch12_interface.sec05_default;

public class C implements A {

	@Override
	public void abc() {
		System.out.println("C에서 abc() 실행");
	}

	@Override
	public void def() {
		
		A.super.def();
		System.out.println("C에서 def()를 수정했음");
	}	
}
