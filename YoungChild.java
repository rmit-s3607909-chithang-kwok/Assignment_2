import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class YoungChild extends Person {
	
	//We are going to identify the YoungChild Specification
	//if they have one parent or no parent it will
	//come up with an exception.

	List<Adult> parentslist = new ArrayList<Adult>();
	public class NoParentException extends Exception{}
	
	//public YoungChild(String name, Image filed, String status, String gender, int age, String state) {
	//	super(name, filed, status, gender, age, state);
		// TODO Auto-generated constructor stub
	//}

	public void connectparents(Object obj) {
		if (this.parentslist.size() == 2) {
			System.out.println("Fail to add parents");
		}
		else if (obj instanceof Adult) {
			Adult a = (Adult) obj;
			System.out.println("You have added");
			this.parentslist.add(a);
			if (!(a.childrenlist.contains(this))) {
				a.childrenlist.add(this);
			}
		}
	}
	
	public void identify(Object obj) throws Exception{
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
		
	}
	
	

	
}
