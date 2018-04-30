package application;

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

public class Main extends Application{

	
		// TODO Auto-generated constructor stub
	  public void start(Stage primaryStage) throws Exception{
			try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/FileChooser.fxml"));
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
		FileWriter writer = null;
		FileWriter writer1 = null;
		

		try {
			writer = new FileWriter("peoples.txt");

			writer.write("[Alex Smith, 'AlexPhoto.jpg', student at RMIT, M, 35, WA], \n");
			writer.write("[Ben Turner, 'BenPhoto.jpg', manager at ZFX, M, 45, VIC], \n");
			writer.write("[Hannah Write, 'Hannah.png', student at PLC, F, 12, VIC], \n");
			writer.write("[Zoe Foster, 'ZoePhoto.jpg', Founder of ZFX, F, 33, VIC], \n");
			writer.write("[Mark Turner, 'Mark.jpeg', looking for jobs, M, 2 VIC], \n");
			writer.write("[John Smith, 'JohnPhoto.jpeg, student at PLC, M, 12, VIC], \n");
			writer.write("[Mary Hopkin, 'MaryPhoto.jpeg, House Worker, F, 38, TAS], \n");
			writer.write("[Alex Turner, 'ATurnerPhoto.jpeg, student at LaTrobe, M, 12, VIC], \n");
			

			writer.close();// flushes the stream.

			writer1 = new FileWriter("relation.txt");

			writer1.write("[Alex Smith, Ben Turner, friend], \n");
			writer1.write("[Ben Turner, Mark Hopkin, couple], \n");
			writer1.write("[Mark Turner, Ben Turner, parent], \n");
			writer1.write("[Mark Turner, Mary Hopkin, parent], \n");
			writer1.write("[Alex Turner, Mark Hopkin, parent], \n");
			writer1.write("[Alex Turner1 Ben Turner, parent], \n");
			writer1.write("[Alex Smith, Klay Thomas, couple], \n");
			writer1.write("[Alex Turner, John Smith, friend], \n");
			writer1.write("[John Smith, Alex Smith, parent], \n");
			writer1.write("[John Smith, Klay Thomas, parent], \n");
			writer1.write("[Zoe Foster, Alex Smith, colleagues], \n");
			writer1.write("[Hannah White, John Smith, classmate], \n");

			writer1.close();// flushes the stream.
			
		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
		
			launch(args);
	}


	        

}
