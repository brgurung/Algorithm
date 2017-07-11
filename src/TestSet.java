import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Collection;

public class TestSet {

	public static void main(String[] args)
	{
		String rhyme = "Row row row your boat gently down the stream";
		String[] rhymeSplit = rhyme.split(" ");
		
		System.out.println("Split string array: " + Arrays.toString(rhymeSplit));
		
		List<String> rhymeList = Arrays.asList(rhymeSplit);
		
		// print no duplicates
		printNoDuplicates(rhymeList);
				
	}
	
	private static void printNoDuplicates(Collection<String> collection)
	{
		HashSet<String> hashSet = new HashSet<>(collection);
	    System.out.println("Without duplicates: ");
		for(String value: hashSet)
		{
			System.out.println(value);
		}
	}
}
