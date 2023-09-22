import java.sql.SQLException;
import java.util.List;

import modelo.Actor;
import servicios.ActoresServiceException;
import servicios.ActoresServices;

public class App {

	public static void main(String[] args) {
		ActoresServices service = new ActoresServices();
		List<Actor> actores;

		try {
			try {
				actores = service.consultarActores();
				for (Actor actor : actores) {
					System.out.println(actores);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ActoresServiceException e) {
			e.printStackTrace();
		}

	}

}
