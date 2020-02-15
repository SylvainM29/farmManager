package elements.animals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import elements.AbstractElement;
import elements.fields.Field;

public class Animal extends AbstractElement {
	
	private Animal father;
	private Animal mother;
	private List<Animal> childs;
	private AnimalType type = AnimalType.VEAU;
	private Field field;
	private Map<Date, Treatment> treatment;

	public Animal(int id, String name, Animal father, Animal mother, AnimalType type) {
		super(id, name);
		this.father = father;
		this.mother = mother;
		this.childs = new ArrayList<>();
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

	public Map<Date, Treatment> getTreatment() {
		return treatment;
	}

	public void setTreatment(Map<Date, Treatment> treatment) {
		this.treatment = treatment;
	}
}
