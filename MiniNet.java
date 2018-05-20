


import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hsqldb.Server;

import java.sql.Statement;
//import org.hsqldb.Server;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MiniNet extends Application{
	
	//Editted by Chit Hang Kwok
	//This program is to open all the gui file.

		// TODO Auto-generated constructor stub
	  public void start(Stage primaryStage) throws Exception{
			try {
		    primaryStage.setTitle("DisplayFile");
			Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
			Scene scene = new Scene(root);
		    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
	
	  

	public static void main(String[] args) throws Exception {
		Server hsqlServer = null;
		Connection connection = null;
		ResultSet rs = null;
		hsqlServer = new Server();
		hsqlServer.setLogWriter(null);
		hsqlServer.setSilent(true);
		hsqlServer.setDatabaseName(0, "TestDB");
		hsqlServer.setDatabasePath(0, "file:MYDB");
		hsqlServer.start();
		// making a connection
		try {
		Class.forName("org.hsqldb.jdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
		
		} catch (SQLException e2) {
		e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
		e2.printStackTrace();
		}
		// end of stub code for in/out stub
		
		
		
		
			WriteFile();
			
			launch(args);

			
			class TooYoungException extends Exception{}
			class NoChildException extends Exception{}
			class NotToBeClassmateException extends Exception{}
			class NoColleagueException extends Exception{}
			class NoCoupleException extends Exception{}
	
	
	

		int input;
	
		Scanner sc = new Scanner (System.in);
	do {
		System.out.println("Welcome to the MiniNet program. Please add a person first (min 2 persons) before you can use another functions. ");
		System.out.println(" ");
		System.out.println("MiniNet Menu");
		System.out.println("=================================");
		System.out.println("1. List everyone");
		System.out.println("2. Add a person");
		System.out.println("3. Select a person");
		System.out.println("4. Connect person");
		System.out.println("5. Update a person");
		System.out.println("6. Identify");
		System.out.println("7. Exit");
		System.out.println("                                ");
		System.out.println("Enter an Option:                ");
		
		input = sc.nextInt();
		System.out.println("  Your options are:  " + input);
		
		
		
		if (input == 1) {
			display(Person.profile);
		}
		
		else if (input == 2) {
			//Person p = new Person(name, status, gender, age, state);
			//p.addperson();
		}
		
		else if (input == 3) {
			display(Person.profile);
			
			Scanner sc1 = new Scanner (System.in);
			int input1;
			
			System.out.println("Select person: ");
			input1 = sc1.nextInt();
			
			if (Person.profile.get(input1 - 1) instanceof Adult) {
				Adult a = (Adult) Person.profile.get(input1 - 1);
				System.out.println("Friends List: " + a.friendslist);
				System.out.println("Parents List: " + a.parentslist);
				System.out.println("Children List: " + a.childrenlist);
				System.out.println("Couple List: " + a.couplelist);
				System.out.println("Classmates List: " + a.classmatelist);
				System.out.println("Colleagues List: " + a.colleaguelist);
			}
			
			if (Person.profile.get(input1 - 1) instanceof Child) {
				Child c = (Child) Person.profile.get(input1 - 1);
				System.out.println("Friends List: " + c.friendslist);
				System.out.println("Parents List: " + c.parentslist);
				System.out.println("Classmates List: " + c.classmatelist);
			}
			
			if (Person.profile.get(input1 - 1) instanceof YoungChild) {
				YoungChild y= (YoungChild) Person.profile.get(input1 - 1);
				System.out.println("Parents List: " + y.parentslist);					
			}
		}
	
		else if (input == 4) {
			Scanner sc1 = new Scanner (System.in);
			int input1;
			
			do {
				int input2;
				int input3;
				
				
				Scanner sc2 = new Scanner (System.in);
				Scanner sc3 = new Scanner (System.in);
				
				System.out.println("1. Connect friends");
				System.out.println("2. Connect parents");
				System.out.println("3. Connect children");
				System.out.println("4. Connect classmates");
				System.out.println("5. Connect colleagues");
				System.out.println("6. Connect couple");
				System.out.println("7. Exit");
				
				input1 = sc1.nextInt();
				
				
				if (input1 == 1) {
					display(Person.profile);
					System.out.println("Select first person");
					input2 = sc2.nextInt();
					System.out.println("Select second person");
					input3 = sc3.nextInt();
					
					if (Person.profile.get(input2 - 1) instanceof Adult) {
						Adult a = (Adult) Person.profile.get(input2 - 1);
						a.connectfriends(Person.profile.get(input3 - 1));
					}
					
					if (Person.profile.get(input2 - 1) instanceof Child) {
						Child c = (Child) Person.profile.get(input2 - 1);
						c.connectfriends(Person.profile.get(input3 - 1));
					}
					
					try {
						if (Person.profile.get(input2 - 1) instanceof YoungChild) {		// Young Child
							throw new TooYoungException();
						}
					}
					catch (TooYoungException e){
						System.out.println("Cannot make friends with a young child");
					}
				}
				
				else if (input1 == 2) {
					display(Person.profile);
					System.out.println("Select first person");
					input2 = sc2.nextInt();
					System.out.println("Select second person");
					input3 = sc3.nextInt();
					
					if (Person.profile.get(input2 - 1) instanceof Adult) {
						Adult a = (Adult) Person.profile.get(input2 - 1);
						a.connectparents(Person.profile.get(input3 - 1));
					}
					if (Person.profile.get(input2 - 1) instanceof Child) {
						Child c = (Child) Person.profile.get(input2 - 1);
						c.connectparents(Person.profile.get(input3 - 1));
					}
					if (Person.profile.get(input2 - 1) instanceof YoungChild) {
						YoungChild y = (YoungChild) Person.profile.get(input2 - 1);
						y.connectparents(Person.profile.get(input3 - 1));
					}
					
				}
				
				else if (input1 == 3) {
					display(Person.profile);
					System.out.println("Select first person");
					input2 = sc2.nextInt();
					System.out.println("Select second person");
					input3 = sc3.nextInt();
					if (Person.profile.get(input2 - 1) instanceof Adult) {
						Adult a = (Adult) Person.profile.get(input2 - 1);
						a.connectchildren(Person.profile.get(input3 - 1));
					}
					try {
						if (Person.profile.get(input2 - 1) instanceof Child) {
							throw new NoChildException();
						}
						if (Person.profile.get(input2 - 1) instanceof YoungChild) {
							throw new NoChildException();
						}
					}
					catch (NoChildException e) {
						System.out.println("Child or young child cannot add children");
					}
					
					// Child and YoungChild
				}
				
				else if (input1 == 4) {
					display(Person.profile);
					System.out.println("Select first person");
					input2 = sc2.nextInt();
					System.out.println("Select second person");
					input3 = sc3.nextInt();	
					if (Person.profile.get(input2 - 1) instanceof Adult) {
						Adult a = (Adult) Person.profile.get(input2 - 1);
						a.connectclassmates(Person.profile.get(input3 - 1));
					}
					
					if (Person.profile.get(input2 - 1) instanceof Child) {
						Child c = (Child) Person.profile.get(input2 - 1);
						c.connectclassmates(Person.profile.get(input3 - 1));
					}
					
					try {
						if (Person.profile.get(input2 - 1) instanceof YoungChild) {
							throw new NotToBeClassmateException();
						}																	//Young Child
					}catch (NotToBeClassmateException e) {
						System.out.println("Cannot connect a young child in a classmate relation");
					}
				}
				
				else if (input1 == 5) {
					display(Person.profile);
					System.out.println("Select first person");
					input2 = sc2.nextInt();
					System.out.println("Select second person");
					input3 = sc3.nextInt();
					
					if (Person.profile.get(input2 - 1) instanceof Adult) {
						Adult a = (Adult) Person.profile.get(input2 - 1);
						a.connectcolleague(Person.profile.get(input3 - 1));
					}
					
					try {
						if (Person.profile.get(input2 - 1) instanceof Child) {
							throw new NoColleagueException();
						}
						if (Person.profile.get(input2 - 1) instanceof YoungChild) {
							throw new NoColleagueException();
						}
					}
					catch (NoColleagueException e) {
						System.out.println("Child or young child cannot add colleague");
					}
					
					//Child and Young Child
					
				}
				else if (input1 == 6) {
					display(Person.profile);
					System.out.println("Select first person");
					input2 = sc2.nextInt();
					System.out.println("Select second person");
					input3 = sc3.nextInt();
					
					if (Person.profile.get(input2 - 1) instanceof Adult) {
						Adult a = (Adult) Person.profile.get(input2 - 1);
						a.connectcouple(Person.profile.get(input3 - 1));
					}
					//Child and Young Child
					try {
						if (Person.profile.get(input2 - 1) instanceof Child) {
							throw new NoCoupleException();
						}
						if (Person.profile.get(input2 - 1) instanceof YoungChild) {
							throw new NoCoupleException();
						}
					}
					catch (NoCoupleException e) {
						System.out.println("Child or young child cannot add colleague");
					}
					
				}
				else if (input1 != 1 && input1 != 2 && input !=3 && input != 4 && input != 5 && input != 6) {
					System.out.println("Invalid option");
				}
			}while(input1 != 7);
			
		}
		else if (input == 5) {
			
		}
		
		else if (input == 6) {
			int input2;
			int input3;
			
			display(Person.profile);
			
			Scanner sc2 = new Scanner (System.in);
			Scanner sc3 = new Scanner (System.in);
			
			System.out.println("Select first person");
			input2 = sc2.nextInt();
			System.out.println("Select second person");
			input3 = sc3.nextInt();	
			
			if (Person.profile.get(input2 - 1) instanceof Adult) {
				Adult a = (Adult) Person.profile.get(input2 - 1);
				a.identify(Person.profile.get(input3 - 1));
			}
			if (Person.profile.get(input2 - 1) instanceof Child) {
				Child c = (Child) Person.profile.get(input2 - 1);
				c.identify(Person.profile.get(input3 - 1));
			}
			if (Person.profile.get(input2 - 1) instanceof YoungChild) {
				YoungChild y = (YoungChild) Person.profile.get(input2 - 1);
				y.identify(Person.profile.get(input3 - 1));
			}		
		}
		
		else if (input != 1 && input != 2 && input !=3 && input != 4 && input != 5 && input != 6 && input != 7) {
			System.out.println("Invalid option");
		} 
		
	} while(input != 7);

	
		

}

	public static void display(List list) {
	int i = 1;
	for (Iterator it = list.iterator(); it.hasNext(); ) {
		Person p = (Person)it.next();	
		System.out.println(i + "------------------"+ p.getName());
		i++;
	}
	}
	
	public static void WriteFile() {
		FileWriter writer = null;
		FileWriter writer1 = null;
		

		try {
			writer = new FileWriter("C:\\Users\\PC\\Desktop\\AllPersonFile\\peoples.txt");

			writer.write("Alex Smith, 'AlexSmith.jpg', 'student at RMIT', M, 35, WA, \n");
			writer.write("Ben Turner, 'BenTurner.jpg', 'manager at ZFX', M, 45, VIC, \n");
			writer.write("Hannah White, 'HannahWhite.jpg', 'student at PLC', M, 12, VIC, \n");
			writer.write("Zoe Foster, 'ZoeFoster.jpg', 'Founder of ZFX', M, 33, VIC, \n");
			writer.write("Mary Turner, 'MaryTurner.jpeg', 'looking for jobs', F, 2 VIC, \n");
			writer.write("John Smith, 'JohnSmith.jpeg, 'student at PLC', M, 12, VIC, \n");
			writer.write("Mary Hopkin, 'MaryHopkin.jpeg, 'House Worker', F, 38, TAS, \n");
			writer.write("Alex Turner, 'AlexTurner.jpeg, 'student at LaTrobe', M, 22, VIC, \n");
			writer.write("Klay Thomas, 'KlayThomas.jpeg, 'House Worker', F, 33, NSW, \n");
			

			writer.close();// flushes the stream.

			writer1 = new FileWriter("C:\\Users\\PC\\Desktop\\AllPersonFile\\relation.txt");

			writer1.write("Alex Smith, Ben Turner, friend, \n");
			writer1.write("Ben Turner, Mary Hopkin, couple, \n");
			writer1.write("Ben Turner, Mary Turner, parent, \n");
			writer1.write("Mary Hopkin, Mary Turner, parent, \n");
			writer1.write("Alex Turner, Mary Hopkin, parent, \n");
			writer1.write("Alex Turner, Ben Turner, parent, \n");
			writer1.write("Alex Smith, Klay Thomas, couple, \n");
			writer1.write("Alex Turner, John Smith, friend, \n");
			writer1.write("John Smith, Klay Thomas, parent, \n");
			writer1.write("Alex Smith, Zoe Foster, colleagues, \n");
			writer1.write("John Smith, Hannah White, classmate, \n");

			writer1.close();// flushes the stream.
			
		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
	}
}

	        

