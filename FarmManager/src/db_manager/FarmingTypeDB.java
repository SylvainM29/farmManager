package db_manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import elements.AbstractElement;
import elements.fields.Field;
import elements.fields.farmings.FarmingType;

public class FarmingTypeDB extends AbstractDB {

	public FarmingTypeDB(Connection dbConnection, DbManager dbManager) {
		super(dbConnection, dbManager, "FARMING_TYPE");
	}

	@Override
	public List<FarmingType> getAll() throws SQLException {
		List<FarmingType> farmingTypeList = new ArrayList<>();
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName)){
			FarmingType farmingType;
			while(result.next()){
				farmingType = new FarmingType(result.getInt(1),	result.getString(2), result.getInt(3));
				farmingTypeList.add(farmingType);
			}
		}
		return farmingTypeList;
	}

	@Override
	public FarmingType getById(int id) throws SQLException {
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName+" WHERE id="+id)){
			result.next();
			return new FarmingType(result.getInt(1), result.getString(2), result.getInt(3));
		}
	}

	@Override
	public FarmingType getByName(String name) throws SQLException {
		try (ResultSet result = dbConnection.createStatement().executeQuery("SELECT * FROM "+tableName+" WHERE name="+name)){
			result.next();
			return new FarmingType(result.getInt(1), result.getString(2), result.getInt(3));
		}
	}

	@Override
	public boolean add(List<? extends AbstractElement> elements) throws SQLException {
		for(AbstractElement element : elements) {
			if(element.getClass()!=Field.class){
				dbConnection.rollback();
				return false;
			}
			FarmingType farmingType = (FarmingType)element;
			String str = "INSERT INTO "+tableName+" VALUES ("+
					farmingType.getId()+",'"+
					farmingType.getName()+"',"+
					farmingType.getDaysDuration()+")";
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
			FarmingType farmingType = (FarmingType)element;
			dbConnection.createStatement().executeQuery("UPDATE "+tableName+" SET "+
				"id = "+farmingType.getId()+","+
				"name = '"+farmingType.getName()+"',"+
				"start_date = "+farmingType.getDaysDuration()+
				"WHERE id = "+farmingType.getId());
		}
		dbConnection.commit();
		return true;
	}

}
