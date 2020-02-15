package elements.fields;

import java.util.HashSet;
import java.util.Set;

import elements.AbstractElement;
import elements.animals.Animal;

public class Field extends AbstractElement {
	
	private Set<Animal> animals;
	private Farming farming;

	public Field(int id, String name) {
		super(id, name);
		animals = new HashSet<>();
		
	}

	public Set<Animal> getAnimals() {
		return animals;
	}
	
	public void addAnimal(Animal animal) {
		this.animals.add(animal);
	}
	
	public void removeAnimal(Animal animal) {
		this.animals.remove(animal);
	}

	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}

	public Farming getFarming() {
		return farming;
	}

	public void setFarming(Farming farming) {
		this.farming = farming;
	}

}
