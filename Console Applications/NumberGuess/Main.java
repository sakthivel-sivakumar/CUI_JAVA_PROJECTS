package NumberGuess;

import java.util.*;

public class Main {

	public static void main(String[] args) 
	{
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		int a = r.nextInt(9);
		int count = 0;
		int i;
		do
		{
		System.out.println("Enter gussed number in range(1,9): ");
		i = s.nextInt();
		count++;
		}while(i!=a);
		System.out.println("You Gussed at "+count);
		s.close();
	}

}
