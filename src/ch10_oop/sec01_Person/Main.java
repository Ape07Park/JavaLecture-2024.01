package ch10_oop.sec01_Person;

public class Main {

	public static void main(String[] args) {
		// Person 객체 생성
		Person person = new Person();
		person.name = "제임스";
		person.age = 25;
		person.eat();
		person.sleep();
		
		System.out.println();
		
		// Student 객체 생성(부모의 필드와 메서드를 쓸 수 있음)
		Student student = new Student();
		student.name = "maria";
		student.age = 22;
		student.studentID = 1234;	
		student.eat();
		student.sleep();
		student.study();
		
		System.out.println();
		
		// worker 객체 생성 
		Worker worker = new Worker();
		worker.name = "브라이언";  
		worker.age = 32; 
		
		worker.workerID = 9856;
		
		
		worker.eat(); 
		worker.sleep();
		
		worker.work();
	}

}
