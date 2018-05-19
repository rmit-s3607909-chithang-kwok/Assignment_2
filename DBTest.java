


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hsqldb.Server;
public class DBTest {
public static void main(String[] args) {
Server hsqlServer = null;
Connection connection = null;
ResultSet rs = null;
hsqlServer = new Server();
hsqlServer.setLogWriter(null);
hsqlServer.setSilent(true);
hsqlServer.setDatabaseName(0, "TestDB");
hsqlServer.setDatabasePath(0, "file:MYDB");
hsqlServer.start();
// making a connection
try {
Class.forName("org.hsqldb.jdbcDriver");
connection = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "123");
//connection.prepareStatement("drop table people if exists;").execute();//if file not empty then read
connection.prepareStatement("create table people (name varchar(20), status varchar(20), gender varchar(20), age integer, state varchar(20) not null);").execute();
connection.prepareStatement("insert into people (name, status, genderm age, state)" + "values (Alex Smith, student in rmit, M, 35, WA);"+"values (Ben turner, manager at ZFX, M, 45, vic);"+"values (Hannah Write, student at PLC, M, 12, vic);"+"value(Zoe Foster, Founder of ZFX, M, 33, vic").execute();
//
// // query from the db
rs = connection.prepareStatement("select name, status from people;").executeQuery();
rs.next();
//System.out.println(String.format("name: %1s, status: %1s, gender: %1s, age: %1d, state: %1s", rs.getName(1), rs.getStatus(1), rs.getGender(1), rs.getAge(1), rs.getState(2)));
connection.commit();
} catch (SQLException e2) {
e2.printStackTrace();
} catch (ClassNotFoundException e2) {
e2.printStackTrace();
}
// end of stub code for in/out stub
}
}

