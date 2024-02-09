package ch10_oop.sec05_equals;

import java.util.Objects;

public class Customer {
		
		private int cid; // 고유값 
		private String name;
		private int age;
		private boolean adult;
		
		// 생성자(Constructor)
		
		public Customer() {}
		
		public Customer(int cid, String name, int age) {
			super();
			this.cid = cid;
			this.name = name;
			this.age = age;
			this.adult = age > 19 ? true:false; 
			// this(cid, name, age, age > 19 ? true:false); 대신 이거 사용도 가능
		}


		// 속성(필드) 초기화 
		public Customer(int cid, String name, int age, boolean adult) {
			super();
			this.cid = cid;
			this.name = name;
			this.age = age;
			this.adult = adult;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Customer) {
				Customer customer = (Customer) obj;
				
				// cid 값만 같으면 동일한 객체로 취급 
				// return this.cid == ((Customer) obj).getCid();	
				// cid 값, name이 같으면 동일한 객체로 취급
				//return customer.getCid() == cid && customer.getName().equals(name);
				return this.cid == ((Customer) obj).getCid() 
						&& this.name.equals(((Customer) obj).getName());
				}
				return false; 
			}
		
		

		@Override
		public int hashCode() {
			return Objects.hash(this.cid, this.age);
			
		}

		@Override
		public String toString() {
			return "Customer [cid=" + cid + ", name=" + name + ", age=" + age + ", adult=" + adult + "]";
		}
		
		// getter, setter
		
		public int getCid() {
			return cid;
		}

		public void setCid(int cid) {
			this.cid = cid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		//  boolean이면 getter가 is임
		public boolean isAdult() {
			return adult;
		}

		public void setAdult(boolean adult) {
			this.adult = adult;
		}

		
		
		// 생성자 (constructor)
		// toString() method
		// Getter/Setter method
		
		
		
	}


