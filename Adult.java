
import java.util.ArrayList;
import java.util.List;


public class Adult extends Person {
	//Editted by Chit Hang Kwok
	//This program is to add all the Adult relationship. If they have no relation it will throws an exception.
	public Adult(String Name, String Status, String Gender, int Age, String State) {
		super(Name, Status, Gender, Age, State);
		// TODO Auto-generated constructor stub
	}
//Define the categories of each relation when you compare two person in the relation list.
	List<Adult> friendslist = new ArrayList<Adult>();
	List<Adult> couplelist = new ArrayList<Adult>();
	List<Adult> colleaguelist = new ArrayList<Adult>();
	List<Adult> parentslist = new ArrayList<Adult>();
	List<Person> classmatelist = new ArrayList<Person>();
	List<Person> childrenlist = new ArrayList<Person>();
	
	public class TooYoungException extends Exception{}
	public class NotToBeFriendsException extends Exception{}
	public class NoAvailableException extends Exception{}
	public class NotToBeCoupledException extends Exception{}
	public class NotToBeColleagueException extends Exception{}
	public class NotToBeClassmateException extends Exception{}


	//This method is to identify friend define by Age of two person.If they are not the same group type them throws an Exception
	public void friend(Object obj) throws Exception{
		try {
			if (obj instanceof Adult) {
				Adult a = (Adult) obj;
				this.friendslist.add(a); 			
				System.out.println("You add friends");
				if (!(a.friendslist.contains(this))) {
					a.friendslist.add(this);		
				}					
			} 
			if (obj instanceof Child) {
				throw new NotToBeFriendsException(); //Children cannot be friend with Adult
			}
			if (obj instanceof YoungChild) {
				throw new TooYoungException(); //Young Children cannot talk therefore they cannot have friends.
				
			}
		}catch (NotToBeFriendsException e){
			System.err.println("Cannot make friends with a child ");
		}catch (TooYoungException e) {
			System.err.println("Cannot make friends with a young child");
		}
	
	}
	//This method is to identify two person relationship in couple. If one have got marry another cannot be couple again.
	public void couple(Object obj) throws Exception{
		try {
			if (!(obj instanceof Adult)) {
				throw new NotToBeCoupledException();//Child and YougChild cannot get married.
			}
			
			Adult a = (Adult) obj;
			if (this.couplelist.size() == 1 || a.couplelist.size() == 1) {
				throw new NoAvailableException();    //They have got married before so cannot get married again except divorce.
			}
			else {
				this.couplelist.add(a);
				System.out.println("You add couple");
				if (!(a.couplelist.contains(this))) {
					a.couplelist.add(this);				
				}						
			}
		}catch(NoAvailableException e) {
			System.err.println("Has been coupled with others");
		}catch(NotToBeCoupledException e) {
			System.err.println("Not an Adult");
		}
			
	}
	//This method is to define the colleague relationship between two people if they are working together and they are over 16.
	public void colleague(Object obj) throws Exception{
		try {
			if (!(obj instanceof Adult)) {
				throw new NotToBeColleagueException();//Child and youngchild cannot be colleague because they are too young.
			}
			else {
				Adult a = (Adult) obj;
				this.colleaguelist.add(a);
				System.out.println("You add colleagues");
				if (!(a.colleaguelist.contains(this))) {
					a.colleaguelist.add(this);						
				}
			}
		}catch (NotToBeColleagueException e) {
			System.err.println("Cannot connect a child or young child in a colleague relation");
		}	
	}
	
	//This method define the parent relationship if they have more than two parent it is not allowed.
	public void parents(Object obj) {
		if (this.parentslist.size() == 2) {
			System.out.println("Fail to add parents");
		}
		else if (obj instanceof Adult) {
			Adult a = (Adult) obj;
			System.out.println("You add parents");
			this.parentslist.add(a);
				if (!(a.childrenlist.contains(this))) {
					a.childrenlist.add(this);
				}
		}
	}
	//This method define the children relation only when they are child and YoungChild
	public void children(Object obj) {
		if (obj instanceof YoungChild) {
			YoungChild y = (YoungChild) obj;
			this.childrenlist.add(y);
			System.out.println("You add children");
			if (!(y.parentslist.contains(this))) {
				y.parentslist.add(this);					
			}
		}
		if (obj instanceof Child) {
			Child c = (Child) obj;
			this.childrenlist.add(c);
			System.out.println("You add children");
			if (!(c.parentslist.contains(this))) {
				c.parentslist.add(this);
			}
		}
		else {
			System.out.println(" You cannot add adult as your children");
		}
	}
	//This method define the classmate relationship if they are YoungChild they cannot be classmate.
	public void classmates(Object obj) throws Exception{
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
			System.err.println("Cannot connect a young child in a classmate relation");
		}
	}
	//This method is to put two person in parent, colleague, classmate, children, friend and couple relationship.
	public void identify(Object obj) {
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
		
		if (this.parentslist.contains(obj)) {
			Adult a = (Adult) obj;
			System.out.println(a.getName() + " " + this.getName() + " parents");
		}else 
		
		if (this.couplelist.contains(obj)) {
			Adult a = (Adult) obj;
			System.out.println(a.getName() + " " + this.getName() + " couple");
		} 
		else {
			System.out.println("They are not couple");
		}
		
		if (this.colleaguelist.contains(obj)) { 
			Adult a = (Adult) obj;
			System.out.println(a.getName() + " " + this.getName() + " colleagues");
		}
		else {
			System.out.println("They are not colleagues");
		}
		
		if (this.childrenlist.contains(obj)) { 
			Person p = (Person) obj;
			System.out.println(p.getName() + " " + this.getName() + " child");
		}
		else {
			System.out.println("They are not family");
		}
	}
}