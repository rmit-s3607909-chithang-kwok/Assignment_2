package application;




import java.awt.Desktop;
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

public class MainContoller implements Initializable{

	private Button bt1;
	
	private Button bt2;
	
	private ListView listview;
	
    private TextArea textarea;
    
	private Desktop desktop = Desktop.getDesktop();
	
	public void Button1Action(ActionEvent event) {
		
		
		FileChooser fc = new FileChooser();
		//fc.setInitialDirectory(new File("FileChooser.fxml"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("txt files", "*.txt"));
		File selectFile = fc.showOpenDialog(null);
		
		if (selectFile != null) {
			openFile(selectFile);
			//listview.getItems().add(selectFile.getName());
			//textarea.setText(readFile(selectFile));
		}else {
			System.out.println("file is not valid");
		}
	}
	
	public void Button2Action(ActionEvent event){
		
		
		FileChooser fc = new FileChooser();
		//fc.setInitialDirectory(new File("FileChooser.fxml"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("txt files", "*.txt"));
	List<File> selectFiles = fc.showOpenMultipleDialog(null);
		
		if (selectFiles != null) {
			//for (int i = 0; i < selectFiles.size();i++) {
				
			
				 for (File file : selectFiles) {
                     openFile(file);
			
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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                FileChooserSample.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
	
}