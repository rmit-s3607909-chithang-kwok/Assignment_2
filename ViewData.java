

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewData {
   
   public static void main(String[] args) {
      Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection(
            "jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
         stmt = con.createStatement();
         //result = stmt.executeQuery(
           // "SELECT * FROM people");
         result = stmt.executeQuery(
                 "SELECT * FROM relation");
         
         while(result.next()){
            //System.out.println(result.getString("name")+" | "+  result.getString("status")+" | "+ result.getString("gender")+" | " + result.getInt("Age") + " | " + result.getString("state"));
        	 System.out.println(result.getString("Name1")+" | "+  result.getString("Name2")+" | "+ result.getString("Relationship"));
         }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
   }
}
