import java.util.ArrayList;
import java.util.List;


public class Child extends Person {
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
											//add back
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
			return;
		}
		else {
			if (obj instanceof Adult) {
				Adult a = (Adult) obj;
				System.out.println("You have added");
				this.parentslist.add(a);
			}
			else {	
				return;
			}
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
		
	}
	
}
