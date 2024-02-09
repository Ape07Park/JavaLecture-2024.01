package mysql.sec08_bbs.service;

import java.util.List; 

import org.mindrot.jbcrypt.BCrypt;

import mysql.sec08_bbs.dao.UserDao;
import mysql.sec08_bbs.entity.User;

public class UserServiceMySQLImpl implements UserService {
	private UserDao userDao = new UserDao();

	@Override
	public User getUserByUid(String uid) {
		User user = userDao.getUserByUid(uid);
		return user;
	}

	@Override
	public void registerUser(User user) { // user는 아직 암호화된 패스워드 x
		// Uid 중복 확인-비즈니스 로직
		User u = userDao.getUserByUid(user.getUid());
		if (u != null) {
			return;
		}

		String hashedPwd = BCrypt.hashpw(user.getPwd(), BCrypt.gensalt()); // hashedPwd 가져오기
		user.setPwd(hashedPwd); // hashedPwd를 비번으로 저장
		userDao.insertUser(user); // DB에 집어넣기

	}

	@Override
	public List<User> getUserList(int page) {
		// 비즈니스 로직
		int offset = (page - 1) * COUNT_PER_PAGE;
		List<User> list = userDao.getUserList(COUNT_PER_PAGE, offset); // 한번에 몇번을 볼 건가
		return list;
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);

	}

	@Override
	public void deleteUser(String uid) {
		userDao.deleteUser(uid);

	}

	@Override
	public int login(String uid, String pwd) {
		// 비즈니스 로직
		User user = userDao.getUserByUid(uid);
		if (user == null) {
			return USER_NOT_EXIST;
		}
		if (BCrypt.checkpw(pwd, user.getPwd())) { // hashed된 건 이미 DB에 있으니까 DB에서 pwd 가져옴
			return CORRECT_LOGIN;
		}
		return WRONG_PASSWARD;
	}

	@Override
	public void close() {
		userDao.close();
	}

}
