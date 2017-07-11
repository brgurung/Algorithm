
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private static List<Integer> fibonacciIterative(int series)
	{
	    List<Integer> fibonacci = new ArrayList<>();
	    
	    for (int i = 0; i < series; i++)
	    {
	    	if ((i == 0) || (i == 1))
	    	{
	    	    fibonacci.add(i);
	    	}
	    	else
	    	{
	    		fibonacci.add(fibonacci.get(i-2) + fibonacci.get(i - 1));
	    	}
	    }
        return fibonacci;	    
	}

	private static Integer fibonacciRec(int series)
	{
		if (series <= 1)
		{
			return series;
		}
		else
		{
			return fibonacciRec(series - 1) + fibonacciRec(series - 2);
		}
	}

	private static List<Integer> fibonacciRecursive(int series)
	{
		List<Integer> fibonacci = new ArrayList<>();
		
		for (int i = 0; i < series; i++)
		{
			fibonacci.add(fibonacciRec(i));
		}
		return fibonacci;
	}
	
	private static List<Integer> fibonacciLambda(int series)
	{
	  return Stream.iterate(new int[]{0,1}, s -> new int[]{s[1], s[0] + s[1]})
			  	   .limit(series)
			  	   .map(s -> s[0])
			  	   .collect(Collectors.toList());
	}
	

	private static Integer fibonacciRecDep(Integer series, Map<Integer, Integer> prevRecord)
	{
		Integer retVal = 0;

		if (prevRecord.get(series) != null )
		{
			return prevRecord.get(series);
		}
		
		if ((series == 0) || (series == 1))
		{
			retVal = series;
		}
		else
		{
			retVal = fibonacciRecDep(series - 2, prevRecord) + fibonacciRecDep(series - 1, prevRecord);
		}

		prevRecord.put(series, retVal);
		return retVal;
	}

	private static List<Integer> fibonacciDP(int series)
	{
		Map<Integer, Integer> record = new HashMap<>();
        fibonacciRecDep(series - 1, record);
        
        List<Integer> list = new ArrayList<>(record.values());
        return list;
	}
	public static void main(String[] args)
	{
		List<Integer> fibonacci = fibonacciIterative(20);
		System.out.printf("Iterative fibonacci for %d series: %s", 20, fibonacci.toString());
		
		fibonacci = fibonacciRecursive(20);
		System.out.printf("%nRecursive fibonacci for %d series: %s", 20, fibonacci.toString());

		fibonacci = fibonacciLambda(20);
		System.out.printf("%nLambda Stream fibonacci for %d series: %s %n", 20, fibonacci.toString());
		
		fibonacci = fibonacciDP(20);
		System.out.printf("%nDP fibonacci for %d series: %s", 20, fibonacci.toString());
	}
}
