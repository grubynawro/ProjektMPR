package db;

import java.util.List;

import db.Entity;

public interface Dao<E extends Entity> {

	public void save(E ent);
	public void delete(E ent);
	public List<E> getAll();
	public E get(int id);
	public void update(E ent);
}
