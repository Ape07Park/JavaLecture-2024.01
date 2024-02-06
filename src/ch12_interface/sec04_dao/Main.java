package ch12_interface.sec04_dao;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// MySQL DB를 사용할려면
		CustomerDao customerDao = new CustomerDaoOracleImpl();
		Customer customer = customerDao.getCustomer(34);
		List<Customer> list = customerDao.getCustomerList();
		customerDao.insertCustomer(customer);
		customerDao.updateCustomer(customer);
		customerDao.deleteCustomer(34);
		
		//  Oracle DB를 사용할려면
		customerDao = new CustomerDaoMySQLImpl();
		customer = customerDao.getCustomer(34);
		list = customerDao.getCustomerList();
		customerDao.insertCustomer(customer);
		customerDao.updateCustomer(customer);
		customerDao.deleteCustomer(34);
		
	}
	
	//SpringBoot에서 사용 시
	// @Autowired private CustomerDao customerDao;
	// 프로그램이 실행될 떄 SpringBoot에서 customerDao 구현 객체를 주입 시켜줌(의존성 주입)
	// 따라서 I/F로 1개로 DB 종류 상관없이 관리 가능 

}
