package db_manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import elements.AbstractElement;

public abstract class AbstractDB {
	protected Connection dbConnection;
	protected DbManager dbManager;
	protected String tableName;
	
	public AbstractDB(Connection dbConnection, DbManager dbManager, String tableName) {
		this.dbConnection = dbConnection;
		this.dbManager = dbManager;
		this.tableName = tableName;
	}
	
	public abstract List<? extends AbstractElement> getAll() throws SQLException;
	
	public abstract AbstractElement getById(int id) throws SQLException;
	
	public abstract AbstractElement getByName(String name) throws SQLException;
	
	public abstract boolean add(List<? extends AbstractElement> elements) throws SQLException;
	
	public abstract boolean update(List<? extends AbstractElement> elements) throws SQLException;
	
}
