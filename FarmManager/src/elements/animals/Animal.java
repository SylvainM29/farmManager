package elements.animals;

import java.util.ArrayList;
import java.util.List;
import elements.fields.Field;
import elements.treatments.Treatment;

public class Animal {
	private static int counter = 0;
	
	private String name;
	private int id;
	private Animal father;
	private Animal mother;
	private List<Animal> childs;
	private AnimalType type = AnimalType.CALF;
	private Field field;
	private List<Treatment> treatmentList;

	public Animal(String name, Animal father, Animal mother, AnimalType type) {
		this.name=name;
		this.id=counter++;
		this.father = father;
		this.mother = mother;
		this.childs = new ArrayList<>();
		this.treatmentList = new ArrayList<>();
		this.type = type!=null ? type : this.type; //Si param type null, on conserve la valeur par defaut
	}

	public Animal getFather() {
		return father;
	}

	public Animal getMother() {
		return mother;
	}

	public List<Animal> getChilds() {
		return childs;
	}

	public void addChild(Animal child) {
		this.childs.add(child);
	}

	public AnimalType getType() {
		return type;
	}

	public void setType(AnimalType type) {
		this.type = type;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Treatment getCurrentTreatment() {
		Treatment lastTreatment = getLastTreatment();
		return (lastTreatment.isFinished() ? null : lastTreatment);
	}
	
	private Treatment getLastTreatment() {
		return treatmentList.get(treatmentList.size()-1);
	}

	public List<Treatment> getTreatments() {
		return treatmentList;
	}

	public void addTreatment(Treatment treatment) {
		this.treatmentList.add(treatment);
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
