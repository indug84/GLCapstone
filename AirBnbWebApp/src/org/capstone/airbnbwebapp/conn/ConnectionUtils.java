package org.capstone.airbnbwebapp.conn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

	 public static Connection getConnection() 
             throws ClassNotFoundException, SQLException, IOException {

      // return OracleConnUtils.getOracleConnection();
     	 return PostgresConnUtils.getPostGreSQLConnection();
   }
    
   public static void closeQuietly(Connection conn) {
       try {
           conn.close();
       } catch (Exception e) {
       }
   }

   public static void rollbackQuietly(Connection conn) {
       try {
           conn.rollback();
       } catch (Exception e) {
       }
   }
}
