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

	public Animal getAnimalById(int id) throws SQLException {
		return animalDB.getById(id);
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

	public Field getFieldById(int id) throws SQLException {
		return fieldDB.getById(id);
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

	public Farming getFarmingById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean addFarmings(List<Farming> farmings) throws SQLException {
		return farmingDB.add(farmings);
	}

	public FarmingType getFarmingTypeById(int int1) {
		// TODO Auto-generated method stub
		return null;
	}
}
