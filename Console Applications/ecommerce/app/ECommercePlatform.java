package ecommerce.app;

import java.util.*;
public class ECommercePlatform 
{
	 private List<Product> products = new ArrayList<>();
	 private List<User> users = new ArrayList<>();
	 private Map<String, Cart> carts = new HashMap<>();
	 
	 public void addProduct(Product product) 
	 {
		 products.add(product);
	 }
	 public void registerUser(User user) 
	 {
		 users.add(user);
		 if (user instanceof Customer) 
		 carts.put(user.getEmail(), new Cart(user.getUserId()));
	 }
	 public List<Product> getAllProducts() 
	 {
		 return products;
	 }
	 public Cart getCart(String email) 
	 {
		 return carts.get(email);
	 }
	 public User login(String email, String pwd) 
	 {
		 for (User user : users) 
		 {
			 if (user.getEmail().equals(email) && user.checkPassword(pwd)) 
			 {
				 return user;
			 }
		 }
		 return null;
	 }
	 public void checkout(String email, String method) 
	 {
		 Cart cart = getCart(email);
		 double total = cart.getTotalAmount();
		 Payment payment = null;
		 if (method.equalsIgnoreCase("upi")) 
		 {
			 payment = new UPIPayment(total);
		 } 
		 else if (method.equalsIgnoreCase("card")) 
		 {
			 payment = new CardPayment(total);
		 }
		 if (payment != null) 
		 {
			 payment.pay();
			 cart.getItems().clear();
		 }
	 }
	public boolean checkCart(String email) {
		 Cart cart = getCart(email);
		 if(cart.getItems().size() == 0)
			 return false;
		 else
			 return true;
		
	}
}
