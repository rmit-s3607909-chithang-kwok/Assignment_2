

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt = con.createStatement();
            
            //result = stmt.executeUpdate("INSERT INTO people VALUES ('Klay Thomas','House Worker', 'F', 33, 'NSW')");// A replace.(person.profile.getName())
            result = stmt.executeUpdate("INSERT INTO relation VALUES ('John Smith','Hannah White', 'classmate')");
            con.commit();																		                     // where name = person.profile.getName()
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println(result + " rows effected");
        System.out.println("Rows inserted successfully");
    }
}
