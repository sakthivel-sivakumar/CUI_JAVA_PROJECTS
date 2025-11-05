package ecommerce.app;

import java.util.*;
public class Cart 
{
	 private String customerId;
	 private List<CartItem> items;
	 
	 public Cart(String customerId) 
	 {
		 this.setCustomerId(customerId);
		 this.items = new ArrayList<>();
	 }
	 public void addItem(Product product, int qty) 
	 {
		 for (CartItem item : items) 
		 {
			 if (item.getProduct().getId() == product.getId()) 
			 {
				 item.setQuantity(item.getQuantity() + qty);
				 return;
			 }
		 }
		 items.add(new CartItem(product, qty));
	 }
	 public void removeItem(int productId) {
	 items.removeIf(item -> item.getProduct().getId() == productId);
	 }
	 public List<CartItem> getItems() { return items; }
	 public double getTotalAmount() {
	 double total = 0;
	 for (CartItem item : items) {
	 total += item.getProduct().getPrice() * item.getQuantity();
	 }
	 return total;
	 }
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
