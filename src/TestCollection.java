
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class TestCollection {

	public static void readInput(List<String> strList)
	{
        Scanner input = new Scanner(System.in);
        
        while(input.hasNext())
        {
        	String color = input.next();
        	if (color.equals("exit"))
        	{
        		break;
        	}
        	strList.add(color);
        	
        }
        
        System.out.println("String List: " + strList.toString());
	}
	
	public static void removeColor(List<String> inputList, List<String> blackList)
	{
	    	Iterator<String> iter = inputList.iterator();
	    	
	    	while(iter.hasNext())
	    	{
	    		String color = iter.next();
	    		if (true == blackList.contains(color))
	    		{
	    			iter.remove();
	    		}
	    	}
	}
	
	public static void main(String[] args)
	{
		System.out.println("Enter list of colors: ");
		List<String> inputList = new ArrayList<>();
		readInput(inputList);
		
		System.out.println("Enter black list: ");
		List<String> blackList = new ArrayList<>();
		readInput(blackList);
		
		List<String> inputListCopy = new ArrayList<>(inputList);
		System.out.println("Copy of inputList: " + inputListCopy.toString());
		removeColor(inputList, blackList);
		System.out.println("After checking with blacklist : " + inputList.toString());
		
		inputListCopy.removeAll(blackList);
		System.out.println("RemoveAll blacklist: " + inputListCopy.toString());
	}
}
