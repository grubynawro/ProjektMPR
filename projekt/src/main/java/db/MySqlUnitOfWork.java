package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlUnitOfWork implements UnitOfWork{

	private Map<Entity, UnitOfWorkDao> added;
	
	Connection connection;
	
	public MySqlUnitOfWork()
	{
		added = new HashMap<Entity, UnitOfWorkDao>();
		connection = getConnection();
	}
	
	public Connection getConnection()
	{
		try
		{
			if(connection==null||connection.isClosed())
				{connection = 
				DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=");
				System.out.println("Polaczono z baza danych.");
				}
		}catch(SQLException ex)
		{
			ex.printStackTrace();
			System.out.println("Problem z laczeniem z baza.");
		}
		return connection;
	}
	
	public void markNew(Entity ent, UnitOfWorkDao dao) {
		ent.setOperation(EntityOper.insert);
		added.put(ent, dao);
		
	}

	public void markDeleted(Entity ent, UnitOfWorkDao dao) {
		ent.setOperation(EntityOper.delete);
		added.put(ent, dao);
		
	}

	public void markUpdated(Entity ent, UnitOfWorkDao dao) {
		ent.setOperation(EntityOper.update);
		added.put(ent, dao);
		
	}

	public void commit() {
	
		Connection conn = getConnection();
		try{
			conn.setAutoCommit(false);
			
			for(Entity ent : added.keySet() )
			{
				switch(ent.getOper())
				{
					case insert:
					{
						added.get(ent).persistAdd(ent);
					}
					case delete:
					{
						added.get(ent).persistDelete(ent);
					}
					case update:
					{
						added.get(ent).persistUpdate(ent);
					}
				}
			}
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
			System.out.println("Problem z commitem.");
		}
		
	}

	public void close() {
		
		try{
			if(connection!=null && !connection.isClosed())
				{
					connection.close();
					connection=null;
				}
			}catch(SQLException ex)
			{
				ex.printStackTrace();
				System.out.println("Problem z zamykaniem polaczenia.");				
			}
		
		
	}

}

