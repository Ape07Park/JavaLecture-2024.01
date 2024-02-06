package ch17_collection.QyizT.q8_set;

import java.util.Objects;



public class Student {
	public int studentNum;
	public String name;
	
	public Student() {}
	
	public Student(int studentNum, String name) {
		super();
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [studentNum=" + studentNum + ", name=" + name + "]";
	}
	
	// ** set에서 같다고 판정하는 기준: hashCode()가 같고, equals()가 true일 때 같은 거로 인식 

	@Override
	public int hashCode() {
		// set의 원소들을 가져오고 hash코드를 추출 
		// 같은 int라 return studentNum도 o
		
		return Objects.hash(studentNum);
	}
	
	@Override
	// ** 어떤 것이 일치하면 같다고 인식하는지는 내가 정한다. 즉 내가 이름과 나이만 같으면 같다고 하면 같은 거 키가 다르니 다르다고 하면 다른 것임
	// 이 메서드 다시 살펴보기 
	public boolean equals(Object obj) { // instanceof: object가 type이거나 type을 상속받는 클래스라면 true를 리턴
		if(obj instanceof Student) { // Student 타입의 인스턴스가 obj라면/ * y 객체 instanceof x 타입: x 타입의 인스턴스가 객체 y가 맞다면	
			Student st = (Student) obj; // 다운 캐스팅 가능한지 확인 위해 instanceof 쓸 것, Student 객체에 해당하니 다운 캐스팅 o
			return st.studentNum == this.studentNum ;
		}else
			return false;
	}	
}
