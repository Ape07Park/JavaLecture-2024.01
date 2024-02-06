package ch10_oop.sec04_polymorphism;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat(); 
		cat.sound();
		cat.jump();
		
		Dog dog = new Dog();
		dog.sound();
		dog.walk();
		
		// 다형성(부모가 자식타입으로 왔다갔다 함, 자식은 부모 타입으로 자동 타입 변환이 이루어짐 
		Animal animal = new Cat();
		animal.sound(); // 야옹~~
// 		animal.jump();  // Animal class에 없는 메소드 사용 x
		
		animal = dog;
		animal.sound(); // 멍멍!!
//		animal.walk(); 
		
		animal = cat;
		cat = (Cat) animal; // 다운 케스팅, 강제 타입 변환 
		cat.jump(); 
		
//  	dog = (Dog) animal; dog.walk(); 에러. 강제 타입변환은 주의깊게 해야 함. 
//		animal = cat;
//		animal = dog;
		animal = new Animal();
		if (animal instanceof Cat) {
			cat = (Cat) animal;
			cat.sound(); cat.jump();
		}else if (animal instanceof Dog) {
			dog = (Dog) animal;
			dog.sound(); dog.walk();
		}else {
			System.out.println("cat.sound() / dog.sound() 등을 사용 불가");
		}
//		Cat c = (Cat) new Animal(); 동물은 고양이다 즉 에러 
		
		Object object = cat;
//		object.sound();  Object는 sound 메서드 없어서 사용 x 
	}

}
