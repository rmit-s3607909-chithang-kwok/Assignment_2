package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

public abstract class Person{
	
	//Author: KWOK
	//We use person as the main program to identify the user input whether they are friends, relative(son, daughter) and display it to the screen
	static List profile = new ArrayList();
	static List family = new ArrayList();
	
	private int age;
	private String name;
	private String filed;
	private String gender;
	private String status;
	private String state;
	
	static class NoSuchAgeException extends Exception{}
	static class NotToBeClassmateException extends Exception{}
	static class NotToBeColleguesException extends Exception{}
	static class TooYoungException extends Exception{}
	static class NotToBeFriendException extends Exception{}
	static class NoParentException extends Exception{}
	static class NoAvailableException extends Exception{}
	static class NotToBeCoupleException extends Exception{}
	static class AdultNotToBeFriendException extends Exception{};

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getFile() {
		return filed;
	}
	
	public void setFile(String filed) {
		this.filed = filed;
	}

	public static String selectgender() {
		int choice;
		String gender = null;
		Scanner s = new Scanner(System.in);
		do {
			choice = s.nextInt();
			if (choice == 1) {
				gender= "Male";
			}
			else if (choice == 2) {
				gender= "Female";
			}
			else System.out.println("Invalid choice");
		}while (choice != 1 && choice != 2);
		
		return gender;
	}
	
	public static String selectfamily() {
		int choice;
		String status = null;
		Scanner s = new Scanner(System.in);
		do {
			choice = s.nextInt();
			if (choice == 1) {
				status = "Son";
			}
			else if (choice == 2) {
				status= "daughter";
			}
			else if (choice == 3) {
				status = "brother";
			}
			else if (choice == 4) {
				status= "sister";
			}
			else if (choice == 5) {
				status= "father";
			}
			else if (choice == 6) {
				status= "mother";
			}
			else System.out.println("Invalid choice");
		}while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6);
		
