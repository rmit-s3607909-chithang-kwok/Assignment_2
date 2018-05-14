//package application;


import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MiniNet extends Application{

	
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
	
	  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			WriteFile();
			launch(args);
	}

	public static void WriteFile() {
		FileWriter writer = null;
		FileWriter writer1 = null;
		

		try {
			writer = new FileWriter("C:\\Users\\PC\\Desktop\\AllPersonFile\\peoples.txt");

			writer.write("Alex Smith, 'AlexSmith.jpg', 'student at RMIT', M, 35, WA, \n");
			writer.write("Ben Turner, 'BenTurner.jpg', 'manager at ZFX', M, 45, VIC, \n");
			writer.write("Hannah Write, 'HannahWrite.jpg', 'student at PLC', M, 12, VIC, \n");
			writer.write("Zoe Foster, 'ZoeFoster.jpg', 'Founder of ZFX', M, 33, VIC, \n");
			writer.write("Mark Turner, 'MarkTurner.jpeg', 'looking for jobs', F, 2 VIC, \n");
			writer.write("John Smith, 'JohnSmith.jpeg, 'student at PLC', M, 12, VIC, \n");
			writer.write("Mary Hopkin, 'MaryHopkin.jpeg, 'House Worker', F, 38, TAS, \n");
			writer.write("Alex Turner, 'AlexTurner.jpeg, 'student at LaTrobe', M, 12, VIC, \n");
			writer.write("Klay Thomas, 'KlayThomas.jpeg, 'House Worker', F, 33, NSW, \n");
			

			writer.close();// flushes the stream.

			writer1 = new FileWriter("C:\\Users\\PC\\Desktop\\AllPersonFile\\relation.txt");

			writer1.write("Alex Smith, Ben Turner, friend, \n");
			writer1.write("Ben Turner, Mark Hopkin, couple, \n");
			writer1.write("Ben Turner, Mary Turner, parent, \n");
			writer1.write("Mark Hopkin, Mary Turner, parent, \n");
			writer1.write("Alex Turner, Mark Hopkin, parent, \n");
			writer1.write("Alex Turner, Ben Turner, parent, \n");
			writer1.write("Alex Smith, Klay Thomas, couple, \n");
			writer1.write("Alex Turner, John Smith, friend, \n");
			writer1.write("John Smith, Klay Thomas, parent, \n");
			writer1.write("Alex Smith, Zoe Foster, colleagues, \n");
			writer1.write("John Smith, Hannah White, classmate, \n");

			writer1.close();// flushes the stream.
			
		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
		
	}
	}

	        

