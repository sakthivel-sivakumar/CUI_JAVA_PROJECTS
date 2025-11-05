package ecommerce.app;

public class UPIPayment extends Payment 
{
	 public UPIPayment(double amount) 
	 {
		 super(amount);
	 }
	 @Override
	 public void pay() 
	 {
		 System.out.println("Paid Rs." + amount + " via UPI.");
	 }
}
