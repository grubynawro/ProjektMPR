package db;

import java.util.List;

import db.Dao;
import db.Entity;
import db.UnitOfWork;
import db.UnitOfWorkDao;

public abstract class DaoBase<E extends Entity> 
	implements Dao<E>, UnitOfWorkDao{

	
	UnitOfWork uow;
	
	protected DaoBase(UnitOfWork uow)
	{
		this.uow=uow;
	}
	
	public void save(E ent)
	{
		uow.markNew(ent, this);
	}
	
	public void update(E ent)
	{
		uow.markUpdated(ent, this);
	}
	
	public void delete(E ent)
	{
		uow.markDeleted(ent, this);
	}
	
	public abstract E get(int id);
	public abstract List<E> getAll();
	public abstract void persistAdd(Entity ent);
	public abstract void persistDelete(Entity ent);
	public abstract void persistUpdate(Entity ent);
	
	
}
