package shop;

import java.util.List;

import db.Entity;

public class Book extends Entity{

	private String title;
	private String isbn;
	private int numberOfPages;
	private float price;
	
	
	public Book(String title, String isbn, int numberOfPages, float price) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.numberOfPages = numberOfPages;
		this.price = price;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	
}
