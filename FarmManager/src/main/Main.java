package main;

import java.sql.SQLException;

import db_manager.DbManager;
import elements.animals.Animal;

public class Main {
	private static DbManager db;

	public static void main(String[] args) throws SQLException {
		initDB();
		for(Animal animal : db.getAnimals()){
			System.out.println("Animal number "+animal.getId()+" is named "+animal.getName()+" and is"+(animal.isFull() ? "" : " not")+" full");
		}
	}
	
	private static void initDB() throws SQLException {
		db = new DbManager();
	}
}
