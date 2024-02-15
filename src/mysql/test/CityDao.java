package mysql.test;

import java.io.FileInputStream;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import mysql.test.*;


public class CityDao {
	private String connStr;
    private String user;
    private String password;
    private Connection conn;
    
    public CityDao() {
    	// C:\Users\ape07\eclipse-workspace\lesson\src\mysql\test
    	String path = "C:/Users/ape07/eclipse-workspace/lesson/src/mysql/test/mysql.properties";
    	
    	try {
    		Properties prop = new Properties();
			prop.load(new FileInputStream(path));

			String host = prop.getProperty("host"); 
			String port = prop.getProperty("port"); 
			String database = prop.getProperty("database"); 

			this.connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
			
			this.user = prop.getProperty("user");
			
			this.password = prop.getProperty("password");
			
			this.conn = DriverManager.getConnection(connStr, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}	
    }

    public void close() {
    	try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public City getCity(int id) {
    	String sql = "select * from city where id=?";
    	City city = null;
    	
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1, id);
    		
    		ResultSet rs = pstmt.executeQuery();
			
    		while (rs.next()) {
				city = new City(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getInt(5));
			}
    		rs.close();
    		pstmt.close();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		return city;
    }

    // field는 table의 컬럼명, query는 검색어, num과 offset은 각각 limit와 offset 값
    public List<City> getCityList(String field, String query, int num, int offset) {
    	String sql = "SELECT l.name AS country_name, r.name AS city_name, r.Population " +
                "FROM city r " +
                "JOIN country l ON r.CountryCode = l.Code " +
                "WHERE r.id = 0 AND " +
                field + " LIKE ? " +
                "ORDER BY r.id DESC " +
                "LIMIT ? OFFSET ?";
    	
    	List<City> cityList = new ArrayList<City>();
    	try {
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		
    		pstmt.setString(1, query);
    		pstmt.setInt(2, num);
    		pstmt.setInt(3, offset);
    		
    		ResultSet rs = pstmt.executeQuery();
    		
    		while (rs.next()) {
				City city = new City(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getInt(5));
				
				cityList.add(city);
			}
    		
    		rs.close();
			pstmt.close();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return cityList;
    }

    public void insertCity(City city) {
    	String sql = "insert into city values(default, ?, ?, ?, ?)";
    	
    	try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, city.getName());
			pstmt.setString(2, city.getCountryCode());
			pstmt.setString(3, city.getDistrict());
			pstmt.setInt(4, city.getPopulation());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }

    public void updateCity(City city) {
String sql = "update city set name=?, countryCode=?, district=?, population=? where id=?";
    	
    	try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, city.getName());
			pstmt.setString(2, city.getCountryCode());
			pstmt.setString(3, city.getDistrict());
			pstmt.setInt(4, city.getPopulation());
			pstmt.setInt(5, city.getId());
			
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void deleteCity(int id) {
    	String sql = "delete from city where id=?";
    	
    	try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
	
			pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }


}
