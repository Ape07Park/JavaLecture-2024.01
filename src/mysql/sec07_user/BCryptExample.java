package mysql.sec07_user;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptExample {

	public static void main(String[] args) {
		String pwd = "1234qwerty"; // 사용자 입력 
		String hashedpwd = BCrypt.hashpw(pwd, BCrypt.gensalt()); // DB에 있는 것
		System.out.println(hashedpwd.length());
		System.out.println(hashedpwd);
		
		// 패스워드가 동일한지 확인
		boolean result = BCrypt.checkpw(pwd, hashedpwd);
		System.out.println(result);
	}

}
