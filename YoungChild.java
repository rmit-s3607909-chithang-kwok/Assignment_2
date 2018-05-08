import java.util.ArrayList;
import java.util.List;

public class YoungChild extends Person {
	List<Adult> parentslist = new ArrayList<Adult>();
	public class NoParentException extends Exception{}

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
	
	public boolean identify(Object obj) throws Exception{
		try {
			if (this.parentslist.size() < 2) {   //No parents or only one parent
				throw new NoParentException();
			}
			if (!(this.parentslist.get(0).couplelist.contains(this.parentslist.get(1)))) { // Parents are not couple
				throw new NoParentException();
			}
			if (this.parentslist.contains(obj)) {
				Adult a = (Adult) obj;
				System.out.println(this.getName() + " " + a.getName() + " " + "family");
				return true;
			}
			else {
				System.out.println("They are not family");
				return false;
			}
		}catch(NoParentException e){
			System.out.println("No parents");
			return false;
		}
		
	}

	
}
