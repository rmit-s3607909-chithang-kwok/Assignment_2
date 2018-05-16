

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * FXML Controller class
 *
 * 
 */
public class PersonalInfo implements Initializable {

    //configure the table
     private TableView<Person> table;
     private TableColumn<Person, String> NameColumn;
     private TableColumn<Person, Image>  ImageColumn;
     private TableColumn<Person, String> StatusColumn;
     private TableColumn<Person, String> GenderColumn;
     private TableColumn<Person, String> StateColumn;
     private TableColumn<Person, Integer> AgeColumn;
    
    //These instance variables are used to create new Person objects
     private TextField NameTextField;
     private TextField ImageTextField;
     private TextField StatusTextField;
     private TextField GenderTextField;
     private TextField AgeTextField;
     private TextField StateTextField;
    
     private Button detailedPersonViewButton;
     private Button AddPerson;
     private Button DeletePerson;
     private Button BackToPValue;
     
    
        

    
     
    /**
     * This method will allow the user to double click on a cell and update
     * the name of the person
     */
    public void changeNameCellEvent(CellEditEvent edittedCell)
    {
        Person personSelected =  table.getSelectionModel().getSelectedItem();
        personSelected.setName(edittedCell.getNewValue().toString());
    }
    
    /**
     * This method will allow the user to double click on a cell and update
     * the status of the person
     */
    public void changeStatusCellEvent(CellEditEvent edittedCell)
    {
        Person personSelected =  table.getSelectionModel().getSelectedItem();
        personSelected.setStatus(edittedCell.getNewValue().toString());
    }
    
    /**
     * This method will allow the user to double click on a cell and update
     * the state of the person
     */
    public void changeStateCellEvent(CellEditEvent edittedCell)
    {
        Person personSelected =  table.getSelectionModel().getSelectedItem();
        personSelected.setState(edittedCell.getNewValue().toString());
    }
    
    /**
     * This method will allow the user to double click on a cell and update
     * the age of the person
     */
    public void changeAgeCellEvent(CellEditEvent edittedCell)
    {
    	
    	
    	
        Person personSelected =  table.getSelectionModel().getSelectedItem();
        personSelected.setAge(Integer.parseInt(edittedCell.getNewValue().toString()));
   }
    
    /**
     * This method will allow the user to double click on a cell and update
     * the gender of the person
     */
    public void changeGenderCellEvent(CellEditEvent edittedCell)
    {
        Person personSelected =  table.getSelectionModel().getSelectedItem();
        personSelected.setGender(edittedCell.getNewValue().toString());
    }
    /**
     * This method will enable the detailed view button once a row in the table is
     * selected
     */
    public void userClickedOnTable()
    {
        this.detailedPersonViewButton.setDisable(false);
    }
   
    
    /**
     * When this method is called, it will change the Scene to 
     * a SubMenu
     */
    
   
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
    	
    	
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
       
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    /**
     * When this method is called, it will pass the selected Person object to
     * a the detailed view
     */
  
    
    public void changeSceneToDetailedPersonView(ActionEvent event) throws IOException
    {
    	
		
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PersonDetails.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
        
        //access the controller and call a method
       PersonDetails controller = loader.getController();
       controller.initData(table.getSelectionModel().getSelectedItem());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
       
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
        NameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("Name"));
        //ImageColumn.setCellValueFactory(new PropertyValueFactory<Person, Image>("Image"));
       StatusColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("Status"));
       GenderColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("Gender"));
       AgeColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("Age"));
       StateColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("State"));
        
        //load dummy data
        table.setItems(getPerson());
        
        //Update the table to allow for the fields
        //to be editable
        table.setEditable(true);
        NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       // ImageColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        StatusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        GenderColumn.setCellFactory(TextFieldTableCell.forTableColumn());
       AgeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        
        StateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        //This will allow the table to select multiple rows at once
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        //Disable the detailed person view button until a row is selected
        this.detailedPersonViewButton.setDisable(true);
    }    
    
    

    
    public void deleteButtonPushed()
    {
        ObservableList<Person> selectedRows, allPeople;
        allPeople = table.getItems();
        
        //this gives us the rows that were selected
       selectedRows = table.getSelectionModel().getSelectedItems();
        
        //loop over the selected rows and remove the Person objects from the table
        for (Person person: selectedRows)
        {
            allPeople.remove(person);
        }
    }
    
    
    
    
   public void newPersonButtonPushed() {
		Person newPerson = new Person(NameTextField.getText(),
                                      StatusTextField.getText(),
                                     GenderTextField.getText(),
                                     Integer.parseInt(AgeTextField.getText()),
                                      StateTextField.getText());
        
      //  Get all the items from the table as a list, then add the new person to
        //the list
        table.getItems().add(newPerson);
    }
    
    
    
   
	//Get all of the Person
	public ObservableList<Person> getPerson(){
    ObservableList<Person> Person = FXCollections.observableArrayList();
    Person.add(new Person("Alex Smith", "student at RMIT", "M", 35, "WA" ));
    Person.add(new Person("Ben Turner", "manager at ZFX", "M", 45, "VIC" ));
    Person.add(new Person("Hannah White", "student at PLC", "F", 12, "VIC" ));
    Person.add(new Person("Zoe Foster", "Founder of ZFX", "M", 33, "VIC" ));
    Person.add(new Person("Mary Turner", "looking for job", "F", 2, "VIC" ));
    Person.add(new Person("john Smith", "student at PLC", "M", 12, "VIC" ));
    Person.add(new Person("Mary Hopkin", "House Worker", "F", 38, "TAS" ));
    Person.add(new Person("Alex Turner", "student at LaTrobe", "M", 22, "VIC" ));
    Person.add(new Person("Klay Thomas", "House Worker", "F", 33, "NSW" ));
            
    return Person;
}
}

