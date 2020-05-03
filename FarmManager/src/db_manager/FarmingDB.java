package db_manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import elements.AbstractElement;
import elements.fields.Field;
import elements.fields.farmings.Farming;

public class FarmingDB extends AbstractDB {

	public FarmingDB(Connection dbConnection, DbManager dbManager) {
		super(dbConnection, dbManager, "FARMING");
	}

	@Override
	public List<Farming> getAll() throws SQLException {
		List<Farming> farmingList = new ArrayList<>();
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName)){
			Farming farming;
			while(result.next()){
				farming = new Farming(result.getInt(1),	result.getString(2), new Date(result.getInt(3)), new Date((result.getInt(4))));
				farming.setType(dbManager.getFarmingType(result.getInt(5)));
				farming.setField(dbManager.getField(result.getInt(6)));
				farmingList.add(farming);
			}
		}
		return farmingList;
	}

	@Override
	public Farming getById(int id) throws SQLException {
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName+" WHERE id="+id)){
			result.next();
			Farming farming = new Farming(result.getInt(1),	result.getString(2), new Date(result.getInt(3)), new Date((result.getInt(4))));
			farming.setType(dbManager.getFarmingType(result.getInt(5)));
			farming.setField(dbManager.getField(result.getInt(6)));
			return farming;
		}
	}

	@Override
	public Farming getByName(String name) throws SQLException {
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName+" WHERE name="+name)){
			result.next();
			Farming farming = new Farming(result.getInt(1),	result.getString(2), new Date(result.getInt(3)), new Date((result.getInt(4))));
			farming.setType(dbManager.getFarmingType(result.getInt(5)));
			farming.setField(dbManager.getField(result.getInt(6)));
			return farming;
		}
	}

	@Override
	public boolean add(List<? extends AbstractElement> elements) throws SQLException {
		for(AbstractElement element : elements) {
			if(element.getClass()!=Field.class){
				dbConnection.rollback();
				return false;
			}
			Farming farming = (Farming)element;
			String str = "INSERT INTO "+tableName+" VALUES ("+
					farming.getId()+",'"+
					farming.getName()+"',"+
					farming.getStartDate().getTime()+","+
					farming.getEndDate().getTime()+","+
				   (farming.getType()==null ? "null" : farming.getType().getId())+","+
				   (farming.getField()==null ? "null" : farming.getField().getId())+")";
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
			Farming farming = (Farming)element;
			dbConnection.createStatement().executeQuery("UPDATE "+tableName+" SET "+
				"id = "+farming.getId()+","+
				"name = '"+farming.getName()+"',"+
				"start_date = "+farming.getStartDate().getTime()+","+
				"end_date = "+farming.getEndDate().getTime()+","+
				"fk_farming_type = "+(farming.getType()==null ? "null" : farming.getType().getId())+","+
				"fk_field = "+(farming.getField()==null ? "null" : farming.getField().getId())+
				"WHERE id = "+farming.getId());
		}
		dbConnection.commit();
		return true;
	}

}
