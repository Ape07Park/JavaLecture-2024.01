package mysql.sec08_bbs.appl;

import java.time.LocalDate; 
import java.util.List;   

import mysql.sec08_bbs.entity.User;
import mysql.sec08_bbs.service.UserService;
import mysql.sec08_bbs.service.UserServiceMySQLImpl;

public class UserTest {
	/*
	 * 구조: user(인터페이스 즉 리모컨 조작) - interface(리모컨) - Impl(가전제품, TV) - 
	 * DAO(DB 접근 및 쿼리수행, 전파 잡기) - DB(방송국)
	 */
	public static void main(String[] args) {
		UserService userSvc = new UserServiceMySQLImpl();
		User user = null;
		
		user = new User("admin", "1234", "관리자", "admin@gmail.com");
		userSvc.registerUser(user);
		
		user = new User("james", "1234", "제임스", "james@naver.com");
		userSvc.registerUser(user);
		
		user = new User("maria", "1234", "마리아", "maria@naver.com");
		userSvc.registerUser(user);
		
		user = new User("brian", "1234", "브라이언", "brian@naver.com");
		userSvc.registerUser(user);
		
		user = new User("sarah", "1234", "세라", "sarah@naver.com");
		userSvc.registerUser(user);
		
//		user = userSvc.getUserByUid("admin");
//		System.out.println(user);
		
//		user = userSvc.getUserByUid("james");
//		System.out.println(user);
		
//		System.out.println(userSvc.login("admin", "1234"));
//		System.out.println(userSvc.login("admin", "asd"));
//		System.out.println(userSvc.login("james", "1111"));
		
		List<User> list = userSvc.getUserList(1);
		list.forEach(x-> System.out.println(x));
		
		userSvc.close();
	}

}
