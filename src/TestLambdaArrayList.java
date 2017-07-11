import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class TestLambdaArrayList {

	public static void main(String[] args)
	{
		int[] primArray = {5, 2, 1, 4, 9, 3, 7, 6};
		Integer[] intArray = {5, 2, 1, 4, 9, 3, 7, 6};
		
		IntStream intStream = Arrays.stream(primArray);
		
		// filter the array such that x > 2, sort it and get list
	//	List<Integer> intList = intStream.filter(x -> x > 2)
	//									 .sorted()
	//									 .collect(Collectors.toList());

	    List<Integer> intList = Arrays.stream(intArray).filter(x->x > 2).sorted().collect(Collectors.toList());
	    
	    System.out.println(intList);
	    
	    //convert Stream<Integer> to IntStream
	    IntStream primStream = Arrays.stream(intArray).mapToInt(Integer::intValue);
	}
}
