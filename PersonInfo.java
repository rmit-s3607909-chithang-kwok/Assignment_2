import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonInfo extends Application {

    Stage window;
    TableView<Person> table;
    @ FXML TextField nameInput, StatusInput, GenderInput, AgeInput, StateInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Add&DeletePerson - JavaFX");

        //Name column
        TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        //Status column
        TableColumn<Person, String> StatusColumn = new TableColumn<>("Status");
        StatusColumn.setMinWidth(200);
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));

        //Gender column
        TableColumn<Person, String> GenderColumn = new TableColumn<>("Gender");
        GenderColumn.setMinWidth(100);
        GenderColumn.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        
        //Age column
        TableColumn<Person, Integer> AgeColumn = new TableColumn<>("Age");
        AgeColumn.setMinWidth(100);
        AgeColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
        
        //State column
        TableColumn<Person, String> StateColumn = new TableColumn<>("State");
        StateColumn.setMinWidth(100);
        StateColumn.setCellValueFactory(new PropertyValueFactory<>("State"));

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Status input
        StatusInput = new TextField();
        StatusInput.setPromptText("Status");

        //Gender input
        GenderInput = new TextField();
        GenderInput.setPromptText("Gender");
        
        //Age input
        AgeInput = new TextField();
        AgeInput.setPromptText("Age");
        
        //State input
        StateInput = new TextField();
        StateInput.setPromptText("State");

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        Button nextButton = new Button("Next");
        nextButton.setOnAction(e -> {
			try {
				nextButtonClicked();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
       
      
        
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(100,100,100,100));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, StatusInput, GenderInput, AgeInput, StateInput, addButton, deleteButton, nextButton);

        table = new TableView<>();
        table.setItems(getPerson());
        table.getColumns().addAll(nameColumn, StatusColumn, GenderColumn, AgeColumn, StateColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    
    
    
   
    
    

	private void nextButtonClicked() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SubMenu.fxml"));
		Scene scene = new Scene(root);
		 window.setScene(scene);
	        window.show();
		
	}

	//Add button clicked
    public void addButtonClicked(){
        Person Person = new Person();
        Person.setName(nameInput.getText());
        Person.setStatus(StatusInput.getText());
        Person.setGender(GenderInput.getText());
        Person.setAge(Integer.parseInt(AgeInput.getText()));
        Person.setState(StateInput.getText());
        table.getItems().add(Person);
        nameInput.clear();
        StatusInput.clear();
        GenderInput.clear();
        AgeInput.clear();
        StateInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Person> PersonSelected, allPerson;
        allPerson = table.getItems();
        PersonSelected = table.getSelectionModel().getSelectedItems();

        PersonSelected.forEach(allPerson::remove);
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