package elements.fields;

import java.sql.Date;

import elements.AbstractElement;

public class Farming extends AbstractElement {
	private Date startDate;
	private Date endDate;
	private Field field;
	private FarmingType type;

	public Farming(String name) {
		super(counter, name);
	}
	
	public Farming(String name, Date startDate, Date endDate) {
		super(counter, name);
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Farming(String name, Date startDate, Date endDate, Field field) {
		super(counter, name);
		this.startDate = startDate;
		this.endDate = endDate;
		this.field = field;
	}
	
	public Farming(String name, Field field) {
		super(counter, name);
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

}
