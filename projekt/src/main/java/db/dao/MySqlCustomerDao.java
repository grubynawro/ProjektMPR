package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import shop.Book;
import shop.Customer;
import db.Dao;
import db.Entity;
import db.MySqlUnitOfWork;
import db.UnitOfWork;

public class MySqlCustomerDao extends db.DaoBase<Customer>  implements CustomerDao{

	
	protected MySqlCustomerDao(UnitOfWork uow) {
		super(uow);
		// TODO Auto-generated constructor stub
	}

	private Statement stmt;
	private PreparedStatement insert;
	private PreparedStatement delete;
	private PreparedStatement update;
	private PreparedStatement getById;
	private PreparedStatement getAll;
	OrderDao orderDao;
	
	
	public MySqlCustomerDao(MySqlUnitOfWork uow)
	{
		super(uow);
		try {
			Connection connection = uow.getConnection();
			stmt = connection.createStatement();
			
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			
			boolean exists = false;
			while(rs.next())
			{
				if("customer".equalsIgnoreCase(rs.getString("TABLE_NAME")))
				{
					exists = true;
					break;
				}
			}
			
			insert = connection.prepareStatement(""
					+ "INSERT INTO customer(number,name,surname,email,address)"
					+ " VALUES(?,?,?,?,?)");
			
			getById = connection.prepareStatement(""
					+ "SELECT * FROM customer WHERE number=?");
			
			delete = connection.prepareStatement("DELETE FROM customer WHERE number=?");
			
			getAll = connection.prepareStatement("SELECT * FROM customer");
			
			update = connection.prepareStatement(""
					+ "update customer set"
					+ "(number,name,surname,email,address)=(?,?,?,?,?)"
					+ "where number=?");
			
			if(!exists)
			{
				stmt.executeUpdate(""
						+ "CREATE TABLE customer("
						+ "number int PRIMARY KEY AUTO_INCREMENT NOT NULL,"
						+ "name varchar(50),"
						+ "surname varchar(50),"
						+ "email varchar(50),"
						+ "address varchar(50)"
                		+ ")");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void persistAdd(Entity entity) {
		
		Customer ent = (Customer)entity;
		try {
			insert.setInt(1, ent.getNumber());
			insert.setString(2, ent.getName());
			insert.setString(3, ent.getSurname());
			insert.setString(4, ent.getEmail());
			insert.setString(5, ent.getAddress());
			insert.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void persistDelete(Entity entity) {
		Customer ent = (Customer) entity;
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
	public List<Customer> getAll() {
			List<Customer> customers = new ArrayList<Customer>();
		
		try
		{
			ResultSet rs = getAll.executeQuery();
			while(rs.next()){
				
				Customer c = new Customer();
				c.setNumber(rs.getInt("number"));
				c.setName(rs.getString("name"));
				c.setSurname(rs.getString("surname"));
				c.setEmail(rs.getString("email"));
				c.setAddress(rs.getString("address"));
				customers.add(c);
			}
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return customers;
	}

	@Override
	public Customer get(int id) {
		Customer c = null;
		try {
			getById.setInt(1, id);
			ResultSet rs = getById.executeQuery();
			while(rs.next())
			{
				c = new Customer();
				c.setNumber(rs.getInt("number"));
				c.setName(rs.getString("name"));
				c.setSurname(rs.getString("surname"));
				c.setEmail(rs.getString("email"));
				c.setAddress(rs.getString("address"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public void persistUpdate(Entity entity) {
		Customer ent = (Customer) entity;
		try
		{
			update.setString(2, ent.getName());
			update.setString(3, ent.getSurname());
			update.setString(4, ent.getEmail());
			update.setString(5, ent.getAddress());
			update.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	public void setOrders(Customer c) {
			c.setOrders(orderDao.getOrderByCustomerNumer(c.getNumber()));
			
		}
	}

