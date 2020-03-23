package elements.treatments;

public class TreatmentType {
	private String name;
	private int daysDuration;

	public TreatmentType(String name, int daysDuration) {
		super();
		this.name = name;
		this.daysDuration = daysDuration;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDaysDuration() {
		return daysDuration;
	}
	public void setDaysDuration(int daysDuration) {
		this.daysDuration = daysDuration;
	}
}
