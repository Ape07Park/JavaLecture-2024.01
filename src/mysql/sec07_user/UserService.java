package mysql.sec07_user;

import java.util.List;

public interface UserService {
	public static final int CORRECT_LOGIN = 0;
	public static final int WRONG_PASSWARD = 1;
	public static final int USER_NOT_EXIST = 2;
	public static final int COUNT_PER_PAGE = 2;
	
	User getUserByUid(String uid);
	
	void registerUser(User user);
	
	List<User> getUserList(int page);
	
	void updateUser(User user);
	
	void deleteUser(String uid);
	
	int login(String uid, String pwd);
	
	void close();
}
