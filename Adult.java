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
				this.friendslist.add(a); //添加朋友
										 //add back 
			} 
			if (obj instanceof Child) {
				throw new NotToBeFriendsException(); //判断年龄
			}
			if (obj instanceof YoungChild) {
				throw new TooYoungException(); //判断年龄
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
			if () {
				throw new NoAvailableException();
			}
			else {
				Adult a = (Adult) obj;
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
		
		this.parentslist.add(e);
		
	}
	
	public void connectchildren(Object obj) {
		
		this.childrenlist.add(e);
		
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
		
	}
}
