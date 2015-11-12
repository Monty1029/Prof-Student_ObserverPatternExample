import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {
	private String name;
	private Date midterm;

	public Student(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date) {
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}

	public void party(Date date) {
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if ((arg0 instanceof Prof) && ((int) arg1 == 1)) {
			Prof p = (Prof) arg0;
			this.study(p.getMidterm());
	    } else {
	    	Prof p = (Prof) arg0;
			this.party(p.getMidterm());
		}

	}
}