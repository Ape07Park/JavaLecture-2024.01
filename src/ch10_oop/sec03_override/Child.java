package ch10_oop.sec03_override;

public class Child extends Parent{
	int childField;
	
	void childMethod() {
		System.out.println("childMethod(): " + childField);
	}
	
	// override(메서드 제정의): 부모가 정의한 메소드를 자식이 새롭세 재정의 하는 것
	@Override 
	void parentMethod() {
//		System.out.println("Child가 새롭게 정의한 parentMethod(): " + parentField);
		System.out.print("Child가 새롭게 정의한");
		super.parentMethod(); // 그냥 super는 부모 의미. super()는 부모의 생성자 의미. this: 나 자신
	}

}
