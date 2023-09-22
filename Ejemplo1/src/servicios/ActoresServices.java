package servicios;




import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Actor;

public class ActoresServices {

	
	public List<Actor> consultarActores() throws SQLException{
		List<Actor> actores = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			OpenConnection proveedor = new OpenConnection();
			conn = proveedor.getConnection();
			stmt = conn.createStatement();

			String sql = "SELECT * FROM ACTOR";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Integer id = rs.getInt("actor_id");
				String nombre = rs.getString("first_name");
				String apellido = rs.getString("last_name");
				Actor actor = new Actor();
				actor.setId(id);
				actor.setNombre(nombre);
				actor.setApellido(apellido);
				actores.add(actor);
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return actores;
}
	
}
