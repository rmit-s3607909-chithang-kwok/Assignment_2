

import java.io.IOException;
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * 
 */
public class PersonDetails implements Initializable {

    private Person selectedPerson;
    
    @FXML private Label NameLabel;
    @FXML private Label StatusLabel;    
    @FXML private Label GenderLabel;
    @FXML private Label AgeLabel;
    @FXML private Label StateLabel;
    
    @FXML private ImageView ImageLabel;
    
    @FXML private Button bt1;
    
    /**
     * This method accepts a person to initialize the view
     * @param person 
     */
    public void initData(Person person)
    {
        selectedPerson = person;
        NameLabel.setText(selectedPerson.getName());
        StatusLabel.setText(selectedPerson.getStatus());
        GenderLabel.setText(selectedPerson.getGender());
        AgeLabel.setText(Integer.toString(selectedPerson.getAge()));
        StateLabel.setText(selectedPerson.getState());
        ImageLabel.setImage(selectedPerson.getFiled());
    }
    
    
        /**
     * When this method is called, it will change the Scene to 
     * a Person Info example
     */
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
    	
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("PersonInfo.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
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
        // TODO
    }    
    
}
