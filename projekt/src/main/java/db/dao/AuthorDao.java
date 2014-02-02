package db.dao;

import db.Dao;
import shop.Author;;

public interface AuthorDao extends Dao<Author>{

	public void setBooks(Author a);
}
