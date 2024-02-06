package testT.q2_member;

import java.util.ArrayList;
import java.util.List;

public class MemberUtil {
	
	public List<Member> getMemberList() {
		List<Member> list = new ArrayList<Member>();
		
		Member james = new Member(101, "제임스", 1991, "010-1111-1111");
		Member maria = new Member(102, "마리아", 1995, "010-2222-3333");
		list.add(james);
		list.add(maria);
		return list;
	}
}
