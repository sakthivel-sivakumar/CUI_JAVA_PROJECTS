package ecommerce.app;

public class Product {
	 private int id;
	 private String name;
	 private double price;
	 private String category;
	 private int stockQty;
	 public Product(int id, String name, double price, String category, int stockQty) {
	 this.id = id;
	 this.name = name;
	 this.price = price;
	 this.category = category;
	 this.stockQty = stockQty;
	 }
	 public int getId() 
	 { 
		 return id; 
	 }
	 public String getName() 
	 { 
		 return name; 
	 }
	 public double getPrice()
	 {
		 return price;
	 }
	 public String getCategory()
	 {
		 return category;
	 }
	 public int getStockQty()
	 {
		 return stockQty;
	 }
	 public void setStockQty(int stockQty) 
	 {
		 this.stockQty = stockQty; 
	 }
	 @Override
	 public String toString() 
	 {
		 return "Product ID: " + id +
		 "\nName: " + name +
		 "\nPrice: Rs." + price +
		 "\nCategory: " + category +
		 "\nStock Available: " + stockQty + "\n";
		 }
	}
