package shop;

import java.util.List;

import db.Entity;

public class Order extends Entity{

	private int id;
	private float totalPrice;
	
	public Order(int id, float totalPrice) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Book> getOrderedBooks() {
		return orderedBooks;
	}

	public void setOrderedBooks(List<Book> orderedBooks) {
		this.orderedBooks = orderedBooks;
	}

	//relacja zamowienie - ksiazka
	private List<Book> orderedBooks;
	
	
}
