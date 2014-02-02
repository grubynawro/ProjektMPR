package shop;

import java.util.List;

import db.Entity;

public class Author extends Entity{

	private String name;
	private String surname;
	
	
	//relacja autor-ksazka
	private List<Book> books;


	public Author(String name, String surname, List<Book> books) {
		super();
		this.name = name;
		this.surname = surname;
		this.books = books;
	}


	public Author() {
		// TODO Auto-generated constructor stub
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


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
