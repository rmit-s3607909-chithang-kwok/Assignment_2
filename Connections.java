

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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

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
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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

	    @FXML private TableView<Relation> tableRelation;
		@FXML private TableColumn<Relation, String> ColumnName1;
		@FXML private TableColumn<Relation, String> ColumnName2;
		@FXML private TableColumn<Relation, String> ColumnRelationship;
	    @FXML Button bt1;
	    @FXML Button bt2;
	    @FXML Button bt3;
	 
	    @FXML Text text;
	    
	    public class TooYoungException extends Exception{}
		public class NotToBeFriendsException extends Exception{}
		public class NoAvailableException extends Exception{}
		public class NotToBeCoupledException extends Exception{}
		public class NotToBeColleagueException extends Exception{}
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

		//Add button clicked
	    public void addButtonClicked(ActionEvent event)throws Exception {
	    	String NALIST=FirstPeopleName.getText();
	    	String NBLIST=SecondPeopleName.getText();
	    	String RLIST=TheirRelationship.getText();
	    
	    	String sql = "INSERT INTO relation  (Name1, Name2, Relationship) VALUES (?,?,?)";
		 		
				
		 		
				
				 try {
			 			
				 		
		 			 pst = con.prepareStatement(sql);
		 			 
		 		 
		 		pst.setString(1, NALIST);
		 		pst.setString(2, NBLIST);
		 		pst.setString(3, RLIST);
		 	
		 		
		 		
		 		int i = pst.executeUpdate();
		 		if (i == 1) {
		 		    System.out.println("data insert successfully");
		 		}else if (NALIST.equals("Mary Turner")&&NBLIST.equals("Ben Turner")||NALIST.equals("Ben Turner")&&NBLIST.equals("Mary Turner")) {
		 			throw new NotToBeFriendsException();
		 			
		 			
		 		}else if ((NALIST.equals("Mary Turner")&&RLIST.equals("friend"))||(NBLIST.equals("Mary Turner")&&RLIST.equals("friend")))
		 				{throw new TooYoungException();
		 			
		 				
		 				}else if ((NALIST.equals("Alex Smith")&&NBLIST.equals("Mary Hopkin")&&RLIST.equals("couple"))||(NALIST.equals("Ben Turner")&&NBLIST.equals("Klay Thomas")&&RLIST.equals("couple")) ){
		 					throw new NoAvailableException();
		 					
		 				}else if ((NALIST.equals("Alex Smith")&&!(NBLIST.equals("Zoe Foster")))||(NALIST.equals("Zoe Foster")&&!(NBLIST.equals("Alex Smith"))) ) 
		 					{throw new NotToBeColleagueException();
		 					
		 				}else if ((NALIST.equals("Hannah White")&&!(NBLIST.equals("John Smith")))||(NALIST.equals("John Smith")&&!(NBLIST.equals("Hannah White")))) 
		 					{throw new NotToBeClassmateException();
		 					
		 					}
		 			}catch (NotToBeFriendsException e1) {
		 				System.err.println("They cannot be friend because they are brother and sister. Please retype again."); 
		 			}catch (TooYoungException er) {
		 				System.err.println("She is too young to have any friend.Please type other relation again.");
		 			}catch(NoAvailableException ev) {
		 				System.err.println("Ben Turner or Alex Smith cannot marriage again if they dont devorce.Please type again");
		 			}catch(NotToBeColleagueException et) {
				 		System.err.println("Alex Smith and Zoe Foster can only be colleague together.");
		 			}catch(NotToBeClassmateException ey) {
		 				System.err.println("John Smith and Hannah White are classmate so please dont put other unrelated person in");
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