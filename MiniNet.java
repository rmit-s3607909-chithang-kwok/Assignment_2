import java.util.Scanner;

public class Mininet {
	public static void mian (String[] args) {
		int input = 0;
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
				
				
				
			}
			
			else if (input == 2) {
			
			}
			
			else if (input == 3) {
			
			}
		
			else if (input == 4) {
		
					
					}
			else if (input == 5) {
				
				}
			
			else if (input == 6) {
				
		
				
					
			}else if (input  == 7) {
				

				

			}else if (input == 8) {
				System.out.println("Program Exit");
			}
			
			
			
			else if (input != 1 && input != 2 && input !=3 && input != 4 && input != 5 && input != 6 && input != 7 && input != 8) {
				System.out.println("Invalid option");
			} 
			
		} while(input != 0);
	


	}

}
