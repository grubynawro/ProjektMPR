package testy;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import db.MySqlUnitOfWork;
import db.dao.CustomerDao;
import db.dao.MySqlCustomerDao;
import shop.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerDaoTest {

	db.dao.CustomerDao dao;

	Connection connection = null;
	private Statement drop;
	
	@BeforeClass
	public static void initialize()
	{}
	
	@Before
	public void setUp()
	{

		Customer c = new Customer();
		c.setNumber(7);
		c.setName("Alicja");
		c.setSurname("Testowa");
		c.setAddress("ul. Testowa 13");
		try {

			MySqlUnitOfWork uow = new MySqlUnitOfWork();
			dao = new MySqlCustomerDao(uow);
			dao.save(c);
			uow.commit();
			drop = uow.getConnection().createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@After
	public void teardown()
	{
		try{
			if(connection!=null && !connection.isClosed())
			{	
				drop.executeUpdate("Drop table Customer");
				connection.close();
				connection = null;
			}}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	}
	
	@Test
	public void testGet() {
		
		Customer c1 = dao.get(1);
		Customer c2 = dao.get(2);
		Customer c3 = dao.get(0);
		
		assertNotNull("zwrocono null mimo ze obiekt jest w bazie",c1);
		assertNull("zwrocono wartosc mimo, ze nie ma takiego obiektu w bazie",c2);
		assertTrue(c1.getNumber() == 7);
		
		assertEquals(c1.getName(),"Alicja");
		assertEquals(c1.getSurname(), "Testowa");
		assertEquals(c1.getAddress(),"ul. Testowa 13");
		
		assertNotSame(c1,c3);
		
	}

}
