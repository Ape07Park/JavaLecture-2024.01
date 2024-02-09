package ch10_oop.sec01_Person;

public class Worker extends Person{
	int workerID;
	
	void work() {
		System.out.println(name + "이/가열심히 일하다");
	}
}
