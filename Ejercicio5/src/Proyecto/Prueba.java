package Proyecto;

import Proyecto.modelo.City;
import Proyecto.service.CityServicesImp;
import Proyecto.service.ServerErrorException;

public class Prueba {
public static void main(String[] args) throws ServerErrorException {
	
	City c = new City();
	long l = 1000;
	c.setDescripcion("Fabio");
	c.setCountryId(l);
	
	CityServicesImp ci = new CityServicesImp();
	ci.createCity(c);
}
}
