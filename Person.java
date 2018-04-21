import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public abstract class Person {
	
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
	     
	
	public static void addfamily() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Enter name");
		String name = sc.nextLine();
	
		System.out.println("Enter age");
		int age = sc.nextInt();
	
		System.out.println("Enter Gender: " + " 1. Male" + "   " + "2. Female");
		String gender = selectgender();
	
		System.out.println("Enter Relationship: " + " 1. Son" + "  "+"2. Daughter" + "  " + "3. Brother " + "  " + "4. Sister" + " 5. Father" + " 6. Mother" );
		String status = selectfamily();
	
			
			if (age > 0 && age <=2) {
				YoungChild b = new YoungChild();
				System.out.println("You have added this person as YoungChild");
				
				b.setName(name);
				b.setAge(age);
				b.setGender(gender);
				b.setStatus(status);
				
				
				family.add(b);
				
				

			}
			
			else if (age > 16) {
				Adult a = new Adult();
				System.out.println("You have added this person as Adult");
				
				a.setName(name);
				a.setAge(age);
				a.setGender(gender);
				a.setStatus(status);
				
				
				family.add(a);
				
				

			}
			
			else if (age <= 16 && age > 2) {
				Child t = new Child();
				System.out.println("You have added this person as Child");
				
				t.setName(name);
				t.setAge(age);
				t.setGender(gender);
				t.setStatus(status);
				
				
				family.add(t);
				
				

			}
			
			
			
			
			
			
			

		
	}
	
	public static void addperson() {
		try {
		Scanner sc1 = new Scanner(System.in);
		String fo = "Freelance";
		String sr = "Student at RMIT";
		String sp = "Student at PLC";
		String wk = "Working at KFC";
		String sk = "Student at kindergarden";
		String lj = "looking for jobs";
		String mc = "manager at Coles";
		String fz = "Founder of ZFX";
		String hw = "House Worker";
		

		System.out.println("Enter name: ");
		String name = sc1.nextLine();
		
		System.out.println("Enter File: " + "1. BenPhoto.jpg " + " 2.Hannah.png" + " 3.Mark.jpeg " + "4.         ");
		String filed = selectFile();
		
		System.out.println("Enter job:  1. Freelance" + " 2. Student at RMIT " + " 3. Student at PLC " + "4. Working at KFC" +  "5. Student at kindergarden "  + " 6. Looking for jobs " +  " 7. manager at Coles" + " 8. Founder of ZFX " + " 9. House worker");
		String status = selectjob();
		
		System.out.println("Enter gender: 1. Male" + "   " + " 2. Female");
		String gender = selectgender();
		
		System.out.println("Enter age");
		int age = sc1.nextInt();
		
		System.out.println("Enter State: 1. NSW" + " 2. VIC" + " 3. QL" + " 4. WA" + " 5. SA" + " 6. TAS" + " 7. NT");
		String state = selectstate();
		
		
		
		if ( age >= 0 && age < 2) {
			
			
			Person p = new YoungChild();
			System.out.println("You have added this person as YoungChild");
			p.setAge(age);
			p.setFile(filed);
			p.setName(name);
			p.setGender(gender);
			p.setStatus(status);
			p.setState(state);
			
			
			profile.add(p);
			
		}	
		
		else if (age >=2 && age <= 16 ) {
			Person p = new Child();
			System.out.println("You have added this person as Child");
			p.setAge(age);
			p.setFile(filed);
			p.setName(name);
			p.setGender(gender);
			p.setStatus(status);
			p.setState(state);
			
			
			
			profile.add(p);
			
			
		}
		else if (age > 16 && age < 149) {
			Person p = new Adult();
			System.out.println("You have added this person as Adult");
			p.setAge(age);
			p.setFile(filed);
			p.setName(name);
			p.setGender(gender);
			p.setStatus(status);
			p.setState(state);
			
			profile.add(p);
			
		}else if (!(status.contains(sr) || status.contains(sp)|| status.contains(sk))) throw new NotToBeClassmateException()
		{
			
			Person p = new Adult();
			System.out.println("You have added this person as Classmate.");
			p.setAge(age);
			p.setFile(filed);
			p.setName(name);
			p.setGender(gender);
			p.setStatus(status);
			p.setState(state);
		
		
		
		profile.add(p);
		
	    } else if (!(status.contains(fo) || status.contains(wk) || status.contains(mc) || status.contains(fz))) throw new NotToBeColleguesException()
		{
		
		Person p = new Adult();
	    System.out.println("You have added this person as Collegues.");
	    p.setAge(age);
	    p.setFile(filed);
	    p.setName(name);
	    p.setGender(gender);
	    p.setStatus(status);
	    p.setState(state);



         profile.add(p);
		
		} else if (age < 0 && age > 150) throw new NoSuchAgeException();
				
		
	
	    }
		catch(NoSuchAgeException e) {
			
			System.err.println("Please dont add person age in negative number and greater than 150.");
			System.exit(0);
		}
		
		catch(NotToBeColleguesException e) {
			System.err.println("Dont connect a child with collegue erelation.");
			System.exit(0);
			
		}
	    catch(NotToBeClassmateException e) {
	    	    System.err.println("Dont connect a young child in classmate relation");
	    	    System.exit(0);
	    }
	}
	
	
		
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return this.name.equals(p.name) && this.gender.equals(p.gender) && this.age == p.age && this.status.equals(p.status);
	}
	
	public String toString() {
		return "[" + name + " " + filed + " " + status + " " + gender + " " + age + " " + state + " ]";
	}		
}
