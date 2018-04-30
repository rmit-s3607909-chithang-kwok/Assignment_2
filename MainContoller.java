package application;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.ListView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainContoller{

	private Button bt1;
	private Button bt2;
	
	private ListView listview;

	
	
	public void Button1Action(ActionEvent event) {
		
		 final TextArea textArea = new TextArea();
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("/Users/gary/eclipse-workspace/MenuBar/src"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("txt files", "*.txt"));
		File selectFile = fc.showOpenDialog(null);
		
		if (selectFile != null) {
			listview.getItems().add(selectFile.getAbsolutePath());
			textArea.setText(readFile(selectFile));
		}else {
			System.out.println("file is not valid");
		}
	}
	
	public void Button2Action(ActionEvent event) {
		
		final TextArea textArea = new TextArea();
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("/Users/gary/eclipse-workspace/MenuBar/src"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("txt files", "*.txt"));
		List<File> selectFiles = fc.showOpenMultipleDialog(null);
		
		if (selectFiles != null) {
			for (int i = 0; i < selectFiles.size();i++) {
			listview.getItems().add(selectFiles.get(i).getAbsolutePath());
			
			}
		}else {
			System.out.println("file is not valid");
		}
	}
	
	private String readFile(File selectFile){
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
         
        try {
 
            bufferedReader = new BufferedReader(new FileReader(selectFile));
             
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainContoller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainContoller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(MainContoller.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
         
        return stringBuffer.toString();
    }
}