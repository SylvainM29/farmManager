package db_manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import elements.AbstractElement;
import elements.animals.Animal;

public class AnimalDB extends AbstractDB {

	public AnimalDB(Connection dbConnection, DbManager dbManager) {
		super(dbConnection, dbManager, "ANIMAL");
	}
	
	@Override
	public List<Animal> getAll() throws SQLException {
		List<Animal> animalList = new ArrayList<>();
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName)){
			Animal animal;
			while(result.next()){
				animal = new Animal(result.getInt(1),
									result.getString(2),
									new Date(result.getInt(8)),
									result.getString(3),
									(result.getInt(4)==1));
				animal.setFather(dbManager.getAnimal(result.getInt(5)));
				animal.setFather(dbManager.getAnimal(result.getInt(6)));
				animal.setField(dbManager.getField(result.getInt(7)));
				animalList.add(animal);
			}
		}
		return animalList;
	}

	@Override
	public Animal getById(int id) throws SQLException{
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName+" WHERE id="+id)){
			result.next();
			Animal animal = new Animal(result.getInt(1),result.getString(2),new Date(result.getInt(8)),result.getString(3),result.getInt(4)==1);
			animal.setFather(dbManager.getAnimal(result.getInt(5)));
			animal.setFather(dbManager.getAnimal(result.getInt(6)));
			animal.setField(dbManager.getField(result.getInt(7)));
			return animal;
		}
	}

	@Override
	public Animal getByName(String name) throws SQLException{
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName+" WHERE name="+name)){
			result.next();
			Animal animal = new Animal(result.getInt(1),result.getString(2),new Date(result.getInt(8)),result.getString(3),result.getInt(4)==1);
			animal.setFather(dbManager.getAnimal(result.getInt(5)));
			animal.setFather(dbManager.getAnimal(result.getInt(6)));
			animal.setField(dbManager.getField(result.getInt(7)));
			return animal;
		}
	}

	@Override
	public boolean add(List<? extends AbstractElement> elements) throws SQLException {
		for(AbstractElement element : elements) {
			if(element.getClass()!=Animal.class){
				dbConnection.rollback();
				return false;
			}
			Animal animal = (Animal)element;
			String str = "INSERT INTO "+tableName+" VALUES ("+
					animal.getId()+",'"+
					animal.getName()+"','"+
					animal.getType()+"',"+
				   (animal.getFather()==null ? "null" : animal.getFather().getId())+","+
				   (animal.getMother()==null ? "null" : animal.getMother().getId())+","+
				   (animal.getField()==null ? "null" : animal.getField().getId())+","+
				   animal.getBirthdate().getTime()+")";
			dbConnection.createStatement().executeQuery(str);
		}
		dbConnection.commit();
		return true;
	}

	@Override
	public boolean update(List<? extends AbstractElement> elements) throws SQLException {
		for(AbstractElement element : elements) {
			if(element.getClass()!=Animal.class){
				dbConnection.rollback();
				return false;
			}
			Animal animal = (Animal)element;
			dbConnection.createStatement().executeQuery("UPDATE "+tableName+" SET "+
				"id = "+animal.getId()+","+
				"name = '"+animal.getName()+"',"+
				"type = '"+animal.getType()+"',"+
				"fk_animal_father = "+(animal.getFather()==null ? "null" : animal.getFather().getId())+","+
				"fk_animal_mother = "+(animal.getMother()==null ? "null" : animal.getMother().getId())+","+
				"fk_field = "+(animal.getField()==null ? "null" : animal.getField().getId())+","+
				"birthdate = "+animal.getBirthdate()+
				"WHERE id = "+animal.getId());
		}
		dbConnection.commit();
		return true;
	}
}
