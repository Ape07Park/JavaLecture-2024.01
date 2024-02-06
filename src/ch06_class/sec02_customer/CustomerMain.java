package ch06_class.sec02_customer;

public class CustomerMain {

	public static void main(String[] args) {
		Customer james = new Customer();
		james.setCid(1); 
		james.setName("james");
		james.setAge(25);
		james.setAdult(true);
		
		Customer maria = new Customer(2, "마리아", 23, true);
		
		Customer brain = new Customer(3, "브라이언", 17);
		
		// toString 생략 가능함 
		System.out.println(james);
		System.out.println(maria);
		System.out.println(brain);
		
//		Customer [cid=1, name=james, age=25, adult=true]
//		Customer [cid=2, name=마리아, age=23, adult=true]
//		Customer [cid=3, name=브라이언, age=17, adult=false]
		
	}

}
