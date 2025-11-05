package library.tracker;

public interface LibraryOperations 
{
	 void addBook(Book book);
	 void removeBook(int bookId);
	 void lendBook(int bookId, int userId);
	 void viewAvailableBooks();
	 void viewIssuedBooks();
}