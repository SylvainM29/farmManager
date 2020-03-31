package elements.inseminations;

import java.sql.Date;

import elements.animals.Animal;

public class Insemination {
	private static int counter = 0;
	
	private int id;
	private Date date;
	private String bullId;
	private Animal cow;
	
	public Insemination(Date date, String bullId, Animal cow) {
		this.id = counter++;
		this.date = date;
		this.bullId = bullId;
		this.cow = cow;
		cow.addInsemination(this);
	}

	public String getBullId() {
		return bullId;
	}
	
	public void setBullId(String bullId) {
		this.bullId = bullId;
	}
	
	public int getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Animal getCow() {
		return cow;
	}
	
}
