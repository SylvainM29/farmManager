package db_manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import elements.AbstractElement;
import elements.fields.Field;

public class FieldDB extends AbstractDB {

	public FieldDB(Connection dbConnection, DbManager dbManager) {
		super(dbConnection, dbManager, "FIELD");
	}

	@Override
	public List<Field> getAll() throws SQLException {
		List<Field> fieldList = new ArrayList<>();
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName)){
			Field field;
			while(result.next()){
				field = new Field(result.getInt(1),	result.getString(2), result.getString(3), result.getString(4), result.getInt(5));
				field.setFarming(dbManager.getFarmingById(result.getInt(7)));
				fieldList.add(field);
			}
		}
		return fieldList;
	}

	@Override
	public Field getById(int id) throws SQLException {
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName+" WHERE id="+id)){
			result.next();
			Field field = new Field(result.getInt(1),	result.getString(2), result.getString(3), result.getString(4), result.getInt(5));
			field.setFarming(dbManager.getFarmingById(result.getInt(7)));
			return field;
		}
	}

	@Override
	public Field getByName(String name) throws SQLException {
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName+" WHERE name="+name)){
			result.next();
			Field field = new Field(result.getInt(1),	result.getString(2), result.getString(3), result.getString(4), result.getInt(5));
			field.setFarming(dbManager.getFarmingById(result.getInt(7)));
			return field;
		}
	}

	@Override
	public boolean add(List<? extends AbstractElement> elements) throws SQLException {
		for(AbstractElement element : elements) {
			if(element.getClass()!=Field.class){
				dbConnection.rollback();
				return false;
			}
			Field field = (Field)element;
			String str = "INSERT INTO "+tableName+" VALUES ("+
					field.getId()+",'"+
					field.getName()+"','"+
					field.getCity()+"','"+
					field.getAdress()+"',"+
					field.getSquareMeters()+","+
					field.getSquareMeters()+","+
				   (field.getFarming()==null ? "null" : field.getFarming().getId())+")";
			dbConnection.createStatement().executeQuery(str);
		}
		dbConnection.commit();
		return true;
	}

	@Override
	public boolean update(List<? extends AbstractElement> elements) throws SQLException {
		for(AbstractElement element : elements) {
			if(element.getClass()!=Field.class){
				dbConnection.rollback();
				return false;
			}
			Field field = (Field)element;
			dbConnection.createStatement().executeQuery("UPDATE "+tableName+" SET "+
				"id = "+field.getId()+","+
				"name = '"+field.getName()+"',"+
				"city = '"+field.getCity()+"',"+
				"adress = '"+field.getAdress()+"',"+
				"surface_km2 = '"+field.getSquareMeters()+"',"+
				"surface_ha = '"+field.getSquareMeters()+"',"+
				"fk_farming = "+(field.getFarming()==null ? "null" : field.getFarming().getId())+
				"WHERE id = "+field.getId());
		}
		dbConnection.commit();
		return true;
	}

}
