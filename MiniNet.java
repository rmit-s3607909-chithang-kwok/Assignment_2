import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;


public class MiniNet {
	public static void main(String[] args) throws Exception {
		PrintWriter writer = null;
		PrintWriter twriter = null;
		
		
		
		
		int input = 0;
		
		Scanner sc = new Scanner (System.in);
		//writer = new PrintWriter("relations.txt");
		//twriter = new PrintWriter("people.txt");
		
		try {
			writer = new PrintWriter("relations.txt");
			
			
			writer.write("Alex Smith, Ben Turner, friends");
			writer.write("Ben Turner, Zoe Foster, couple");
			writer.write("Ben Turner, Mark Turner, parent");
			writer.write("Mark Turner, Zoe Foster, parent");
			
			writer.close();
			
			twriter = new PrintWriter("people.txt");
			
			writer.write("Alex Smith, “”, “student at RMIT”, M, 21, WA");
			writer.write("Ben Turner, “BenPhoto.jpg”, “manager at Coles”, M, 35, VIC");
			writer.write("Hannah White, “Hannah.png”, “student at PLC”, F, 14, VIC");
			writer.write("Zoe Foster, “”, “Founder of ZFX”, F, 28, VIC");
			writer.write("Mark Turner, “Mark.jpeg”, “”, M, 2, VIC");
			
			writer.close();
			
			
		}catch(IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
		
		
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
			System.out.println("0. Exit");
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
				System.out.println("Please select one of the persons from the list.");
				select(Person.profile);
				
				
				int selection;
				Scanner sc2 = new Scanner(System.in);
				selection = sc2.nextInt();
				
				
				Person.profile.remove(selection- 1);
				
				Person.addperson();
					
					}
			else if (input == 5) {
				System.out.println("Please select one of the persons from the list.");
				select(Person.profile);
				
				int selection;
				Scanner sc2 = new Scanner(System.in);
				selection = sc2.nextInt();
				
				
				
				Person.profile.remove(selection - 1);
				
					
				}
			
			else if (input == 6) {
				
				System.out.println("Please select two of the persons from the list to compared.");
				select(Person.profile);
				int selection;
				int selection2;
				Scanner sc2 = new Scanner(System.in);
				selection = sc2.nextInt();
				System.out.println("The first one is " + selection);
				Scanner sc3 = new Scanner(System.in);
				selection2 = sc3.nextInt();
				System.out.println("The second one is " + selection2);
				
				
				
			if((Person.profile.get(selection-1) instanceof Child) && (Person.profile.get(selection2-1) instanceof Child)){
					System.out.println("They are both Friends.");
					
			
			}else if((Person.profile.get(selection-1) instanceof Adult) && (Person.profile.get(selection2-1) instanceof Adult)){
						
							System.out.println("They are both friends.");
								
			
			}else if((Person.profile.get(selection-1) instanceof YoungChild) && (Person.profile.get(selection2-1) instanceof YoungChild)){
					
					
					System.out.println("You cannot add friends here because Baby supposed to have no friends.");
					
			}else if((Person.profile.get(selection-1) instanceof Classmate) && (Person.profile.get(selection2-1) instanceof Classmate)){
				
				
				System.out.println("They are both classmate");
				
			}else if((Person.profile.get(selection-1) instanceof Collegues) && (Person.profile.get(selection2-1) instanceof Collegues)){
				
				
				System.out.println("They are bot Collegues who are working together..");
				
				
			}else if((Person.profile.get(selection-1) instanceof YoungChild) && (Person.profile.get(selection2-1) instanceof Adult)){
				   
				System.out.println("You cannot add friends here because YoungChild cannot make friends with Adult.");
				   
			
				}else {
						System.out.println("They are both no relationship.");
					}
				
				
				
				
					
	}else if (input  == 7) {
				
				System.out.println("Please select one of the persons from the list to determine there relationships.");
				select(Person.family);
				
				int selection;
				int selection2;
				Scanner sc2 = new Scanner(System.in);
				selection = sc2.nextInt();
				System.out.println("The first one is " + selection);
				Scanner sc3 = new Scanner(System.in);
				selection2 = sc3.nextInt();
				System.out.println("The second one is " + selection2);
				
				
				
					if((Person.family.get(selection-1) instanceof Child) && (Person.family.get(selection2-1) instanceof Adult)){
							
						System.out.println("They are children and parent relationship.");
						
						}
			
					else if((Person.family.get(selection-1) instanceof Adult) && (Person.family.get(selection2-1) instanceof Child)){
						
						System.out.println("They are parent and children relationship.");
						
						}
			
					else if((Person.family.get(selection-1) instanceof YoungChild) && (Person.family.get(selection2-1) instanceof Adult)) {
						
						System.out.println("They are children and parent relationship.");
						
						}
					else if((Person.family.get(selection-1) instanceof Adult) && (Person.family.get(selection2-1) instanceof YoungChild)) {
						
						System.out.println("They are parent and children relationship.");
						
					}
						
						else if((Person.family.get(selection-1) instanceof Child) && (Person.family.get(selection2-1) instanceof Adult)) {
							
							System.out.println("They are children and parent relationship.");
							
							}
						else if((Person.family.get(selection-1) instanceof Adult) && (Person.family.get(selection2-1) instanceof Child)) {
							
							System.out.println("They are parent and children relationship.");
							
						
					}
					else if ((Person.family.get(selection-1) instanceof Adult) && (Person.family.get(selection2-1) instanceof Adult)) {
						
						
						System.out.println("They are either couples or children/parent relationship.");
						
						
					}
						else if((Person.family.get(selection-1) instanceof Child) && (Person.family.get(selection2-1) instanceof Child)) {
							
							System.out.println("They are either brother or sister relationship");
							
						}
							else if((Person.family.get(selection-1) instanceof YoungChild) && (Person.family.get(selection2-1) instanceof YoungChild)) {
								
								System.out.println("They are both Babies.");
						
					}
				

			}else if (input == 0) {
				System.out.println("Program Exit");
			}
			
			
			
			else if (input != 1 && input != 2 && input !=3 && input != 4 && input != 5 && input != 6 && input != 7 && input != 0) {
				System.out.println("Invalid option");
			} 
			
		} while(input != 0);
	


	}
	
	
	
public static void display(List list) {
	
	for (Iterator it = list.iterator(); it.hasNext();) {
		Person p = (Person)it.next();	
		System.out.println(p);
		
		
		
		}
}
public static void select(List list) {
	for (int i = 0; i < list.size(); i++) {
		System.out.println(i + 1 +"-------------" + list.get(i));
		}
	}
}
