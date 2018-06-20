
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		int result = 0;
		
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
			stmt = con.createStatement();
			
		//	result = stmt.executeUpdate("CREATE TABLE people (Name VARCHAR(50) NOT NULL,Status VARCHAR(20) NOT NULL, Gender VARCHAR(50) NOT NULL, Age INT NOT NULL, State VARCHAR(50) NOT NULL,PRIMARY KEY (Name));");
			result = stmt.executeUpdate("CREATE TABLE relation (Name1 VARCHAR(50) NOT NULL,Name2 VARCHAR(50) NOT NULL, Relationship VARCHAR(50) NOT NULL ,PRIMARY KEY (Name1, Name2));");
			//result = stmt.executeUpdate("DROP TABLE relation");
			
		
			//Warning, your compiler might not like the newlines in the SQL query
	
		}  catch (Exception e) {
			e.printStackTrace(System.out);
		}
		System.out.println("Table created successfully");
	}
}
