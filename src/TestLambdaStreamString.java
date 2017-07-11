import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class TestLambdaStreamString {

	public static void main(String[] args)
	{
		String[] color = {"Red", "Blue", "orange", "yellow", "white", "Magenta", "green"};
		
		Arrays.stream(color).forEach(System.out::println);
		
		// List of strings in uppercase
		List<String> upperStr = Arrays.stream(color)
									  .map(String::toUpperCase)
									  .collect(Collectors.toList());
		System.out.println("In uppercase: " + upperStr);
		
		// sort in ascending order
		System.out.println("Ascending order list: " + upperStr.stream()
															  .filter(value -> value.compareToIgnoreCase("n") < 0)
															  .sorted(String.CASE_INSENSITIVE_ORDER)
															  .collect(Collectors.toList()));
		
		// sort in descending order
		System.out.println("Descending order list: " + upperStr.stream()
															  .filter(value -> value.compareToIgnoreCase("n") < 0)
															  .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
															  .collect(Collectors.toList()));

	}
}
