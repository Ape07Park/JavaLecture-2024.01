package ch10_oop.sec03_override;

public class Main {

	public static void main(String[] args) {
		// 부모
		Parent parent = new Parent();
		parent.parentField = 1000;
		parent.parentMethod();
		
		// 자식
		Child child = new Child();
		
		child.childField = 300;
		child.parentField = 600;
		
		child.childMethod();
		child.parentMethod();
		
		// 다형성 
		Parent p = new Child();
		// 다운케스팅?
		Child c = (Child) new Parent();

	}

}
