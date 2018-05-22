

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
           // result = stmt.executeUpdate(
			//	"UPDATE relation SET Name1 = NLIST");
           //result = stmt.executeUpdate(
    			//	"UPDATE people SET status = 'Student at RMIT' WHERE Age = 35");
				
           // output = stmt.executeQuery(
			//	"SELECT * FROM people");
            output = stmt.executeQuery(
    				"SELECT Name1, Name2, Relationship, Name, Status, Gender, Age, State FROM relation JOIN people ON people.Name = relation.Name1");
				
            //output = stmt.executeQuery(
    			//	"SELECT Name, Status, Gender, Age, State, Name1, Name2, Relationship FROM people JOIN relation ON relation.Name2 = people.Name");
				
           // while(output.next()){
             //   System.out.println(output.getString("Name")+" | "+output.getString("Status")+" | "+output.getString("Gender")+"|"+output.getInt("Age")+" | "+output.getString("State") + " | "+output.getString("Name2")+" | "+output.getString("Relationship"));
             //   }	
            while(output.next()){
                System.out.println(output.getString("Name1")+" | "+output.getString("Name2")+" | "+output.getString("Relationship")+" | "+output.getString("Status")+" | "+output.getString("Gender")+"|"+output.getInt("Age")+" | "+output.getString("State"));
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
        }
        System.out.println(result+" Rows effected");
    }
}
