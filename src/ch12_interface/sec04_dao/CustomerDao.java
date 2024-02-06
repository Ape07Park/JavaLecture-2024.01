package ch12_interface.sec04_dao;


// DAO(Data Access Object) - DB를 액세스 하기 위한 코드를 의미
// 보통 5개 정도 만듦 
//CRUD

import java.util.List;

public interface CustomerDao {
	Customer getCustomer(int cid); // cid 값을 주면 Customer 객체 가져다 줘
	
	List<Customer> getCustomerList(); // Customer 객체의 리스트를 모두 가져다줘
	
	void insertCustomer(Customer customer); // Customer 객체를 줄테니 삽입해줘
	
	void updateCustomer(Customer customer); // Customer 객체를 줄테니 업데이트해줘
	
	void deleteCustomer(int cid); // cid 값을 주면 DB에 있는 것 삭제 
	
	
	
	
}
