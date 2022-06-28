package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnecDB {
	Connection Connect = ConnecDB.get_connection();

			
			public static  Connection connect;
		    public static String driver="org.postgresql.Driver";
		    public static String url="jdbc:postgresql://localhost:5432/postgres";
		    public static String username="postgres";
		    public static String password="123456";

			   public static Connection get_connection() {
				   try{ 
				         Class.forName(driver);
						 return DriverManager.getConnection(url, username, password );
	                   }catch (SQLException | ClassNotFoundException e ){
					  e .printStackTrace();
				         System.out.println("Error Opning DB!");
						 
					 }
					 return null;
			    
			    
			   }

			public static PreparedStatement prepareStatement(String sql) {
				// TODO Auto-generated method stub
				return null;
			}

			public static Statement createStatement() {
				// TODO Auto-generated method stub
				return null;
			}

			public static void closePreparedStatement(PreparedStatement ps) {
				// TODO Auto-generated method stub
				
			}

			public static void closeConnection(Connection connect2) {
				// TODO Auto-generated method stub
				
			}

			
		

			

}

