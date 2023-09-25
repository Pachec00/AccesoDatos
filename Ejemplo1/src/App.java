import java.sql.SQLException;
import java.util.List;

import modelo.Actor;
import servicios.ActoresServiceException;
import servicios.ActoresServices;

public class App {

	public static void main(String[] args) throws SQLException {
		ActoresServices service = new ActoresServices();
		List<Actor> actores;
		try {
			actores = service.consultarActores();
			for (Actor actor : actores) {
				System.out.println(actor);
			}
		} catch (ActoresServiceException e) {
			e.printStackTrace();
		}

	}

}
