package elements.animals;

import java.sql.Date;
import java.util.Calendar;

import elements.AbstractElement;

public class Treatment extends AbstractElement {

	private Date startDate;
	private Date endDate;
	private TreatmentType type;
	private Animal animal;
	
	public Treatment(String name) {
		super(counter, name);
	}
	
	public Treatment(String name, Date startDate, Date endDate, Animal animal) {
		super(counter, name);
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Treatment(String name, Date startDate, TreatmentType type, Animal animal) {
		super(counter, name);
		this.startDate = startDate;
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		c.add(Calendar.DAY_OF_YEAR, type.getDaysDuration());
		this.endDate = new Date(c.getTime().getTime());
		this.type=type;
	}

	public boolean isFinished() {
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		return currentDate.compareTo(endDate)>=0;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

	public Animal getAnimal() {
		return animal;
	}
}
