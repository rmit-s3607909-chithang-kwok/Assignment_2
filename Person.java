import java.util.ArrayList;
import java.util.List;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Person {
	public class NoSuchAgeException extends Exception{}
	
	// Person class declaration //
	List <Person>profile = new ArrayList<Person>();
	
	
	private int age;
	private String name;
	private Image filed;
	private String gender;
	private String status;
	private String state;

	
	public Person() {
		this.name="";
		this.status="";
		this.gender="";
		this.age=0;
		this.state="";
	}
	
	public Person(String name, String status, String gender, int age, String state) {
		this.name=name;
		this.status=status;
		this.gender=gender;
		this.age=age;
		this.state=state;
		//filed = new Image ("koala.jpg");
	}
	
	
	//public Person(String name, Image filed, String status, String gender, int age, String state) {
		//this.name=name;
		//this.filed=filed;
	//	this.status=status;
	//	this.gender=gender;
	//	this.age=age;
	//	this.state=state;
	//}
	
	
	
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
	public Image getFiled() {
		return filed;
	}
	public void setFiled(Image filed) {
		this.filed = filed;
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
	
	//AddPerson declaration//
	public void addperson() throws Exception{
		if (age >= 0 && age <=2) {
			YoungChild y = new YoungChild();
			System.out.println("You have added this person as YoungChild");
				
			y.setAge(age);
			y.setFiled(filed);
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
			c.setFiled(filed);
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
			a.setFiled(filed);
			a.setName(name);
			a.setGender(gender);
			a.setStatus(status);
			a.setState(state);
				
			profile.add(a);
		}
	}
	  public String toString()
	    {
	        return String.format(" " + getName() + " , " + getFiled() + " , " + getStatus() + " , " + getGender() + " , " + getAge() + " , " + getState() + " ");
	    }
	 
	  }
	

