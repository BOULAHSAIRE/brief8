package DaoProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Taches;
import Model.User;
import database.ConnecDB;

public class DaoTache implements DAO {
	
	PreparedStatement ps;
	Statement st;
	Connection Connect = ConnecDB.get_connection();
	
	
	@Override
	public boolean signUpUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
		@Override
	public List<Taches> getAll() {
			List<Taches> ListerTaches = new ArrayList<>();
		try {
			String sql = "SELECT *  FROM Tache";
			Statement stmt = ConnecDB.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Taches tache = new Taches();
				tache.setTitle(rs.getString("title"));
				tache.setDescription(rs.getString("description"));
				tache.setStatus(rs.getString("status"));
				tache.setDeadline(rs.getString("deadline"));
				tache.setCategorie(rs.getString("category"));

				ListerTaches.add(tache);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return ListerTaches;
	
}

	
			    
			@Override
			public boolean createTache(Taches tache) throws SQLException {
				String sql = "INSERT INTO Task (Title, Description , Status, Deadline, Category)"
						+ " VALUES (?, ?, ?, ?::Date, ?)";
				
				PreparedStatement ps = Connect.prepareStatement(sql);
				Statement stmt = Connect.createStatement();

		     	            ps.setString(1, tache.getTitle());
							ps.setString(2, tache.getDescription());
							ps.setString(3, tache.getStatus());
							ps.setString(4, tache.getDeadline());
							ps.setString(5, tache.getCategorie());
						
			int result = ps.executeUpdate();
			
			if(result == 1) {
				
				return  true;
			}
				
							ConnecDB.closePreparedStatement(ps);
							ConnecDB.closeConnection(Connect);
							
				return false;
				
			}
					
			@Override
			public boolean updateTache(Taches tache) throws SQLException {
				String sql = "UPDATE Task set Title = ?, description = ?, status = ?,"
						+ " deadline = ?::Date, category = ?  where title ='" + tache.getTitle() +"'";
				
				PreparedStatement ps = ConnecDB.prepareStatement(sql);
				      Statement stmt = Connect.createStatement();

				
 	            ps.setString(1, tache.getTitle());
				ps.setString(2, tache.getDescription());
				ps.setString(3, tache.getStatus());
				ps.setString(4, tache.getDeadline());
				ps.setString(5, tache.getCategorie());
				//ps.setString(6, tache);
				
				int result = ps.executeUpdate();

				
				if(result == 1) {
					return  true;
				}
					
								ConnecDB.closePreparedStatement(ps);
								ConnecDB.closeConnection(Connect);
			
		
				return false;
			
}
			@Override
			public boolean deleteTache(Taches tache) {
				try {
			        Statement stmt = ConnecDB.createStatement();
			        int i = stmt.executeUpdate("DELETE FROM Task WHERE Title='" + tache.getTitle() +"'");

			      if(i == 1) {
			        return true;
			      }
				    stmt.close();
				  ConnecDB.get_connection();

			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    
					return false;
			}

				
		}		
	