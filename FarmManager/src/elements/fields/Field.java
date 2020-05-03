package elements.fields;

import java.util.HashSet;
import java.util.Set;

import elements.AbstractElement;
import elements.animals.Animal;
import elements.fields.farmings.Farming;

public class Field extends AbstractElement {
	
	private String name;
	private int id;
	private Set<Animal> animals;
	private Farming farming;
	private String city;
	private String adress;
	private int squareMeters;
	
	public Field(int id, String name, String city, String adress, int squareMeters, Set<Animal> animals, Farming farming) {
		this.name = name;
		this.id = id;
		this.city = city;
		this.adress = adress;
		this.squareMeters = squareMeters;
		this.animals = animals;
		this.farming = farming;
	}

	public Field(int id, String name, String city, String adress, int squareMeters) {
		this.name = name;
		this.id = id;
		this.city = city;
		this.adress = adress;
		this.squareMeters = squareMeters;
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
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getSquareMeters() {
		return squareMeters;
	}

	public void setSquareMeters(int squareMeters) {
		this.squareMeters = squareMeters;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

}
