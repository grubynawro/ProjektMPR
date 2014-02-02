package db;

import db.Entity;
import db.UnitOfWorkDao;

public interface UnitOfWork {

	public void markNew(Entity ent, UnitOfWorkDao dao);
	public void markDeleted(Entity ent, UnitOfWorkDao dao);
	public void markUpdated(Entity ent, UnitOfWorkDao dao);
	public void commit();
	public void close();
}

