

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class UpdateData{
	
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet output = null;
        int result = 0;
		
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeUpdate(
				"UPDATE relation SET Name1 = 'Alex Smith' WHERE Relationship = couple");
          //  result = stmt.executeUpdate(
    		//		"UPDATE people SET status = 'Student at RMIT' WHERE Age = 35");
				
            //output = stmt.executeQuery(
			//	"SELECT * FROM people");
            output = stmt.executeQuery(
    				"SELECT * FROM relation");
				
            //while(output.next()){
              //  System.out.println(output.getString("name")+" | "+output.getString("status")+" | "+output.getString("gender")+"|"+output.getInt("Age")+" | "+output.getString("state"));
               // }	
            while(output.next()){
                System.out.println(output.getString("Name1")+" | "+output.getString("Name2")+" | "+output.getString("Relationship"));
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
        }
        System.out.println(result+" Rows effected");
    }
}
