package elements.animals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import elements.AbstractElement;
import elements.fields.Field;
import elements.inseminations.Insemination;
import elements.treatments.Treatment;

public class Animal extends AbstractElement {

	private int id;
	private String name;
	private Animal father;
	private Animal mother;
	private Set<Animal> childs;
	private AnimalType type = AnimalType.CALF;
	private Field field;
	private List<Treatment> treatmentList;
	private boolean full = false;
	private List<Insemination> currentInseminations;

	public Animal(int id, String name, Animal father, Animal mother, AnimalType type) {
		this.id=id;
		this.name=name;
		this.father = father;
		this.mother = mother;
		this.childs = new HashSet<>();
		this.treatmentList = new ArrayList<>();
		this.type = type!=null ? type : this.type; //Si param type null, on conserve la valeur par defaut
		this.currentInseminations = new ArrayList<>();
	}
	
	public Animal(int id, String name, String typeString, boolean full) {
		this.id=id;
		this.name=name;
		this.childs = new HashSet<>();
		this.treatmentList = new ArrayList<>();
		this.type = AnimalType.identifyType(typeString);
		this.currentInseminations = new ArrayList<>();
		this.full = full;
	}

	public Animal getFather() { return father;}
	public Animal getMother() { return mother;}
	public void setFather(Animal father){ this.father=father;}
	public void setMother(Animal mother){ this.mother=mother;}

	public Set<Animal> getChilds() { return childs;}
	public void addChild(Animal child) { this.childs.add(child);}

	public AnimalType getType() { return type;}
	public void setType(AnimalType type) { this.type = type;}

	public Field getField() { return field;}
	public void setField(Field field) { this.field = field;}

	public Treatment getCurrentTreatment() {
		Treatment lastTreatment = getLastTreatment();
		return (lastTreatment.isFinished() ? null : lastTreatment);
	}
	private Treatment getLastTreatment() { return treatmentList.get(treatmentList.size()-1);}
	public List<Treatment> getTreatments() { return treatmentList;}
	public void addTreatment(Treatment treatment) { this.treatmentList.add(treatment);}

	public String getName() { return name;}

	public int getId() { return id;}

	public boolean isFull() { return full;}
	public void setFull(boolean full) { this.full = full;}
	
	public List<Insemination> getCurrentInseminations() { return currentInseminations;}
	public void resetCurrentInsemination() { this.currentInseminations = new ArrayList<>();}
	public void addInsemination(Insemination insemination) { this.currentInseminations.add(insemination);}
}
