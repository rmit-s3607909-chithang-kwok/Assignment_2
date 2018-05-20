
import java.util.ArrayList;
import java.util.List;


public class Child extends Person {
	//Editted by Wenpeng
		//This program is to add all the Child relationship. If they have no relation it will throws an exception.
	public Child(String Name, String Status, String Gender, int Age, String State) {
		super(Name, Status, Gender, Age, State);
		// TODO Auto-generated constructor stub
	}

	List<Child> friendslist = new ArrayList<Child>();
	List<Adult> parentslist = new ArrayList<Adult>();
	List<Person> classmatelist = new ArrayList<Person>();
	
	public class NoParentException extends Exception{}
	public class NotToBeFriendsException extends Exception{}
	public class TooYoungException extends Exception{}
	public class NotToBeClassmateException extends Exception{}
	
	
	public void connectfriends(Object obj) throws Exception{
		try {
			if (obj instanceof Adult) {
				throw new NotToBeFriendsException();
			}
			if (obj instanceof YoungChild) {
				throw new TooYoungException();
			}

			if (obj instanceof Child) {
				Child c = (Child) obj;
				if(this.getAge() - c.getAge() > 3 || c.getAge() - this.getAge() > 3) {
					throw new NotToBeFriendsException();
				}
				else {
					this.friendslist.add(c);
					System.out.println("You add friends");
					if (!(c.friendslist.contains(this))) {
						c.friendslist.add(this);			//add back
					}
				}
			}
			
		}catch (NotToBeFriendsException e) {
			System.out.println("Cannot make friends with an adult or child with an age gap larger than 3");
		}catch (TooYoungException e) {
			System.out.println("Cannot make friends with a young child");
		}
	}
	
	public void connectparents(Object obj) {	
		if (this.parentslist.size() == 2) {
			System.out.println("Fail to add parents");
		}
		else if (obj instanceof Adult) {
			Adult a = (Adult) obj;
			this.parentslist.add(a);
			System.out.println("You add parents");
			if (!(a.childrenlist.contains(this))) {
				a.childrenlist.add(this);
			}
		}
	}
	
	public void connectclassmates(Object obj) throws Exception{
		try {
			if (obj instanceof YoungChild) {
				throw new NotToBeClassmateException();
			}
			if (obj instanceof Child) {
				Child c = (Child) obj;
				this.classmatelist.add(c);
				System.out.println("You add classmates");
				if (!(c.classmatelist.contains(this))) {
					c.classmatelist.add(this);
				}
			}
			if (obj instanceof Adult) {
				Adult a = (Adult) obj;
				this.classmatelist.add(a);
				System.out.println("You add classmates");
				if (!(a.classmatelist.contains(this))) {
					a.classmatelist.add(this);
				}
			}
		}catch (NotToBeClassmateException e) {
			System.out.println("Cannot connect a young child in a classmate relation");
		}
	}
	
	public void identify(Object obj) {
		try {
			if (this.parentslist.size() < 2) {   //No parents or only one parent
				throw new NoParentException();
			}
			if (!(this.parentslist.get(0).couplelist.contains(this.parentslist.get(1)))) { // Parents are not couple
				throw new NoParentException();
			}
			if (this.parentslist.contains(obj)) {
				Adult a = (Adult) obj;
				System.out.println(a.getName() + " " + this.getName() + " parents");
			}
			else {
				System.out.println("They are not family");
			}
		}catch(NoParentException e){
			System.out.println("No parents");
		}
		
		if (this.friendslist.contains(obj)) {
			Child c = (Child) obj;
			System.out.println(c.getName() + " " + this.getName() + " friends");
		}
		else {
			System.out.println("They are not friends");
		}
		
		if (this.classmatelist.contains(obj)) {
			Person p = (Person) obj;
			System.out.println(p.getName() + " " + this.getName() + " classmates");
		}
		else {
			System.out.println("They are not classmates");
		}
	}	
}
