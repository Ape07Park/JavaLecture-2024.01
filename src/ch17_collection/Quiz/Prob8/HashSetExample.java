package ch17_collection.Quiz.Prob8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1, "신짱구"));
		set.add(new Student(2, "봉미선"));
		set.add(new Student(1, "신형만"));
		
		Iterator<Student> iterator = set.iterator(); // 반복자 얻기
		while(iterator.hasNext()) { // 객체의 수 만큼 루프 돌리기
			Student student = iterator.next(); // 한개의 객체 가져옴
			System.out.println(student.studentNum + ":" + student.name);
		}
		
	}

}
