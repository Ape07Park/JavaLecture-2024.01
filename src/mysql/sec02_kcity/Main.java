package mysql.sec02_kcity;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		CityDao cityDao = new CityDao();
		
		City city = cityDao.getCityId(2340);
		System.out.println(city);
		
		System.out.println("1=================");
		
		city = cityDao.getCityByname("수원");
		System.out.println(city);
		
		System.out.println("2=================");
		
		List<City> list = cityDao.getCityListAll();
		list.forEach(x -> System.out.println(x));
		
		System.out.println("3=================");
		
		list = cityDao.getCityListByDistrict("Kyonggi");
		list.forEach(x -> System.out.println(x));
		
		System.out.println("4=================");
		
		// ** 생성자는 필요하면 만들어서 사용해라 
		
		// 추가(C)
		city = new City("화성", "KOR", "Kyonggi", 900000);
		cityDao.insertCity(city);
		
		// 업데이트(U)
		city = cityDao.getCityId(2396);
		city.setName("의왕");
		city.setPopulation(500000);
		cityDao.updateCity(city);
		
		// 제거(D)
		cityDao.deleteCity(2402);
		
		// 조회(R)
		list = cityDao.getCityListByDistrict("Kyonggi");
		list.forEach(x -> System.out.println(x));
		
		
	}
}
