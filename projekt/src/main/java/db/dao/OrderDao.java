package db.dao;

import java.util.List;

import shop.Order;
import db.Dao;

public interface OrderDao extends Dao<Order>{

	public List<Order> getOrderByCustomerNumer(int number);
}