		return status;
	}
	
	public static String selectjob() {
		int choice;
		String status = null;
		String fo = "Freelance";
		String sr = "Student at RMIT";
		String sp = "Student at PLC";
		String wk = "Working at KFC";
		String sk = "Student at kindergarden";
		String lj = "looking for jobs";
		String mc = "manager at Coles";
		String fz = "Founder of ZFX";
		String hw = "House Worker";
		
		
		
		
		
		Scanner s = new Scanner(System.in);
		do {
			choice = s.nextInt();
			
			if (choice == 1) {
				status= fo;
			}
			
			else if (choice == 2) {
				status = sr;
			}
			
			else if (choice == 3) {
				status = sp;
			}
			
		else if (choice == 4) {
				status = wk;
			}
			else if (choice == 5) {
				status = sk;
			}
			else if (choice == 6) {
				status = lj;
			}
			else if (choice == 7) {
				status = mc;
			}
			else if (choice == 8) {
				status = fz;
			}
			else if (choice == 9) {
				status= hw;
			}
			else System.out.println("Invalid choice");
		}while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7 && choice != 8 && choice != 9);
		
		return status;
	}
	
	
	public static String selectstate() {
		int choice;
		String state = null;
		Scanner s = new Scanner(System.in);
		do {
			choice = s.nextInt();
			if (choice == 1) {
				state = "NSW";
			}
			else if (choice == 2) {
				state= "VIC";
			}
			else if (choice == 3) {
				state = "QL";
			}
			else if (choice == 4) {
				state= "WA";
			}
			else if (choice == 5) {
				state= "SA";
			}
			else if (choice == 6) {
				state= "TAS";
			}
			else if (choice == 7) {
				state= "NT";
			}
			else System.out.println("Invalid choice");
		}while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7);
		
		return state;
	}
	
	
	public static String selectFile() {
	    Scanner s = new Scanner(System.in);
	    int choice = 0;
	    String filed = null;
	    do {
	    	choice = s.nextInt();
	    
	    if (choice == 1) {
	    	filed = "BenPhoto.jpg";
	    }else if (choice == 2) {
	    		filed = "Hannah.png";
	    }else if (choice == 3) {
	    	filed = "Mark.jpeg";
	    }else if (choice == 4) {
	    	filed = "-----------------";
	    }
	    else System.out.println("Invalid Choice");
	    	}while (choice != 1 && choice != 2 && choice != 3 && choice != 4);
	    
	    	return filed;
	    }
	     
	
	public static void addfamily() throws Exception {
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter File: " + "1. BenPhoto.jpg " + " 2.Hannah.png" + " 3.Mark.jpeg " + "4.         ");
		String filed = selectFile();
	
		System.out.println("Enter Relationship: " + " 1. Son" + "  "+"2. Daughter" + "  " + "3. Brother " + "  " + "4. Sister" + " 5. Father" + " 6. Mother" );
		String status = selectfamily();
		
		System.out.println("Enter Gender: " + " 1. Male" + "   " + "2. Female");
		String gender = selectgender();
		
		System.out.println("Enter age");
		int age = sc.nextInt();
	
		System.out.println("Enter State: 1. NSW" + " 2. VIC" + " 3. QL" + " 4. WA" + " 5. SA" + " 6. TAS" + " 7. NT");
		String state = selectstate();
		
	
		if (age > 0 && age <=2) {
			YoungChild b = new YoungChild();
			System.out.println("You have added this person as YoungChild");
				
			b.setAge(age);
			b.setFile(filed);
			b.setName(name);
			b.setGender(gender);
			b.setStatus(status);
			b.setState(state);
				
				
			family.add(b);
				
				

		}
		
		else if (age > 16) {
			Adult a = new Adult();
			System.out.println("You have added this person as Adult");
				
			a.setAge(age);
			a.setFile(filed);
			a.setName(name);
			a.setGender(gender);
			a.setStatus(status);
			a.setState(state);
				
				
			family.add(a);
				
				

		}
			
		else if (age <= 16 && age > 2) {
			Child t = new Child();
			System.out.println("You have added this person as Child");
				
			t.setAge(age);
			t.setFile(filed);
			t.setName(name);
			t.setGender(gender);
			t.setStatus(status);
			t.setState(state);
			
			family.add(t);
		}
			
	}
			
	public static void UpdatePerson() throws Exception {
		System.out.println("Please select one of the persons from the list.");
		select(Person.profile);
		
		
		int selection;
		Scanner sc2 = new Scanner(System.in);
		selection = sc2.nextInt();
		
		
		Person.profile.remove(selection- 1);
		
		Person.addperson();
		System.out.println("Persons have been sucessfully updated.");
	}
			
			
    public static void RemovePerson() {
	    System.out.println("Please select one of the persons from the list.");
		select(Person.profile);
		
		int selection;
		Scanner sc2 = new Scanner(System.in);
		selection = sc2.nextInt();
		
		
		
		Person.profile.remove(selection - 1);
		System.out.println("Persons have been deleted successfully.");
		
    }
	
	public static void addperson() throws Exception{
	
		Scanner sc1 = new Scanner(System.in);
		String fo = "Freelance";
		String sr = "Student at RMIT";
		String sp = "Student at PLC";
		String wk = "Working at KFC";
		String sk = "Student at kindergarden";
		String lj = "looking for jobs";
		String mc = "manager at ZFX";
		String fz = "Founder of ZFX";
		String hw = "House Worker";
		
	
		System.out.println("Enter name: ");
		String name = sc1.nextLine();
		
		System.out.println("Enter File: " + "1. BenPhoto.jpg " + " 2.Hannah.png" + " 3.Mark.jpeg " + "4.         ");
		String filed = selectFile();
		
		System.out.println("Enter job:  1. Freelance" + " 2. Student at RMIT " + " 3. Student at PLC " + "4. Working at KFC " +  "5. Student at kindergarden "  + " 6. Looking for jobs " +  " 7. manager at ZFX" + " 8. Founder of ZFX " + " 9. House worker");
		String status = selectjob();
			
		System.out.println("Enter gender: 1. Male" + "   " + " 2. Female");
		String gender = selectgender();
			
		System.out.println("Enter age");
		int age = sc1.nextInt();
			
		System.out.println("Enter State: 1. NSW" + " 2. VIC" + " 3. QL" + " 4. WA" + " 5. SA" + " 6. TAS" + " 7. NT");
		String state = selectstate();
		
		
		if (age > 0 && age <=2) {
			YoungChild b = new YoungChild();
			System.out.println("You have added this person as YoungChild");
					
			b.setAge(age);
			b.setFile(filed);
			b.setName(name);
			b.setGender(gender);
			b.setStatus(status);
			b.setState(state);
					
					
			profile.add(b);
					
					

		}
			
			else if (age > 16) {
				Adult a = new Adult();
				System.out.println("You have added this person as Adult");
					
				a.setAge(age);
				a.setFile(filed);
				a.setName(name);
				a.setGender(gender);
				a.setStatus(status);
				a.setState(state);
					
					
				profile.add(a);
					
					

			}
				
			else if (age <= 16 && age > 2) {
				Child t = new Child();
				System.out.println("You have added this person as Child");
					
				t.setAge(age);
				t.setFile(filed);
				t.setName(name);
				t.setGender(gender);
				t.setStatus(status);
				t.setState(state);
				
				profile.add(t);
			}
			
	}	
		
	public static void CompareFriend() throws Exception{
		
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
		
		
		
		if((((Person) profile.get(selection-1)).CompareAge(Person.profile.get(selection2-1))) == true){

			System.out.println(profile.get(selection - 1) + " and " + profile.get(selection2-1) +  " are friends now");
	
		}
	
	}
		
	
	public static void CompareFamily() throws Exception{
		try {
		System.out.println("Please select one of the persons from the list to determine there relationships.");
		select(Person.family);
		select(Person.profile);
		int selection;
		int selection2;
		Scanner sc2 = new Scanner(System.in);
		selection = sc2.nextInt();
		System.out.println("The first one is " + selection);
		Scanner sc3 = new Scanner(System.in);
		selection2 = sc3.nextInt();
		System.out.println("The second one is " + selection2);
		
		
		
			if((Person.family.get(selection-1) instanceof Child) && (Person.family.get(selection2-1) instanceof Adult)){
					
				throw new NoAvailableException();
				
			}
	
			else if((Person.family.get(selection-1) instanceof Adult) && (Person.family.get(selection2-1) instanceof Child)){
				
				throw new NotToBeCoupleException();
				
			}
	
			else if((Person.family.get(selection-1) instanceof YoungChild) && (Person.family.get(selection2-1) instanceof Adult)) {
				
				System.out.println(Person.family.get(selection-1) + "," + Person.family.get(selection2-1) + "," + "parent");
				
			}
			else if((Person.family.get(selection-1) instanceof Adult) && (Person.family.get(selection2-1) instanceof YoungChild)) {
				
				System.out.println("Alex Smith" + "," + "Mary Hopkin" + "," + "couple");
				
			}
				
				else if((Person.family.get(selection-1) instanceof Child) && (Person.family.get(selection2-1) instanceof Adult)) {
					
					throw new NoParentException();
					
			}
				else if((Person.family.get(selection-1) instanceof Adult) && (Person.family.get(selection2-1) instanceof Child)) {
					
					System.out.println(Person.family.get(selection-1) + "," + Person.family.get(selection2-1) + "," + "parent");	
				
			}
				else if ((Person.family.get(selection-1) instanceof Adult) && (Person.family.get(selection2-1) instanceof Adult)) {
				
				System.out.println(Person.family.get(selection-1) + "," + Person.family.get(selection2-1) + "," + "couple");
				
			}	else if((Person.family.get(selection-1) instanceof Child) && (Person.family.get(selection2-1) instanceof Child)) {
					
					System.out.println(Person.family.get(selection-1) + "," + Person.family.get(selection2-1) + "," + "brother/sister");
					
			}	else if((Person.family.get(selection-1) instanceof YoungChild) && (Person.family.get(selection2-1) instanceof YoungChild)) {
						
					System.out.println(Person.family.get(selection-1) + "," + Person.family.get(selection2-1) + "," + "brother/sister");
				
			}	else {
					System.out.println(Person.family.get(selection-1) + "," + Person.family.get(selection2-1) + "," + "no relationship");
				}
		}catch(NoParentException eq) {
			System.err.println("Please add a parent to each child. Child cannot be no two parent.");
			System.exit(0);
		}catch(NoAvailableException eh) {
			System.err.println("Adult can only have one couple not connected to another couples.");
			System.exit(0);
		}catch(NotToBeCoupleException ek) {
			System.err.println("Adult can only connect with Adult if they are couple.");
			System.exit(0);
		}
	}
	
	public boolean CompareAge (Object obj) throws Exception {
		try {
			if (this == null) {
				return false;
			}
			if (this instanceof YoungChild || obj instanceof YoungChild) {
				throw new TooYoungException();
			}
			if ((this instanceof Child && obj instanceof Adult)||(obj instanceof Child && this instanceof Adult)) {
				
				throw new AdultNotToBeFriendException();
			}
			Person other = (Person) obj;
			if (this instanceof Child && obj instanceof Child) {
				if(this.getAge() - other.getAge() > 3 || other.getAge() - this.getAge() > 3) {
					throw new NotToBeFriendException();
				}
				else return true;
			}
			else return true;
			
		}catch(TooYoungException eg) {
			System.err.println("Please dont make friend with young children");
			return false;
		}catch(AdultNotToBeFriendException ab) {
			System.err.println("Please dont make Adult and Children a friends who cannot be greater than 3 years old.");				
			return false;		
		}
			catch(NotToBeFriendException ac) {
			System.err.println("Please dont make both Children a friends as their age cannot be greater than 3 years old.");
			return false;
		}
	}
	
	
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return this.name.equals(p.name);
	}
	
	public String toString() {
		return  name;
	}		
	public static void select(List list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 +"-------------" + list.get(i));
		}
	}
	
	public void Creatrelationship(Object obj) {
		Map couple = new HashMap();
		if (couple != null) {
			return;
		}else if(this.getAge() > 16) {
			Person other = (Person) obj;
			couple.put(this.getName(), other.getName());
			
		}
		Map parents = new HashMap();
		Map children = new HashMap();
		Map colleague = new HashMap();
		Map friends = new HashMap();
		
		List<Map> list = new ArrayList<Map>();
		list.add(couple);
		list.add(parents);
		list.add(children);
		list.add(colleague);
		list.add(friends);
		
		
	}
}
	