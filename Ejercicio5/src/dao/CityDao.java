 package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.checkerframework.checker.units.qual.s;

import modelo.City;
import service.NotFoundException;

public class CityDao {

	//getCities
	
	//getCity

	public City getCityDao(Connection conn, Long id) {
		/*
		 * TODO mirar si el nombre de las tablas estan bien en el rs.next()
		*/
		PreparedStatement stmt = null;
		ResultSet rs = null;
		City city = new City();
		try {
			String sql = "select * from city where ? = id";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();

			while(rs.next()){
				
				city.setCountryId(rs.getLong("country_id"));
				city.setDescripcion(rs.getString("city"));
				city.setId(rs.getLong("city_id"));
			}

			return city;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				throw new NotFoundException(e);
			}
		}
	}
	
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
				throw new NotFoundException("Error al crear la ciudad en la base de datos",e);
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
				throw new NotFoundException("Error al actualizar",e);
			}
		}
		
	}
	
	//updateSelectiveCity
	
	public void updateSelectiveCityDao(Connection conn, City city) throws SQLException { 
		/*
		 * Los atributos en null no se actualizan
		 */
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
				throw new NotFoundException("Error al actualizar",e);
			}
		}
	}
	
	//deleteCity

	public void deleteCityDao(Connection conn, Long id) {
		PreparedStatement stmt = null;

		try {
			
			String sql = "delete from city where id = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(id, 1);
			stmt.execute();

		} finally{
			try {
				stmt.close();
			} catch (Exception e) {
				 /*Lanzar error */
				 throw new NotFoundException("No se encuentra la id ", e);
			}
		}
	}
}
