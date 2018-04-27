import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;


public class MiniNet extends Application implements EventHandler<ActionEvent> {
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	Button b6;
	Button b7;
	Button b8;
	
	public static void main(String[] args) throws Exception{
		
		launch(args);
		
		int input = 0;
		
		Scanner sc = new Scanner (System.in);
		
		
		//Author: KWOK
		//The purpose of this program is to show the input results to determine the relationship between those people. 
		//If they are friends they will show them as a friend. If they are family they will show them as a family. 
		//You can update , add, delete the user input when you select the person choice after you have put the user in the database.
		
		do {
			System.out.println("Welcome to the MiniNet program. Please add a person first (min 2 persons) before you can use another functions. ");
			System.out.println(" ");
			System.out.println("MiniNet Menu");
			System.out.println("=================================");
			System.out.println("1. List everyone");
			System.out.println("2. Add a person");
			System.out.println("3. Add a family");
			System.out.println("4. Update a person");
			System.out.println("5. Delete select person");
			System.out.println("6. List two people if they are friends?");
			System.out.println("7. List Two people if they are family?");
			System.out.println("8. Exit");
			System.out.println("                                ");
			System.out.println("Enter an Option:                ");
			
			input = sc.nextInt();
			System.out.println("  Your options are:  " + input);
			
			
			
			if (input == 1) {
				display(Person.profile);
				
				
			}
			
			else if (input == 2) {
				Person.addperson();
			}
			
			else if (input == 3) {
				Person.addfamily();
			}
		
			else if (input == 4) {
				Person.UpdatePerson();
					
					}
			else if (input == 5) {
				
				Person.RemovePerson();	
				}
			
			else if (input == 6) {
				
				Person.CompareFriend();
				
				
					
			}else if (input  == 7) {
				
				Person.CompareFamily();
				

			}else if (input == 8) {
				System.out.println("Program Exit");
			}
			
			
			
			else if (input != 1 && input != 2 && input !=3 && input != 4 && input != 5 && input != 6 && input != 7 && input != 8) {
				System.out.println("Invalid option");
			} 
			
		} while(input != 0);
	


	}
	
	
	
	public static void display(List list) {
		int i = 1;
		for (Iterator it = list.iterator(); it.hasNext(); ) {
		
			Person p = (Person)it.next();	
			System.out.println(i + "------------------"+ p);
			i++;
		}
	}



	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	
		primaryStage.setTitle("Menu");
		
		b1 = new Button();
		b1.setText("1. List everyone");
		
		b2 = new Button();
		b2.setText("2. Add a person");
		
		b3 = new Button();
		b3.setText("3. Add a family");
		
		b4 = new Button();
		b4.setText("4. Update a person");
		
		b5 = new Button();
		b5.setText("5. Delete select person");
		
		b6 = new Button();
		b6.setText("6. List two people if they are friends?");
		
		b7 = new Button();
		b7.setText("7. List Two people if they are family?");
		
		b8 = new Button();
		b8.setText("8. Exit");
		
		GridPane layout = new GridPane();
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10,10,10));
		layout.setVgap(8);
		layout.setHgap(8);
		
		layout.add(b1,0,0);
		layout.add(b2,0,1);
		layout.add(b3,0,2);
		layout.add(b4,0,3);
		layout.add(b5,0,4);
		layout.add(b6,0,5);
		layout.add(b7,0,6);
		layout.add(b8,0,7);
		
		b1.setOnAction(e -> {
			DisplayPersonWindow.display("List of Person");
		});
		b2.setOnAction(e ->{
			AddPersonWindow.addperson();
		});
		b8.setOnAction(this);
		Scene scene = new Scene (layout, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
			
	}
	
	@Override
	public void handle(ActionEvent e) {
		if(e.getSource() == b1) {
			
		}
		
		if(e.getSource() == b2) {
			
		}
		
		if(e.getSource() == b8) {
			System.exit(0);
		}
	}
}