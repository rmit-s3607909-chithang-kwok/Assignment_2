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

public class Identify implements Initializable{

	//Editted by Chit Hang Kwok. This program is to identify the children parent friend relationship by deleting one of them.
		@FXML Label Name1;
	 	@FXML Label Name2;
	 	@FXML Label Relationship;
	 	@FXML Label Result;
	 
	    @FXML TextField FirstPeopleName;
	    @FXML TextField SecondPeopleName; 
	    @FXML TextField TheirRelationship;

	    @FXML private TableView<Relation> tableRelation;
		@FXML private TableColumn<Relation, String> ColumnName1;
		@FXML private TableColumn<Relation, String> ColumnName2;
		@FXML private TableColumn<Relation, String> ColumnRelationship;
	    //@FXML Button bt1;
	    @FXML Button bt2;
	    @FXML Button bt3;
	 
	    @FXML Text text;
	    
	    public class NoParentException extends Exception{}
	    public class NoParentException2 extends Exception{}
	    public class NoParentException3 extends Exception{}
		public class NotToBeFriendsException extends Exception{}
		public class TooYoungException extends Exception{}
		public class NotToBeClassmateException extends Exception{}
		
	    //connect to the database and then set Text from invisible	
	    
	    private Connection con = null;
		private PreparedStatement pst = null;
		private ResultSet rs = null;
		private ObservableList<Relation> data;
		
		
			
		
		
	
	    public void BackToPreviousMenu(ActionEvent event) throws Exception{
	    	Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    	primaryStage.setScene(scene);
			primaryStage.show();
			
		}

		
	    
	  //Delete button clicked
	    public void deleteButtonClicked(ActionEvent event)throws Exception{
	    	String NALIST=FirstPeopleName.getText();
	    	String NBLIST=SecondPeopleName.getText();
	    	String RLIST=TheirRelationship.getText();
	    
	    		String sql = "DELETE FROM relation where Name1 = ? and Name2 = ? and Relationship = ?";
	    	
	    	
	    	
	    	
	    
		 		
				
				 try {
			 			
				 		
		 			 pst = con.prepareStatement(sql);
		 			 
		 		 
		 		pst.setString(1, NALIST);
		 		pst.setString(2, NBLIST);
		 		pst.setString(3, RLIST);
		 	
		 		
		 		int i = pst.executeUpdate();
		 		if (i == 1) {
		 		    System.out.println("data delete successfully");
		 		}else if ((NALIST.equals("Mary Turner")&&!(NBLIST.equals("Ben Turner"))&&(RLIST.equals("parent")))||(NALIST.equals("Mary Turner")&&!(NBLIST.equals("Mary Hopkin"))&&(RLIST.equals("parent"))))
		 		{throw new NoParentException();
		 		}else if ((NALIST.equals("Alex Turner")&&!(NBLIST.equals("Ben Turner"))&&(RLIST.equals("parent")))||(NALIST.equals("Alex Turner")&&!(NBLIST.equals("Mary Hopkin"))&&(RLIST.equals("parent"))))
		 		{throw new NoParentException2();
		 		}else if ((!(NALIST.equals("Alex Smith"))&&NBLIST.equals("John Smith")&&(RLIST.equals("parent")))||(NALIST.equals("John Smith"))&&!(NBLIST.equals("Klay Thomas"))&&(RLIST.equals("parent")))
		 		{throw new NoParentException3();
		 		}
				 }catch (NoParentException eh) {
			 			System.err.println("Mary Turner have parents name Ben Turner and Mary Hopkin respectively. Other person she just cannot accept it.");
				 }catch (NoParentException2 ek) {
				 			System.err.println("Alex Turner have parents name Ben Turner and Mary Hopkin respectively. Other person he just cannot accept it.");
				 }catch (NoParentException3 ep) {
					 			System.err.println("John Smith have parents name Alex Smith and Klay Thomas respectively. Other person he just cannot accept it.");
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



		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			
		con = DBConnection.pmartConnection();
		data=FXCollections.observableArrayList();
		setCellTable();
		LoadDataFromDatabase();
		}
   
		private void setCellTable() {
	ColumnName1.setCellValueFactory(new PropertyValueFactory<>("Name1"));
	ColumnName2.setCellValueFactory(new PropertyValueFactory<>("Name2"));
	ColumnRelationship.setCellValueFactory(new PropertyValueFactory<>("Relationship"));
	
	
}
private void LoadDataFromDatabase() {
	try {

		pst = con.prepareStatement("Select * from relation");
		rs=pst.executeQuery();
		while(rs.next())
		{
			data.add(new Relation(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
	}catch(SQLException ex) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
		}
	tableRelation.setItems(data);
}
}
