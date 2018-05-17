

	import java.net.URL;
	import java.util.ResourceBundle;

	import javafx.event.ActionEvent;
	import javafx.fxml.FXMLLoader;
	import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.stage.Stage;

	public class ConnectPerson implements Initializable{
		
		private Button bt1;
		
		private Button bt2;
		
		private Button bt3;
		
		private Button bt4;
		
		private Button bt5;
		
		private Button bt6;
		
		private Button bt7;
		
		
		
		public void ConnectFriend (ActionEvent event)throws Exception{
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	       
	        
	        window.setScene(tableViewScene);
	        window.show();
			//Stage primaryStage = new Stage();
			//Parent root = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
			//Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//		primaryStage.setScene(scene);
			//		primaryStage.show();
		}
		
		public void ConnectCouple (ActionEvent event)throws Exception{
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	       
	        
	        window.setScene(tableViewScene);
	        window.show();
			//Stage primaryStage = new Stage();
			//Parent root = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
			//Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//		primaryStage.setScene(scene);
			//		primaryStage.show();
		}

		public void ConnectCollegue (ActionEvent event)throws Exception{
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	       
	        
	        window.setScene(tableViewScene);
	        window.show();
			//Stage primaryStage = new Stage();
			//Parent root = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
			//Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//		primaryStage.setScene(scene);
				//	primaryStage.show();
		}

		public void ConnectParent (ActionEvent event)throws Exception{
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	       
	        
	        window.setScene(tableViewScene);
	        window.show();
			//Stage primaryStage = new Stage();
			//Parent root = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
		//	Scene scene = new Scene(root);
		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//		primaryStage.setScene(scene);
				//	primaryStage.show();
		}
		
		public void ConnectChildren (ActionEvent event)throws Exception{
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	       
	        
	        window.setScene(tableViewScene);
	        window.show();
			//Stage primaryStage = new Stage();
			//Parent root = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
			//Scene scene = new Scene(root);
		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//		primaryStage.setScene(scene);
			//		primaryStage.show();
		}

		public void ConnectClassmate (ActionEvent event)throws Exception{
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	       
	        
	        window.setScene(tableViewScene);
	        window.show();
			//Stage primaryStage = new Stage();
			//Parent root = FXMLLoader.load(getClass().getResource("SelectPerson.fxml"));
			//Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//		primaryStage.setScene(scene);
			//		primaryStage.show();
		}
		public void BackToPreviousMenu (ActionEvent event)throws Exception{
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	       
	        
	        window.setScene(tableViewScene);
	        window.show();
		//	Stage primaryStage = new Stage();
			//Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
		//	Scene scene = new Scene(root);
		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//		primaryStage.setScene(scene);
				//	primaryStage.show();
		}
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}

	}
