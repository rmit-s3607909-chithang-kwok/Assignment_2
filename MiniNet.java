


import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hsqldb.Server;

import java.sql.Statement;
//import org.hsqldb.Server;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MiniNet extends Application{
	
	//Editted by Chit Hang Kwok
	//This program is to open all the gui file.

		// TODO Auto-generated constructor stub
	  public void start(Stage primaryStage) throws Exception{
			try {
		    primaryStage.setTitle("DisplayFile");
			Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
			Scene scene = new Scene(root);
		    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	
	  

	public static void main(String[] args) throws Exception {
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
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
		
		} catch (SQLException e2) {
		e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
		e2.printStackTrace();
		}
		// end of stub code for in/out stub
			
			launch(args);	

}

	public static void display(List list) {
	int i = 1;
	for (Iterator it = list.iterator(); it.hasNext(); ) {
		Person p = (Person)it.next();	
		System.out.println(i + "------------------"+ p.getName());
		i++;
	}
	}
	
	
	
}

	        

