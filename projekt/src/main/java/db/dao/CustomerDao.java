package db.dao;

import db.Dao;
import shop.Customer;

public interface CustomerDao extends Dao<Customer>{
	
	public void setOrders(Customer c);
}
