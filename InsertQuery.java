import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertQuery {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        int result = 0;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeUpdate("INSERT INTO people VALUES ('Alex Smith' ,'student at RMIT', 'M', 35, 'WA')");
            result = stmt.executeUpdate("DELETE FROM relation VALUES ('Alex Smith', 'Ben Turner', 'friend')");
            con.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println(result + " rows effected");
        System.out.println("Rows inserted successfully");
    }
}