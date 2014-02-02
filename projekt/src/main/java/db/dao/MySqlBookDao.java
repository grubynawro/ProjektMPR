package db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Dao;
import db.DaoBase;
import db.Entity;
import db.MySqlUnitOfWork;
import db.UnitOfWork;
import shop.Customer;
import shop.Book;

/* public class MySqlBookDao extends db.DaoBase<Book> implements Dao<Book>{

	
	private Statement stmt;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement getById;
	private PreparedStatement getAll;
	
	
	public MySqlBookDao(MySqlUnitOfWork uow)
	{
		super(uow);
		try {
			Connection connection = uow.getConnection();
			stmt = connection.createStatement();
			
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			
			boolean exists = false;
			while(rs.next())
			{
				if("book".equalsIgnoreCase(rs.getString("TABLE_NAME")))
				{
					exists = true;
					break;
				}
			}
			
			insert = connection.prepareStatement(""
					+ "INSERT INTO book(name,description,prize)"
					+ " VALUES(?,?,?)");
			
			getById = connection.prepareStatement(""
					+ "SELECT * FROM product WHERE id=?");
			
			delete = connection.prepareStatement("DELETE FROM product WHERE id=?");
			
			getAll = connection.prepareStatement("SELECT * FROM product");
			
			update = connection.prepareStatement(""
					+ "update book set"
					+ "(name,description,prize)=(?,?,?)"
					+ "where id=?");
			
			if(!exists)
			{
				stmt.executeUpdate(""
						+ "CREATE TABLE product("
						+ "id bigint GENERATED BY DEFAULT AS IDENTITY,"
						+ "name varchar(50),"
						+ "description varchar(500),"
						+ "prize double,"
						+ ")");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void persistAdd(EntityBase entity) {
		
		Book ent = (Book)entity;
		try {
			insert.setString(1, ent.getName());
			insert.setString(2, ent.getDescription());
			insert.setDouble(3, ent.getPrize());
			insert.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void persistDelete(EntityBase entity) {
		Book ent = (Book) entity;
		try 
		{
			delete.setInt(1, ent.getId());
			delete.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> getAll() {
			List<Book> clients = new ArrayList<Book>();
		
		try
		{
			ResultSet rs = getAll.executeQuery();
			while(rs.next()){
				
				Book p = new Book();
				p.setId(rs.getInt("id"));
				p.setDescription(rs.getString("description"));
				p.setPrize(rs.getDouble("prize"));
				p.setName(rs.getString("name"));
				clients.add(p);
			}
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return clients;
	}

	@Override
	public Book get(int id) {
		Book p = null;
		try {
			getById.setInt(1, id);
			ResultSet rs = getById.executeQuery();
			while(rs.next())
			{
				p = new Book();
				p.setId(rs.getInt("id"));
				p.setDescription(rs.getString("description"));
				p.setPrize(rs.getDouble("prize"));
				p.setName(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public void persistUpdate(EntityBase entity) {
		Book ent = (Book) entity;
		try
		{
			update.setString(1, ent.getName());
			update.setString(2, ent.getDescription());
			update.setDouble(3, ent.getPrize());
			update.setInt(5, ent.getId());
			update.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		} */

public class MySqlBookDao extends db.DaoBase<Book>  implements Dao<Book>{

	
	protected MySqlBookDao(UnitOfWork uow) {
		super(uow);
		// TODO Auto-generated constructor stub
	}

	private Statement stmt;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement getById;
	private PreparedStatement getAll;
	
	
	public MySqlBookDao(MySqlUnitOfWork uow)
	{
		super(uow);
		try {
			Connection connection = uow.getConnection();
			stmt = connection.createStatement();
			
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			
			boolean exists = false;
			while(rs.next())
			{
				if("book".equalsIgnoreCase(rs.getString("TABLE_NAME")))
				{
					exists = true;
					break;
				}
			}
			
			insert = connection.prepareStatement(""
					+ "INSERT INTO book(name,description,prize)"
					+ " VALUES(?,?,?)");
			
			getById = connection.prepareStatement(""
					+ "SELECT * FROM book WHERE id=?");
			
			delete = connection.prepareStatement("DELETE FROM book WHERE id=?");
			
			getAll = connection.prepareStatement("SELECT * FROM book");
			
			update = connection.prepareStatement(""
					+ "update book set"
					+ "(id, title, isbn, price, numberOfPages)=(?,?,?,?,?)"
					+ "where id=?");
			
			if(!exists)
			{
				stmt.executeUpdate(""
						+ "CREATE TABLE book("
						+ "id int PRIMARY KEY AUTO_INCREMENT NOT NULL,"
						+ "title varchar(50),"
						+ "isbn varchar(13),"
						+ "price float,"
						+ "numberOfPages int"
                		+ ")");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void persistAdd(Entity entity) {
		
		Book ent = (Book)entity;
		try {
			insert.setString(2, ent.getTitle());
			insert.setString(3, ent.getIsbn());
			insert.setFloat(4, ent.getPrice());
			insert.setInt(5, ent.getNumberOfPages());
			insert.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void persistDelete(Entity entity) {
		Book ent = (Book) entity;
		try 
		{
			delete.setInt(1, ent.getId());
			delete.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> getAll() {
			List<Book> books = new ArrayList<Book>();
		
		try
		{
			ResultSet rs = getAll.executeQuery();
			while(rs.next()){
				
				Book p = new Book();
				p.setId(rs.getInt("id"));
				p.setTitle(rs.getString("title"));
				p.setIsbn(rs.getString("isbn"));
				p.setPrice(rs.getFloat("price"));
				p.setNumberOfPages(rs.getInt("numberOfPages"));
				books.add(p);
			}
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return books;
	}

	@Override
	public Book get(int id) {
		Book p = null;
		try {
			getById.setInt(1, id);
			ResultSet rs = getById.executeQuery();
			while(rs.next())
			{
				p = new Book();
				p.setId(rs.getInt("id"));
				p.setTitle(rs.getString("title"));
				p.setIsbn(rs.getString("isbn"));
				p.setPrice(rs.getFloat("price"));
				p.setNumberOfPages(rs.getInt("numberOfPages"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public void persistUpdate(Entity entity) {
		Book ent = (Book) entity;
		try
		{
			update.setString(2, ent.getTitle());
			update.setString(3, ent.getIsbn());
			update.setFloat(4, ent.getPrice());
			update.setInt(5, ent.getNumberOfPages());
			update.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
} 