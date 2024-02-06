package ch10_oop.sec01_Person;

public class Student extends Person {
	int studentID;

	void study() {
		System.out.println(name + "공부를 한다");
	}
}
