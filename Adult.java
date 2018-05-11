import java.util.ArrayList;
import java.util.List;

public class Adult extends Person {
	List<Adult> friendslist = new ArrayList<Adult>();
	List<Adult> couplelist = new ArrayList<Adult>();
	List<Adult> colleaguelist = new ArrayList<Adult>();
	List<Adult> parentslist = new ArrayList<Adult>();
	List<Person> childrenlist = new ArrayList<Person>();
	List<Person> classmatelist = new ArrayList<Person>();
	
	public class TooYoungException extends Exception{}
	public class NotToBeFriendsException extends Exception{}
	public class NoAvailableException extends Exception{}
	public class NotToBeCoupledException extends Exception{}
	public class NotToBeColleagueException extends Exception{}
	public class NotToBeClassmateException extends Exception{}


	
	public void connectfriends(Object obj) throws Exception{
		try {
			if (obj instanceof Adult) {
				Adult a = (Adult) obj;
				this.friendslist.add(a); //add friends
										 //add back 
			} 
			if (obj instanceof Child) {
				throw new NotToBeFriendsException(); 
			}
			if (obj instanceof YoungChild) {
				throw new TooYoungException(); //age
				
			}
		}catch (NotToBeFriendsException e){
			System.out.println("You cannnot add a child");
		}catch (TooYoungException e) {
			System.out.println("You cannot add a young child");
		}
	
	}
	
	public void connectcouple(Object obj) throws Exception{
		try {
			if (!(obj instanceof Adult)) {
				throw new NotToBeCoupledException();
			}
			
			Adult a = (Adult) obj;
			if (this.couplelist.size() == 1 || a.couplelist.size() == 1) {
				throw new NoAvailableException();
			}
			else {
				this.couplelist.add(a);
										//add back
			}
		}catch(NoAvailableException e) {
			System.out.println("Has been coupled with others");
		}catch(NotToBeCoupledException e) {
			System.out.println("Not an Adult");
		}
			
	}
	
	public void connectcolleague(Object obj) throws Exception{
		try {
			if (!(obj instanceof Adult)) {
				throw new NotToBeColleagueException();
			}
			else {
				Adult a = (Adult) obj;
				this.colleaguelist.add(a);
											//add back
			}
		}catch (NotToBeColleagueException e) {
			System.out.println("Cannot connect a child or young child in a colleague relation");
		}	
	}
	
	public void connectparents(Object obj) {
		if (this.parentslist.size() == 2) {
			System.out.println("Fail to add parents");
		}
		else if (obj instanceof Adult) {
			Adult a = (Adult) obj;
			System.out.println("You have added");
			this.parentslist.add(a);
		}
	}
	
	public void connectchildren(Object obj) {
		if (!(obj instanceof Adult)) {
			Person p = (Person) obj;
			this.childrenlist.add(p);
									// add back
		}
		else {
			System.out.println(" You cannot add adult as your children");
		}
	}
	
	public void connectclassmates(Object obj) throws Exception{
		try {
			if (obj instanceof YoungChild) {
				throw new NotToBeClassmateException();
			}
			else {
				Person p = (Person) obj;
				this.classmatelist.add(p);
			}
		}catch (NotToBeClassmateException e) {
			System.out.println("Cannot connect a young child in a classmate relation");
		}
	}
	
	public void indentify(Object obj) {
		if (this.friendslist.contains(obj)) { // identify friends
			Child c = (Child) obj;
			System.out.println(c.getName() + " " + this.getName() + " friends");
		}
		else {
			System.out.println("They are not friends");
		}
		
		if (this.classmatelist.contains(obj)) { // identify classmates
			Person p = (Person) obj;
			System.out.println(p.getName() + " " + this.getName() + " classmates");
		}
		else {
			System.out.println("They are not classmates");
		}
		
		if (this.parentslist.contains(obj)) {	// identify parents
			Adult a = (Adult) obj;
			System.out.println(a.getName() + " " + this.getName() + " parents");
		}else 
		
		if (this.couplelist.contains(obj)) {	//identify couple
			Adult a = (Adult) obj;
			System.out.println(a.getName() + " " + this.getName() + " couple");
		} 
		else {
			System.out.println("They are not couple");
		}
		
		if (this.colleaguelist.contains(obj)) {  	//identify colleagues
			Adult a = (Adult) obj;
			System.out.println(a.getName() + " " + this.getName() + " colleagues");
		}
		else {
			System.out.println("They are not colleagues");
		}
		
		if (this.childrenlist.contains(obj)) { 		// identify children
			Person p = (Person) obj;
			System.out.println(p.getName() + " " + this.getName() + " child");
		}
		else {
			System.out.println("They are not family");
		}
	}
}
