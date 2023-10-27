package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.checkerframework.checker.units.qual.s;

import modelo.City;

public class CityDao {

	//getCities
	
	//getCity
	
	//createCity
	
	public void createCityDao(Connection conn, City city) throws SQLException {
		PreparedStatement stmt = null;
		
		try {
			String sql = "insert into city(city,country_id) values(?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, city.getDescripcion());
			stmt.setLong(2, city.getCountryId());
			stmt.execute();			
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				
			}
		}
	}
	
	//updateCity
	
	public void updateCityDao(Connection conn, City city) throws SQLException {
		PreparedStatement stmt = null;
		
		try {
			String sql = "update city set city=?, country_id=? where city_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, city.getDescripcion());
			stmt.setLong(2, city.getCountryId());
			stmt.setLong(3, city.getId());
			stmt.execute();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				
			}
		}
		
	}
	
	//updateSelectiveCity
	
	public void updateSelectiveCityDao(Connection conn, City city) throws SQLException {
		PreparedStatement stmt = null;
		
		try {
		
	
			//Ninguno null
			String sql = "update city set city=?, country_id=? where city_id=?";
			
			//Country_id null
			String sql1 = "update city set city=? where city_id=?";
			//city null
			String sql2 = "update city set country_id=? where city_id=?";
			
			if (city.getCountryId()==null) {
				stmt = conn.prepareStatement(sql1);
				stmt.setString(1, city.getDescripcion());
				stmt.execute();
			}else if (city.getDescripcion() == null) {
				stmt = conn.prepareStatement(sql2);
				stmt.setLong(1, city.getCountryId());
				stmt.execute();
			}else if (city.getCountryId()!=null && city.getDescripcion()!=null) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, city.getDescripcion());
				stmt.setLong(2, city.getCountryId());
				stmt.execute();
			}
		}finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	//deleteCity
}
