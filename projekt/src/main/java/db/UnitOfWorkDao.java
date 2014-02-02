package db;

import db.Entity;

public interface UnitOfWorkDao {

	public void persistAdd(Entity ent);
	public void persistDelete(Entity ent);
	public void persistUpdate(Entity ent);
}
