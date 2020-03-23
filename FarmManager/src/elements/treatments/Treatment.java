package elements.treatments;

import java.sql.Date;
import java.util.Calendar;

import elements.animals.Animal;


public class Treatment {
	private static int counter = 0;
	
	private String name;
	private int id;
	private Date startDate;
	private Date endDate;
	private TreatmentType type;
	private Animal animal;
	
	
	public Treatment(String name, Date startDate, Date endDate, Animal animal) {
		this.name=name;
		this.id=counter++;
		this.startDate = startDate;
		this.endDate = endDate;
		this.animal = animal;
	}
	
	public Treatment(String name, Date startDate, TreatmentType type, Animal animal) {
		this.name=name;
		this.id=counter++;
		this.startDate = startDate;
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		c.add(Calendar.DAY_OF_YEAR, type.getDaysDuration());
		this.endDate = new Date(c.getTime().getTime());
		this.type=type;
		this.animal = animal;
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

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
