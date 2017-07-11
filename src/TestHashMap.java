import java.util.HashMap;
import java.util.TreeSet;
import java.util.Set;
import java.util.Scanner;
import java.util.Map;


public class TestHashMap {

	public static void main(String[] args)
	{
		Map<String, Integer> myMap = new HashMap<>();

		createMap(myMap);
		displayMap(myMap);
	}
	
	private static void createMap(Map<String, Integer> myMap)
	{
	    Scanner input = new Scanner(System.in);
	    
	    System.out.println("Enter input string: ");
	    String inputStr = input.nextLine();
	    
	    // create string array from the input list
	    String[] wordArray = inputStr.split(" ");
	    
	    for(String word : wordArray)
	    {
	    	String key = word.toLowerCase();
	    	
	    	if (myMap.containsKey(key))
	    	{
	    		int count = myMap.get(key);
	    		myMap.put(key, count + 1);
	    	}
	    	else
	    	{
	    		myMap.put(key, 1);
	    	}
	    }
	}
	
	private static void displayMap(Map<String, Integer> myMap)
	{
		Set<String> keySet = myMap.keySet();
		
		TreeSet<String> sortedSet = new TreeSet<>(keySet);
		
		for (String key : sortedSet)
		{
			System.out.println(key + " : " + myMap.get(key));
		}
	}
}
