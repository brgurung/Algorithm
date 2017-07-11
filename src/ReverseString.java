import java.util.Deque;
import java.util.ArrayDeque;

public class ReverseString {

	private static String reverseString(String input)
	{
		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < input.length(); i++)
		{
			stack.offerFirst(Character.valueOf(input.charAt(i)));
		}
		
		// pop all the characters one by one as LIFO
		char[] reversed = new char[input.length()];
		for (int i = 0; i < input.length(); i++)
		{
			reversed[i] = stack.pollFirst().charValue();
		}
		
		return String.valueOf(reversed);
	}

	public static void main(String[] args)
	{
		String input =" Hello my name is Android";
		
		input = reverseString(input);
		System.out.println("Reversed string: " + input);
	}
}
