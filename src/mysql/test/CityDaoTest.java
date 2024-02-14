package mysql.test;

import java.util.List;



public class CityDaoTest {
	public static void main(String[] args) {
		CityDao cityDao = new CityDao();
		
		List<City> list =cityDao.getCityList("title", "%", 10, 0);
		list.forEach(x -> System.out.println(x));
	}
}
