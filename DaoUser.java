package DaoProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import Model.Taches;
import Model.User;
import database.ConnecDB;
import javafx.scene.control.Alert;

public class DaoUser implements DAO  {
	PreparedStatement ps;
	Statement  st;
	Connection cn = ConnecDB.get_connection();

	@Override
	public boolean signUpUser(User user) {
int container=0;
		
		PreparedStatement psInsert = null;
		PreparedStatement psExists = null;
		ResultSet resultset = null;
		String firstname = user.getFirstname();
		String lastname = user.getLastname();
		String username = user.getUsername();
		String password = user.getPassword();
		
		
		try {
			if(!firstname.equals("") && !lastname.equals("") && !username.equals("") && !password.equals("")) {
				String query = "SELECT * FROM user WHERE username = ?";
				psExists = ConnecDB.prepareStatement(query);
				psExists.setString(1,user.getUsername());
				resultset = psExists.executeQuery();
				
				
				if(resultset.isBeforeFirst()) {
					System.out.println("User already exists!!");
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Username Not valid!!");
					alert.show();
					
				}else {
					String query1 = "INSERT INTO user(firstname , lastname , username , password) VALUES (?,?,?,?)";
					psInsert=ConnecDB.prepareStatement(query1);
					psInsert.setString(1,firstname);
					psInsert.setString(2,lastname);
					psInsert.setString(3,username);
					psInsert.setString(4,password);
					psInsert.executeUpdate();
					container=1;
				}
			}else {
				System.out.println("Fill in information!!");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Fill in information!!");
				alert.show();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(container==1) {
			return true;
		}else {
			return false;
		}
	
	}

	@Override
	public User getUser(User user) {
		ResultSet rs = null;
		User users = null;
		
		if(!users.getUsername().equals("") || !users.getPassword().equals("")) {
			String query = "SELECT * FROM users WHERE username = ? AND password = ?";
			
			try {
				ps = ConnecDB.prepareStatement(query);
				ps.setString(1,users.getUsername());
				ps.setString(2,users.getPassword());
				
				rs = ps.executeQuery();
				
			    while(rs.next()) {
			    	user = new User();
			    	user.setId(rs.getInt("userid"));
			    
			    }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Please Enter your credentials!");
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Please Enter your credentials!");
			alert.show();
		}
		return user;
		
	}

	@Override
	public List<Taches> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createTache(Taches tache) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTache(Taches tache) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTache(Taches tache) {
		// TODO Auto-generated method stub
		return false;
	}
}
	