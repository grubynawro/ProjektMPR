package shop;

import java.util.List;

import db.Entity;
import db.Entity;

public class Customer extends Entity {

	private int number;
	private String name;
	private String surname;
	private String email;
	private String address;
	
	//relacja klient-zamowienie
	public List<Order> orders;

	public int getNumber() {
		return number;
	}

	public void setNumber(int i) {
		this.number = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Customer(){};
	public Customer(int number, String name, String surname, String email,
			String address) {
		super();
		this.number = number;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
	}
	
}