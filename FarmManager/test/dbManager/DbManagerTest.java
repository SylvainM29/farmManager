package dbManager;

import org.junit.After;
import org.junit.Before;

import db_manager.DbManager;

public class DbManagerTest {
	DbManager dbManager;

	@Before
	public void init() {
		
	}
	
	@After
	public void close(){
		dbManager.closeConnection();
	}
 }
