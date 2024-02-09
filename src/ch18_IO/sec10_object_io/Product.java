package ch18_IO.sec10_object_io;

import java.io.Serializable;

public class Product implements Serializable{ // 어떤 순서로 내보내고 들여보낼 것인가
	/**
	 * Serializable I/F를 구현해야 직렬화가 가능해서, 파일에 읽고 쓰기 가능 
	 */
	private static final long serialVersionUID = 2614217027564302729L; //long 타입이기만 하면 됨
	private String name;
	private int price;
	
	public Product(String name, int price) {
		
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	
	
}
