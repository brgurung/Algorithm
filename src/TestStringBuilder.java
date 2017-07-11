
import java.util.Arrays;

public class TestStringBuilder {

	// String is immutable, StringBuilder gives dynamic string
	// StringBuilder isn't thread safe..use StringBuffer instead
	
	public static void main(String[] args)
	{
		// constructors
		StringBuilder buffer1 = new StringBuilder();
		StringBuilder buffer2 = new StringBuilder("Hello World! Hello Android!");
		StringBuilder buffer3 = new StringBuilder(20);
		
		
		// append
		System.out.println("Append int: " + buffer1.append(123));
		System.out.println("Append string: " + buffer1.append(" one-two-three"));

		// get and set char
		char c = buffer2.charAt(4);
		System.out.println("Char at index 4: " + c);
		
		buffer2.setCharAt(4, 'd');
		System.out.println(buffer2);

		// char array
		char[] charArray = new char[buffer2.length()];
		buffer2.getChars(0, buffer2.length(), charArray, 0);
		System.out.println("Char array: " + Arrays.toString(charArray));

		// delete
		buffer2.delete(0, 5);
		System.out.println(buffer2);
		
		// insert
		buffer2.insert(0, "Hello");
		System.out.println(buffer2);
		
		//replace
		System.out.println("Replace Hello with Mellow: " + buffer2.replace(0, 5, "Mellow"));
	
		//reverse
		System.out.println("Reversed string: " + buffer2.reverse());
	}
}
