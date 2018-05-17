import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SelectPerson implements Initializable{
	
	@FXML private Button bt1;
	
	@FXML private Button bt2;
	
	@FXML private Button bt3;
	
	
	
	public void UpdatePerson (ActionEvent event)throws Exception{
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("AddPerson.fxml"));
		Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	}

	public void DeletePerson (ActionEvent event)throws Exception{
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("DeletePerson.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	}
	
	public void BackToPreviousMenu (ActionEvent event)throws Exception{
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
