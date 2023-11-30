package prueba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Actor;

public class ActorDao {

	
	public Actor consultarNombre(Connection conn, Integer id) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Actor a = new Actor();
		
		try {
			
			String sql = "select first_name from actor where id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				a.setId(rs.getInt("actor_id"));
				a.setNombre(rs.getString("first_name"));
			}
			
			return a;
			
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				
			}
		}
	}
}
