
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeletePerson implements Initializable{
	//Editted by Chit Hang Kwok
	//This program is to delete the peoples information from the txt file.

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
	
	public void Delete(ActionEvent event) throws Exception {

	String NLIST=NameList.getText();
	String SLIST=StatusList.getText();
	String GLIST=GenderList.getText();
	Integer ALIST = Integer.valueOf(AgeList.getText());
	String STLIST=StateList.getText();
		String sql = "DELETE FROM people (NLIST,SLIST, GLIST, ALIST, STLIST), VALUES(?,?,?,?,?)";
		
		
		
		 
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
	 			 
	 		 
	 		pst.setString(1, NLIST);
	 		pst.setString(2, SLIST);
	 		pst.setString(3, GLIST);
	 		pst.setInt(4, ALIST);
	 		pst.setString(5, STLIST);
	 		
	 		int i = pst.executeUpdate();
	 		if (i == 1) {
	 		    text.setText("data delete successfully");
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
		ColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		ColumnStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
		ColumnGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
		ColumnAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
		ColumnState.setCellValueFactory(new PropertyValueFactory<>("State"));
		
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