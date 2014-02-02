package default_package;

import db.MySqlUnitOfWork;
import db.dao.CustomerDao;
import db.dao.MySqlCustomerDao;
import shop.Customer;


public class Main {

	public static void main(String[] args) {
		
		
		
			MySqlUnitOfWork uow = new MySqlUnitOfWork();
			CustomerDao dao = new MySqlCustomerDao(uow);
			Customer c = new Customer();
			
			c.setEmail("marian@onet.pl");
			c.setName("Marian");
			c.setSurname("Nowakowski");
			c.setNumber(32);
			
			Customer c1 = new Customer();
			c1.setNumber(56);
	//		dao.delete(c1);
			dao.save(c);
			dao.save(c1);
			uow.commit();
			uow.close();
		System.out.println("koniec");
	}

}

