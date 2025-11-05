package library.tracker;

	import java.util.*;

	public class LibrarySystem implements LibraryOperations {
	    private HashMap<Integer, Book> books = new HashMap<>();
	    private HashMap<Integer, User> users = new HashMap<>();

	    public void addUser(User user) {
	        users.put(user.getId(), user);
	    }

	    public User getUserById(int id) {
	        return users.get(id);
	    }

	    @Override
	    public void addBook(Book book) {
	        books.put(book.getId(), book);
	    }

	    @Override
	    public void removeBook(int bookId) {
	        books.remove(bookId);
	    }

	    @Override
	    public void lendBook(int bookId, int userId) {
	        Book book = books.get(bookId);
	        User user = users.get(userId);

	        if (book != null && user != null && !book.isIssued()) {
	            book.setIssued(true);
	            user.borrowBook(book);
	            System.out.println("Book '" + book.getTitle() + "' issued to " + user.getName());
	        } else {
	            System.out.println("Cannot issue book. Either not available or user/book not found.");
	        }
	    }
	    
	    public void returnBook(int bookId, int userId) {
	        Book book = books.get(bookId);
	        User user = users.get(userId);

	        if (book != null && user != null && book.isIssued()) {
	            book.setIssued(false);
	            user.returnBook(book);
	            System.out.println("Book '" + book.getTitle() + "' returned by " + user.getName());
	        } else {
	            System.out.println("Cannot return book. Either not issued or user/book not found.");
	        }
	    }
	    @Override
	    public void viewAvailableBooks() {
	        System.out.println("Available Books:");
	        for (Book book : books.values()) {
	            if (!book.isIssued()) {
	                System.out.println(book);
	            }
	        }
	    }

	    @Override
	    public void viewIssuedBooks() {
	        System.out.println("Issued Books:");
	        for (Book book : books.values()) {
	            if (book.isIssued()) {
	                System.out.println(book);
	            }
	        }
	    }
	}
