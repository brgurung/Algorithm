import java.security.SecureRandom;
import java.util.stream.Collectors;

public class TestLambdaMethodReference {

	public static void main(String[] args)
	{
		SecureRandom randomNum = new SecureRandom();
		
		System.out.println("Random numbers: ");
		randomNum.ints(10, 1, 7).forEach(System.out::println);
		//randomNum.ints(10, 1, 7).forEach(x -> System.out.println(x));
		
		String numbers = randomNum.ints(10, 1, 7).mapToObj(String::valueOf).collect(Collectors.joining(" "));
		System.out.println("String: " + numbers);
	}
}


