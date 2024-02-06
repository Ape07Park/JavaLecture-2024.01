package test.q2;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberMain {

	public static void main(String[] args) {

		ArrayList<Member> list = new ArrayList<Member>();

		Member james = new Member(1, "james", 2000, "010-1111-1111");
		Member maria = new Member(2, "maria", 2010, "010-2222-2222");

		list.add(james);
		list.add(maria);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("문제 2) --------------------");

		System.out.println(MemberMain.getMemberList(james));
		System.out.println(MemberMain.getMemberList(maria));

		System.out.println("문제 3) --------------------");
		james.setTel("010-9999-9999");
		maria.setTel("010-8888-8888");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	public static ArrayList<Member> getMemberList(Member a) {
		ArrayList<Member> list = new ArrayList<Member>();

		list.add(a);

		return list;
	}
}
