//package application;




import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.stage.Stage;





public class MainController implements Initializable{

	
	@FXML private Label lblStatus;
	
	@FXML private TextField txtUsername;
	
	@FXML private TextField txPassword;
	
	@FXML private Button bt1;
	
	public void Login(ActionEvent event) throws Exception{
		
		//if (txtUsername.getText().equals("user") && txPassword.getText().equals("pass")) {
		//	lblStatus.setText("Login Success");
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Submenu.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	//	} else {
		//lblStatus.setText("Login Failure");
		//}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}	
		