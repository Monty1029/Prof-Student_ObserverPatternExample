import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class TeachingAssistant implements Observer {
	private String name;
	private Date midterm;

	public TeachingAssistant(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void proctor(Date date){
		this.midterm = date;
		System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
	}
	
	public void postpone(Date date){
		this.midterm = date;
		System.out.println(name + " : Now the midterm is on " + this.midterm);
	}

	@Override
	public void update(Observable arg0, Object arg) {
		if ((arg0 instanceof Prof) && ((int) arg == 1)) {
			Prof p = (Prof) arg0;
			this.proctor(p.getMidterm());
	    } else {
	    	Prof p = (Prof) arg0;
			this.postpone(p.getMidterm());
		}
		
	}
}