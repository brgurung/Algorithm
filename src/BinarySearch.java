
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;


public class BinarySearch {

    private enum BinarySearchType
    {
    	ITERATIVE(0),
    	RECURSIVE(1);
    	
    	private int value;
    	
    	BinarySearchType(int value)
    	{
    	    this.value = value;	
    	}
    	
    	int getValue()
    	{
    		return value;
    	}
    };

//  static final int binarySearchType = BinarySearchType.ITERATIVE.getValue();
    static final int binarySearchType = BinarySearchType.RECURSIVE.getValue();

    private static int binarySearchIterative(List<Integer> input, int key)
    {
    	int upperBound = input.size() - 1;
    	int lowerBound = 0;
    	int index = -1;

    	while (true)
    	{
    		if (upperBound < lowerBound)
    		{
    			break;
    		}
    		
    		int midPoint = (upperBound + lowerBound) / 2;
    		
    		if (input.get(midPoint) == key)
    		{
    			index = midPoint;
    			break;
    		}
    		else if (input.get(midPoint) > key)
    		{
    			upperBound = midPoint - 1;
 			}
    		else
    		{
    			lowerBound = midPoint + 1;
    		}
    	}
    	
    	return index;
    }
    
    
    private static int binarySearchRecursive(List<Integer> input, int key, int lowerBound, int upperBound)
    {
    	if (lowerBound > upperBound)
    	{
    		return -1;
    	}
    	
    	int midPoint = (lowerBound + upperBound) / 2;
    	
    	if (input.get(midPoint) == key)
    	{
    		return midPoint;
    	}
    	else if (input.get(midPoint) > key)
    	{
    		return binarySearchRecursive(input, key, lowerBound, midPoint - 1);
    	}
    	else
    	{
    		return binarySearchRecursive(input, key, midPoint + 1, upperBound);
    	}
    }

    private static int binarySearch(List<Integer> input, int key)
    {
    	if (binarySearchType == BinarySearchType.ITERATIVE.getValue())
    	{
    		System.out.println("Running iterative binary search!");
    		return binarySearchIterative(input, key);
    	}
    	else
    	{
    		System.out.println("Running Recursive binary search!");
    		return binarySearchRecursive(input, key, 0, input.size() - 1);
    	}
    }
    
    public static void main(String[] args)
	{
		Random random = new Random(32);
		
		List<Integer> intList = random.ints(10)
									  .map(x -> Math.abs(x))
									  .mapToObj(x-> x/1000000)  // or can use "boxed" later
									  .sorted()
									  //.boxed()     // converts IntStream to Stream<Integer>
									  .collect(Collectors.toList());
									  
		System.out.println("Input for binary search: " + intList);
	    // Find 1167
	    System.out.println("Index for 1167 is: " + binarySearch(intList, 1167));
	    System.out.println("Index for 2000 is: " + binarySearch(intList, 2000));
	    System.out.println("Index for 0 is: " + binarySearch(intList, 0));
	}
}
