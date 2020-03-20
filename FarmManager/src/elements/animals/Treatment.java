package elements.animals;

import java.sql.Date;
import java.util.Calendar;

import elements.AbstractElement;

public class Treatment extends AbstractElement {

	Date startDate;
	Date endDate;
	
	public Treatment(String name) {
		super(counter, name);
	}

	public boolean isFinished() {
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		return currentDate.compareTo(endDate)>0;
	}

}
