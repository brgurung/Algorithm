
import java.util.*;

public class TestException {

	public static int division(int num, int denom) throws ArithmeticException
	{
		return num/denom;
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean countinueLoop = true;
		do
		{
			try
			{
				System.out.println("Enter num: ");
				int num = input.nextInt();
				
				System.out.println("Enter denom: ");
				int den = input.nextInt();
				
				System.out.println(division(num, den));
				
				countinueLoop = false;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Input doesn not match!");
				input.nextLine();
				e.printStackTrace();
			}
			catch(ArithmeticException e)
			{
				System.out.println("Division by 0 error!");
				e.printStackTrace();
			}
			
		} while(countinueLoop);
		
	}
	
}
