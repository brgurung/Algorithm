
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter name: ");
		System.out.println("Entered name: " + input.next());

	    System.out.println("Enter age: ");
	    int age = -1;
	    try
	    {
	        age = input.nextInt();
	    }
	    catch(InputMismatchException e)
	    {
	    	System.out.println("Invalid input!");
	    }
	    System.out.println("Age:  " + age);
	    
	    System.out.println("Enter marks: ");
	    ArrayList marks = new ArrayList();
	    while(input.hasNextInt())
	    {
	    	marks.add(input.nextInt());
	    }
	    System.out.println("Marks: " + marks.toString());
	    input.close();
	}
}
