
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;

import javax.swing.JOptionPane;
public class TestIO {
	public static void main(String arg[]) {

		
		FileReader input = null;

		try {
			input = new FileReader("peoples.txt");

			int next = input.read();

			while (next != -1) {
				System.out.print((char) next);
				next = input.read();
			}
			input.close();

			
			JOptionPane.showMessageDialog(null, input);
			
		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
	}
}