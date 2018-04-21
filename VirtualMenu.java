
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
//import java.util.*;

public class VirtualMenu extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane and set its properties
		FlowPane pane=new FlowPane(Orientation.VERTICAL,5,5);//hGap=5,vGap = 5
        // FlowPane pane=new FlowPane(Orientation.HORIZONTAL,5,5);//hGap=5,vGap = 5
		pane.setPadding(new Insets(11, 12, 13, 14));
		// Place nodes in the pane
		
		//Scanner sc = new Scanner (System.in);
		//int input = 0;
		
		pane.getChildren().addAll(new Label("Welcome to MiniNet"),
				                  new Label("___________________"),
				                  new Label("1. Add a person"), 
				                  new Label("2. Select a person"),
				                  new Label("3. Display the profile of the select person."),
				                  new Label("4. Delete the selected person"),
		                          new Label("5. Check if this two person are connected."),
		                          new Label("6. Define the relation between two people."), 
		                          new Label("7. Find out the name of a persons children or the name of the parents."),
		                          new Label("0. Exit"),
		                          new Label("Enter an Option:")
		                          , new TextField()); 
		                         
		                        
		                          
		                          
				      
		//input = sc.nextInt();
		TextField tfMi = new TextField();
		tfMi.setPrefColumnCount(4);
		pane.getChildren().add(tfMi);
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("ShowFlowPane"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}