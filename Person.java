import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Person {
	public class NoSuchAgeException extends Exception{}
	
	static ArrayList<Person> profile = new ArrayList<Person>();
	private int age;
	private String name;
	private String file;
	private String gender;
	private String status;
	private String state;
	
	
	public Person() {
		super();
		this.age = age;
		this.name = name;
		this.file = file;
		this.gender = gender;
		this.status = status;
		this.state = state;
	}	
	
	
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
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
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
	

	
	public void addperson() {
		
		Scanner sc1 = new Scanner (System.in);
		
		System.out.println("Name: ");
		name = sc1.nextLine();
		System.out.println("Gender: ");
		gender = sc1.nextLine();
		System.out.println("Age: ");
		age = sc1.nextInt();
//		System.out.println("Field:");
//		file = sc1.nextLine();
//		System.out.println("Status: ");
//		status = sc1.nextLine();
//		System.out.println("State:");
//		state = sc1.nextLine();
		
		
		
		
		if (age >= 0 && age <=2) {
			YoungChild y = new YoungChild();
			System.out.println("You have added this person as YoungChild");
				
			y.setAge(age);
			y.setFile(file);
			y.setName(name);
			y.setGender(gender);
			y.setStatus(status);
			y.setState(state);
			
			profile.add(y);
				
		}
		
		else if (age <= 16 && age > 2) {
			Child c = new Child();
			System.out.println("You have added this person as Child");
				
			c.setAge(age);
			c.setFile(file);
			c.setName(name);
			c.setGender(gender);
			c.setStatus(status);
			c.setState(state);
			
			profile.add(c);
		}
		
		else if (age > 16) {
			Adult a = new Adult();
			System.out.println("You have added this person as Adult");
				
			a.setAge(age);
			a.setFile(file);
			a.setName(name);
			a.setGender(gender);
			a.setStatus(status);
			a.setState(state);
				
			profile.add(a);
		}
	}
	
	public String toString() {
		return (this.getName() + " " + this.getAge() + " " + this.getGender());
	}
	
}
