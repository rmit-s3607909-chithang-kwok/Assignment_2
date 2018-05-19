
import java.awt.Desktop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

import java.sql.Connection;

public class AddingPerson implements Initializable{
	//Editted by Chit Hang Kwok
	//This program is to add the peoples information to the txt file.
	@FXML private Label NameL;
	@FXML private Label StatusL;
	@FXML private Label GenderL;
	@FXML private Label AgeL;
	@FXML private Label StateL;
	
	@FXML private TextField NameList;
	@FXML private TextField StatusList;
	@FXML private TextField GenderList;
	@FXML private TextField AgeList;
	@FXML private TextField StateList;
	
	

	@FXML Text text;
	@FXML private Button bt1;
	@FXML private Button bt2;
	
	@FXML private TableView<Person> tablePerson;
	@FXML private TableColumn<Person, String> ColumnName;
	@FXML private TableColumn<Person, String> ColumnStatus;
	@FXML private TableColumn<Person, String> ColumnGender;
	@FXML private TableColumn<Person, Integer> ColumnAge;
	@FXML private TableColumn<Person, String> ColumnState;
	
	
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private ObservableList<Person> data;
	
	public void Add(ActionEvent event) throws Exception {

	String NList=NameList.getText();
	String SList=StatusList.getText();
	String GList=GenderList.getText();
	Integer AList = Integer.valueOf(AgeList.getText());
	String StList=StateList.getText();
		String sql = "INSERT INTO people VALUES (NList,SList, GList, AList, StList), Values(?,?,?,?,?)";
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		 
	 		/*FileWriter writer = null;
	 		try {
	 			writer = new FileWriter("C:\\Users\\PC\\Desktop\\AllPersonFile\\peoples.txt", true);
	 			BufferedWriter bwriter = new BufferedWriter(writer);
	 			//writer = new PrintWriter(new FileOutputStream("output.txt", true));
	 			//appending the file
	 			
	 		} catch (FileNotFoundException e) {
	 			System.err.println("File cannot be created, or cannot be opened");
	 			System.exit(0);
	 		}
	 		
	 		writer.append(NameList.getText() + " , ");
	 		writer.append(StatusList.getText() + " , ");
	 		writer.append(GenderList.getText()+ " , ");
	 		writer.append(AgeList.getText() + " , ");
	 		writer.append(StateList.getText() + " . ");
	 		
	 		
	 		writer.close();*/
	 		
	 		 try {
	 			
	 		
	 			 pst = con.prepareStatement(sql);
	 			 
	 		 
	 		pst.setString(1, NList);
	 		pst.setString(2, SList);
	 		pst.setString(3, GList);
	 		pst.setInt(4, AList);
	 		pst.setString(5, StList);
	 		
	 		int i = pst.executeUpdate();
	 		if (i == 1) {
	 		    text.setText("data insert successfully");
	 		    text.setVisible(true);
	 		}
	 		 }catch(SQLException ex) {
	 			Logger.getLogger(AddingPerson.class.getName()).log(Level.SEVERE, null, ex);
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
	
	 public void BackToPreviousMenu(ActionEvent event) throws Exception{
     	
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
	
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
	

		con = DBConnection.pmartConnection();
		data=FXCollections.observableArrayList();
			setCellTable();
			LoadDataFromDatabase();
		
	
		
	}
       
	private void setCellTable() {
		ColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		ColumnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		ColumnGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		ColumnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
		ColumnState.setCellValueFactory(new PropertyValueFactory<>("state"));
		
	}
	private void LoadDataFromDatabase() {
		try {
	
   		pst = con.prepareStatement("Select * from people");
   		rs=pst.executeQuery();
   		while(rs.next())
   		{
   			data.add(new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
   		}
		}catch(SQLException ex) {
 			Logger.getLogger(AddingPerson.class.getName()).log(Level.SEVERE, null, ex);
 		}
		tablePerson.setItems(data);
	}
}
      
       
    

	
