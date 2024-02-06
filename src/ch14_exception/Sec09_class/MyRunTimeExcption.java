package ch14_exception.Sec09_class;

public class MyRunTimeExcption extends RuntimeException {

	public MyRunTimeExcption() {
	}

	public MyRunTimeExcption(String message) {
		super(message);
	}
	
}
