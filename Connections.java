
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class Connections implements Initializable {
		//Editted by Chit Hang Kwok
		//This program is to connect two peoples by method of classmate, collegue, friend, couple, parent and Children.
	 	
	
		@FXML Label Name1;
	 	@FXML Label Name2;
	 	@FXML Label Relationship;
	 	@FXML Label Result;
	 
	    @FXML TextField FirstPeopleName;
	    @FXML TextField SecondPeopleName; 
	    @FXML TextField TheirRelationship;

	    @FXML private TableView<Person> tablePerson;
		@FXML private TableColumn<Person, String> ColumnName1;
		@FXML private TableColumn<Person, String> ColumnName2;
		@FXML private TableColumn<Person, String> ColumnRelationship;
	    @FXML Button bt1;
	    @FXML Button bt2;
	    @FXML Button bt3;
	 
	    @FXML Text text;
		
	    //connect to the database and then set Text from invisible	
	    
	    private Connection con = null;
		private PreparedStatement pst = null;
		private ResultSet rs = null;
		private ObservableList<Person> data;
		
		
			
		
		
	
	    public void BackToPreviousMenu(ActionEvent event) throws Exception{
	    	Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    	primaryStage.setScene(scene);
			primaryStage.show();
			
		}

		//Add button clicked
	    public void addButtonClicked(ActionEvent event)throws Exception{
	    	String NaList=FirstPeopleName.getText();
	    	String NbList=SecondPeopleName.getText();
	    	String RList=TheirRelationship.getText();
	    
	    		String sql = "INSERT INTO relation VALUES (NaList,NbList, RList, Values(?,?,?)";
	    	
	    	
	    	
	    	
	    	
	    	Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();		
	         
	        // FileWriter writer = null;
		 		
		 		//try {
		 			
		 			
		 			//writer = new FileWriter("C:\\Users\\PC\\Desktop\\AllPersonFile\\relation.txt", true);
		 			//BufferedWriter bwriter = new BufferedWriter(writer);
		 			
		 			//writer = new PrintWriter(new FileOutputStream("output.txt", true));
		 			//appending the file
		 			
		 		//} catch (FileNotFoundException e) {
		 		//	System.err.println("File cannot be created, or cannot be opened");
		 		//	System.exit(0);
		 		//}
		 		
		 		//writer.append(FirstPeopleName.getText() + " , ");
		 		//writer.append(SecondPeopleName.getText() + " , " );
		 	//	writer.append(TheirRelationship.getText() + " . ");
		 		
		 		
		 		//writer.close();	
		 		
		 		
				
		 		
				
				 try {
			 			
				 		
		 			 pst = con.prepareStatement(sql);
		 			 
		 		 
		 		pst.setString(1, NaList);
		 		pst.setString(2, NbList);
		 		pst.setString(3, RList);
		 	
		 		
		 		int i = pst.executeUpdate();
		 		if (i == 1) {
		 		    text.setText("data insert successfully");
		 		    text.setVisible(true);
		 		}
		 		 }catch(SQLException ex) {
		 			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
		 		} catch (Exception e) {
		 			e.printStackTrace(System.out);
		 		}
		 		finally {
		 		pst.close();
		            if (con != null) {
			        text.setText("Database connection successfully");
			        text.setVisible(true);
			        }else {
			        	text.setText("Database Connection Failure");;
			        }
		            }
	    }
	    
	  //Add button clicked
	    public void deleteButtonClicked(ActionEvent event)throws Exception{
	    	Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					
	         
	         PrintWriter writer = null;
		 		
		 		try {
		 			writer = new PrintWriter("C:\\Users\\PC\\Desktop\\AllPersonFile\\relation.txt");
		 			BufferedWriter bwriter = new BufferedWriter(writer);
		 			
		 			//writer = new PrintWriter(new FileOutputStream("output.txt", true));
		 			//appending the file
		 			
		 		} catch (FileNotFoundException e) {
		 			System.err.println("File cannot be created, or cannot be opened");
		 			System.exit(0);
		 		}
		 		
		 		writer.write(FirstPeopleName.getText() + "   ");
		 		writer.write(SecondPeopleName.getText() + "   " );
		 		writer.write(TheirRelationship.getText() + " ");
		 		
		 		
		 		writer.close();		
	         
		 		primaryStage.setScene(scene);
				primaryStage.show();
	    }

	   

	   
	  
			
		








		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			
		//con = DBConnection.pmartConnection();
		//data=FXCollections.observableArrayList();
		//setCellTable();
		//LoadDataFromDatabase();
		}
   
		private void setCellTable() {
	ColumnName1.setCellValueFactory(new PropertyValueFactory<>("name"));
	ColumnName2.setCellValueFactory(new PropertyValueFactory<>("name"));
	ColumnRelationship.setCellValueFactory(new PropertyValueFactory<>("status"));
	
	
}
private void LoadDataFromDatabase() {
	try {

		pst = con.prepareStatement("Select * from relation");
		rs=pst.executeQuery();
		while(rs.next())
		{
			data.add(new Person(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
	}catch(SQLException ex) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
		}
	tablePerson.setItems(data);
}
}