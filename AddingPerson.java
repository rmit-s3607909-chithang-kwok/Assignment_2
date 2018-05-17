import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class AddingPerson implements Initializable{
	@FXML private Label name;
	@FXML private Label status;
	@FXML private Label gender;
	@FXML private Label Age;
	@FXML private Label State;
	
	@FXML private TextField NameList;
	@FXML private TextField StatusList;
	@FXML private TextField GenderList;
	@FXML private TextField AgeList;
	@FXML private TextField StateList;
	
	
	@FXML private Button bt1;
	@FXML private Button bt2;
	private Desktop desktop = Desktop.getDesktop();
	
	public void Add(ActionEvent event) throws Exception {
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		 PrintWriter writer = null;
	 		
	 		try {
	 			writer = new PrintWriter("peoples.txt");
	 			BufferedWriter bwriter = new BufferedWriter(writer);
	 			//writer = new PrintWriter(new FileOutputStream("output.txt", true));
	 			//appending the file
	 			
	 		} catch (FileNotFoundException e) {
	 			System.err.println("File cannot be created, or cannot be opened");
	 			System.exit(0);
	 		}
	 		
	 		writer.write(NameList.getText() + " , ");
	 		writer.write(StatusList.getText() + " , ");
	 		writer.write(GenderList.getText()+ " , ");
	 		writer.write(AgeList.getText() + " , ");
	 		writer.write(StateList.getText() + " ");
	 		
	 		
	 		writer.close();	
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	 public void BackToPreviousMenu(ActionEvent event) throws Exception{
     	
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
       
   		
   	}
   
      
       
    

	
