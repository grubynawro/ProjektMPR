package db.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import db.MySqlUnitOfWork; 
public class AuthorDaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MySqlUnitOfWork uow = new MySqlUnitOfWork();
		CustomerDao dao = new MySqlCustomerDao(uow);
	}
		@Test
	public void testSave() {
		fail("Not yet implemented");
	}

}
