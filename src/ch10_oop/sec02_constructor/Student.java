package ch10_oop.sec02_constructor;

public class Student extends Person{
	int studentId;
	
	public Student(String name, int age, int studentId) {
		super(name, age); // super로 부모의 생성자와 필드들 호출
		
		// TODO Auto-generated constructor stub
		this.studentId = studentId;
	}
	
	void study() {
		System.out.println(name + "공부를 한다");
	}

}
