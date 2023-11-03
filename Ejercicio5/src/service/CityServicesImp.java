package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.CityDao;
import modelo.City;

public class CityServicesImp implements CityService {

	private OpenConnection openConnection;

	public CityServicesImp() {
		openConnection = new OpenConnection();
	}

	@Override
	public List<City> getCities(String filtroDescripcion) throws NotFoundException, ServerErrorException {
		return null;
	}

	@Override
	public City getCity(Long id) throws NotFoundException, ServerErrorException {
		Connection conn = null;
		CityDao cd = new CityDao();
		List<City> city = new ArrayList<City>();

		try{
			conn = openConnection.getConnection();

			city.add(cd.getCityDao(conn, id));
		} catch (Exception e) {
			throw new ServerErrorException(e);
		}finally{
			try {
				conn.close();
			} catch (Exception e) {
				
			}
		}
		return city;
	}

	@Override
	public City createCity(City city) throws ServerErrorException {
		Connection conn = null;
		CityDao cd = new CityDao();

		try {
			conn = openConnection.getConnection();

			cd.createCityDao(conn, city);
		} catch (Exception e) {
			throw new ServerErrorException(e);
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {

			}
		}

		return city;
	}

	@Override
	public void updateCity(City city) throws NotFoundException, ServerErrorException {
		Connection conn = null;
		CityDao cd = new CityDao();
		
		try {
			conn = openConnection.getConnection();
			
			cd.updateCityDao(conn, city);
		} catch (Exception e) {
			throw new ServerErrorException(e);
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				
			}
		}

	}

	@Override
	public City updateSelectiveCity(City city) throws NotFoundException, ServerErrorException {
		
		return null;
	}

	@Override
	public void deleteCity(Long id) throws NotFoundException, ServerErrorException {
	

	}

}
