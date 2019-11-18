package org.capstone.airbnbwebapp.conn;
 
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
  
public class PostgresConnUtils {
  
 public static Connection getPostGreSQLConnection()
         throws ClassNotFoundException, SQLException, IOException {
     // Note: Change the connection parameters accordingly.
	 InputStream inputStream = OracleConnUtils.class.getClassLoader()
             .getResourceAsStream("db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
	       // Note: Change the connection parameters accordingly.
//	       String hostName = "localhost";
//	       String sid = "airbnbdb";
//	       String userName = "system";
//	       String password = "Xoriant123#";
	       
	       String hostName = properties.getProperty("hostName");;
	       String sid = properties.getProperty("sid");
	       String userName = properties.getProperty("userName");
	       String password = properties.getProperty("password");
     return getMyPostgreSQLConnection(hostName, sid, userName, password);
 }
  
 public static Connection getMyPostgreSQLConnection(String hostName, String dbName,
         String userName, String password) throws SQLException,
         ClassNotFoundException, IOException {
    
     Class.forName("org.postgresql.Driver");
  
     // URL Connection for MySQL:
     // Example: 
     // jdbc:mysql://localhost:3306/simplehr
     String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + dbName;
  
     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
}
