package mysql.sec07_user;

import java.util.List;

public class UserTest {

	public static void main(String[] args) {
		UserService userSvc = new UserServiceMySQLImpl();
		User user = null;
//		
//		user = new User("james", "1234", "제임스", "james@naver.com");
//		userSvc.registerUser(user);
//		
//		user = new User("maria", "1234", "마리아", "maria@naver.com");
//		userSvc.registerUser(user);
//		
//		user = new User("brain", "1234", "브라이언", "brain@naver.com");
//		userSvc.registerUser(user);
//		
//		user = new User("sarah", "1234", "세라", "sarah@naver.com");
//		userSvc.registerUser(user);
		
//		user = userSvc.getUserByUid("admin");
//		System.out.println(user);
//		
//		user = userSvc.getUserByUid("james");
//		System.out.println(user);
		
//		System.out.println(userSvc.login("admin", "1234"));
//		System.out.println(userSvc.login("admin", "asd"));
//		System.out.println(userSvc.login("james", "1111"));
		
		List<User> list = userSvc.getUserList(2);
		list.forEach(x-> System.out.println(x));
		
		userSvc.close();
	}

}
