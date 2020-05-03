package elements.fields.farmings;

import java.sql.Date;

import elements.AbstractElement;
import elements.fields.Field;


public class Farming extends AbstractElement {

	private int id;
	private String name;
	private FarmingType type;
	private Date startDate;
	private Date endDate;
	private Field field;
	
	public Farming(int id, String name, Date startDate, Date endDate) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Farming(int id, String name, Date startDate, Date endDate, FarmingType type, Field field) {
		this.name = name;
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
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
