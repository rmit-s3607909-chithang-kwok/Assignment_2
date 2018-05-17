import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class Connections implements Initializable {

	 	@FXML Label Name1;
	 	@FXML Label Name2;
	 	@FXML Label Relationship;
	 	
	 
	    @FXML TextField FirstPeopleName;
	    @FXML TextField SecondPeopleName; 
	    @FXML TextField TheirRelationship;

	
	    @FXML Button bt1;
	    @FXML Button bt2;
	 
		
		

	    public void BackToPreviousMenu(ActionEvent event) throws Exception{
	     	Parent tableViewParent = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
	         Scene tableViewScene = new Scene(tableViewParent);
	         
	         //This line gets the Stage information
	         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	         
	        
	         
	         window.setScene(tableViewScene);
	         window.show();
			
		}

		//Add button clicked
	    public void addButtonClicked(ActionEvent event)throws Exception{
	    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
	         Scene tableViewScene = new Scene(tableViewParent);
	         
	         //This line gets the Stage information
	         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	         
	        
	         
	         window.setScene(tableViewScene);
	         window.show();
	    }

	   

	   
	  
			
		








		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			
		}
}