package library.tracker;

import java.util.*;
public class User 
{
	 private int id;
	 private String name;
	 private List<Book> borrowedBooks = new ArrayList<>();
	 public User(int id, String name) 
	 {
		 this.id = id; 
		 this.name = name;
	 }
	 public int getId() 
	 { 
		 return id; 
	 }
	 public String getName() 
	 { 
		 return name; 
	 }
	 public void borrowBook(Book book) 
	 { 
		 borrowedBooks.add(book); 
	 }
	 public void returnBook(Book book) 
	 { 
		 borrowedBooks.remove(book); 
	 }
	 public List<Book> getBorrowedBooks() 
	 { 
		 return borrowedBooks; 
	 }
	 public String toString() 
	 { 
		 return id + " - " + name; 
	 }
}