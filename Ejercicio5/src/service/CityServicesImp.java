package service;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City getCity(Long id) throws NotFoundException, ServerErrorException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCity(Long id) throws NotFoundException, ServerErrorException {
		// TODO Auto-generated method stub

	}

}
