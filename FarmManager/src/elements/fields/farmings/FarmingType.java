package elements.fields.farmings;

public class FarmingType {
	private int id;
	private String name;
	private int daysDuration;

	public FarmingType(int id, String name, int daysDuration) {
		super();
		this.setId(id);
		this.name = name;
		this.daysDuration = daysDuration;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
