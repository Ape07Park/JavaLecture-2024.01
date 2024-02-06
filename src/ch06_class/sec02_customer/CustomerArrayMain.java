package ch06_class.sec02_customer;

public class CustomerArrayMain {

	public static void main(String[] args) {
		Customer [] customers = new Customer[3];
		customers[0] = new Customer(1, "제임스", 25);
		customers[1] = new Customer(2, "마리아", 23);
		customers[2] = new Customer(3, "브라이언", 18);
		
		Customer[] customers2 = {
				new Customer(1, "제임스", 25), new Customer(2, "마리아", 23),
				new Customer(3, "브라이언", 18), new Customer(4, "엠마", 31)
		};
		
		for(int i = 0; i < customers.length; i++) {
			System.out.println(customers[i]);
		}
		
		// 이 형태가 많이 쓰임. 왜냐면 리스트의 형태로 꺼내는 경우가 대부분
		for (Customer customer:customers) {
			System.out.println(customer);
		}
	}

}
