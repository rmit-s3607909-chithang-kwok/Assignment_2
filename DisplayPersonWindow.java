import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisplayPersonWindow {
	
	public static void display(String message) {
		
		Stage window = new Stage();
		window.setTitle("List of Person");
		window.setMinWidth(500);
		Label label = new Label();
		label.setText(message);
		Button back = new Button("Back");
		back.setOnAction(e -> {
			window.close();
		});
		
		VBox layout = new VBox(50);
		layout.getChildren().addAll(label, back);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
