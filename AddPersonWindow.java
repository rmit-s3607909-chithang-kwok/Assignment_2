import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddPersonWindow {
	private int age;
	private String name;
	private String filed;
	private String gender;
	private String status;
	private String state;
	
	public static void addperson() {
		
		Stage window = new Stage();
		window.setTitle("Add Person");
		window.setMinWidth(500);
		
		Button back = new Button("Back");
		back.setOnAction(e -> {
			window.close();
		});
		
		Button add = new Button("Add");
		add.setOnAction(e -> {
			window.close();
		});
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10,10,10,10));
		pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("Enter name: "),0,0);
		TextField t1 = new TextField();
		pane.add(t1,1,0);
		pane.add(new Label("Enter File: " + "1. BenPhoto.jpg " + " 2.Hannah.png" + " 3.Mark.jpeg " + "4.         "),0,1);
		TextField t2 = new TextField();
		pane.add(t2,1,1);
		pane.add(new Label("Enter job:  1. Freelance" + " 2. Student at RMIT " + " 3. Student at PLC " + "4. Working at KFC " +  "5. Student at kindergarden "  + " 6. Looking for jobs " +  " 7. manager at ZFX" + " 8. Founder of ZFX " + " 9. House worker"),0,2);
		TextField t3 = new TextField();
		pane.add(t3,1,2);
		pane.add(new Label("Enter gender: 1. Male" + "   " + " 2. Female"),0,3);
		TextField t4 = new TextField();
		pane.add(t4,1,3);	
		pane.add(new Label("Enter age"),0,4);
		TextField t5 = new TextField();
		pane.add(t5,1,4);	
		pane.add(new Label("Enter State: 1. NSW" + " 2. VIC" + " 3. QL" + " 4. WA" + " 5. SA" + " 6. TAS" + " 7. NT"),0,5);
		TextField t6 = new TextField();
		pane.add(t6,1,5);
		pane.add(back,0,6);
		pane.add(add,1,6);
		
		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.showAndWait();
		
	}
}
