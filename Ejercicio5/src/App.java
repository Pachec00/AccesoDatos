import modelo.City;
import service.CityService;
import service.CityServicesImp;
import service.NotFoundException;
import service.ServerErrorException;

public class App {

	public static void main(String[] args) throws ServerErrorException, NotFoundException {
		City c = new City();
		CityServicesImp cs = new CityServicesImp();
		Long p = new Long(1);
		
		c.setCountryId(p);
		c.setDescripcion("prueba");
		c.setId(new Long(1000));
		cs.updateCity(c);
		
	}
}
