package elements.fields.farmings;

import java.sql.Date;

import elements.fields.Field;


public class Farming {
	private static int counter = 0;
	
	private String name;
	private int id;
	private Date startDate;
	private Date endDate;
	private Field field;
	private FarmingType type;
	
	public Farming(String name, Date startDate, Date endDate) {
		this.name = name;
		this.id = counter++;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Farming(String name, Date startDate, Date endDate, Field field) {
		this.name = name;
		this.id = counter++;
		this.startDate = startDate;
		this.endDate = endDate;
		this.field = field;
	}
	
	public Farming(String name, Field field) {
		this.name = name;
		this.id = counter++;
		this.field = field;
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

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public FarmingType getType() {
		return type;
	}

	public void setType(FarmingType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

}
