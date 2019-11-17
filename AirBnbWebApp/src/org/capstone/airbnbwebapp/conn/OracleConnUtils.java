package org.capstone.airbnbwebapp.conn;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleConnUtils {

	public static Connection getOracleConnection()
	           throws ClassNotFoundException, SQLException, IOException {
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
	       
	       return getOracleConnection(hostName, sid, userName, password);
	   }
	  
	   public static Connection getOracleConnection(String hostName, String sid,
	           String userName, String password) throws ClassNotFoundException,
	           SQLException, IOException {
	   
	       Class.forName("oracle.jdbc.driver.OracleDriver");
	  
	       // URL Connection for Oracle
	       // Example: 
	       // jdbc:oracle:thin:@localhost:1521:db11g
	       // jdbc:oracle:thin:@//HOSTNAME:PORT/SERVICENAME
	       String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;
	  
	       Connection conn = DriverManager.getConnection(connectionURL, userName,
	               password);
	       return conn;
	   }
}
