
import java.util.Arrays;

public class TestString {

	public static void main(String[] args)
	{
		String s1 = "Hello World! How are you?";
		String s2 = "22";
		String s3 = "";
		String s4 = "22";
		String s5 = new String("22");
		String s6 = "Myau Myau Biralo! Myau Myau bhana!";
        String s7 = "  Hello Mary Lou!      ";

        // Find character at index
        char c = s1.charAt(2);
        System.out.println("Character at index 2: " + c);
        
        
	   // Find index of first start
        int index = s1.indexOf('W');
        System.out.println("First index of W: " + index);
        
        index = s1.indexOf('l', 12); // first index of 'l' starting at 12th index
        System.out.println("First index of 'l' starting at 12th index: " + index);
        
        index = s1.indexOf('z');
        System.out.println("First index of 'z': " + index);
        
        index = s1.indexOf("Wor");
        System.out.println("First index of Wor: " + index);
        
        // Find index of first char/string from the end
        index = s1.toUpperCase().lastIndexOf('W');
        System.out.println("Last index of 'W': " + index);
	
        // boolean check
        System.out.println("Is string empty check: s1: " + s1.isEmpty() + " s3: " + s3.isEmpty());
	    System.out.println("Starts with Hell: " + s1.startsWith("Hell"));
	    System.out.println("Starts with Wor: " + s1.startsWith("Wor", 6));
	
        // Find substring
	    String sub = s1.substring(6);
	    System.out.println("Substring starting at index 6: " + sub);
	    
	    sub = s1.substring(6, 11); //substring starting at 6 and ending at 10
	    System.out.println("Substring starting at 6th and ending and (11th - 1): " + sub);
	
	    // compare
	    System.out.println("S1 equals s2: " + s1.equals(s2));
	    System.out.println("S2 equals s4: " + (s2 == s4));
	    System.out.println("S2 equals s5: using assignment: " + (s2 == s5) + " Using equals: " + s2.equals(s5));
	    System.out.println("S2 compared to s4: " + s2.compareTo(s4));
	    
 
	    // convert to char array and back
        char[] charSeq = s1.toCharArray();
        System.out.println("Char array: " + Arrays.toString(charSeq));
	
        s1.getChars(0, 10, charSeq, 0); // srcBegin, srcEnd, char array, start index to copy to
        System.out.println("Char array: " + Arrays.toString(charSeq));

        // convert integer to string and vice-versa
        System.out.println("String to int: " + Integer.parseInt(s2));

        // replace
        System.out.println("Replace All l with z: " + s1.replace('l', 'z'));
        System.out.println("Replace first myau: " + s6.replaceFirst("Myau", "Bhau"));
        System.out.println("Replace all myau: " + s6.replace("Myau", "Kyau"));

        // split
	    String[] splitStr = s6.split(" ");
	    System.out.println("Split str: " + Arrays.toString(splitStr));
	

	    //remove whitespaces
        System.out.println("remove whitespaces: " + s7.trim());
	}
}
