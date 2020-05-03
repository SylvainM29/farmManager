package db_manager;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import elements.animals.Animal;
import elements.fields.Field;
import elements.fields.farmings.Farming;
import elements.fields.farmings.FarmingType;

public class DbManager {
	Connection dbConnection;
	
	private AnimalDB animalDB;
	private FieldDB fieldDB;
	private FarmingDB farmingDB;
	private FarmingTypeDB farmingTypeDB;
	
	public DbManager () {
		initDB();
		animalDB = new AnimalDB(dbConnection, this);
		fieldDB = new FieldDB(dbConnection, this);
		farmingDB = new FarmingDB(dbConnection, this);
	}
	
	private void initDB() {
		String absolutePath = Paths.get("").toAbsolutePath().toString();
		String connectionName = "jdbc:sqlite:"+absolutePath+File.separator+"database.db";
		try {
			Class.forName("org.sqlite.JDBC");
			dbConnection = DriverManager.getConnection(connectionName);
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

	public List<Animal> getAnimals() throws SQLException {
		return animalDB.getAll();
	}

	public Animal getAnimal(int id) throws SQLException {
		return animalDB.getById(id);
	}

	public Animal getAnimal(String name) throws SQLException {
		return animalDB.getByName(name);
	}
	
	public boolean addAnimals(List<Animal> animals) throws SQLException {
		return animalDB.add(animals);
	}
	
	public boolean updateAnimals(List<Animal> animals) throws SQLException {
		return animalDB.update(animals);
	}
	
	public List<Field> getFields() throws SQLException {
		return fieldDB.getAll();
	}

	public Field getField(int id) throws SQLException {
		return fieldDB.getById(id);
	}

	public Field getField(String name) throws SQLException {
		return fieldDB.getByName(name);
	}
	
	public boolean addFields(List<Field> fields) throws SQLException {
		return fieldDB.add(fields);
	}
	
	public boolean updateFields(List<Field> fields) throws SQLException {
		return fieldDB.update(fields);
	}
	
	public List<Farming> getFarmings() throws SQLException {
		return farmingDB.getAll();
	}

	public Farming getFarming(int id) throws SQLException {
		return farmingDB.getById(id);
	}

	public Farming getFarming(String name) throws SQLException {
		return farmingDB.getByName(name);
	}
	
	public boolean addFarmings(List<Farming> farmings) throws SQLException {
		return farmingDB.add(farmings);
	}
	
	public boolean updateFarmings(List<Farming> farmings) throws SQLException {
		return farmingDB.update(farmings);
	}
	
	public List<FarmingType> getFarmingTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	public FarmingType getFarmingType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public FarmingType getFarmingType(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean addFarmingTypes(List<FarmingType> farmingTypes) throws SQLException {
		return farmingTypeDB.add(farmingTypes);
	}
	
	public boolean updateFarmingTypes(List<Farming> farmingTypes) throws SQLException {
		return farmingTypeDB.update(farmingTypes);
	}

	public void closeConnection() {
		try {
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
