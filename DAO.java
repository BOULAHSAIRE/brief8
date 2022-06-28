package DaoProject;
import java.sql.SQLException;
import java.util.List;
import Model.Taches;
import Model.User;

public interface DAO {

		
		public boolean signUpUser(User user);
		public User getUser(User user);
		
		List<Taches> getAll() throws SQLException;
		
		public boolean createTache(Taches tache) throws SQLException;
       public  boolean updateTache(Taches tache)throws SQLException;
	  public   boolean deleteTache(Taches tache);

	}
