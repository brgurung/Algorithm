// Implement multiplication without using '*' operator
// Can use subtract, addition, bit shift
// Give +ve integers

public class MultiplyWithoutOperator {

	private static int multiply(int M, int N)
	{
		if ((M <= 0) || (N <= 0))
		{
			return 0;
		}
		
		int bigger = (M > N) ? M : N;
		int smaller = (M <= N) ? M : N;
		
		return multiplyUtil(smaller, bigger);
	}
	
	private static int multiplyUtil(int M, int N)
	{
		if (M == 1)
		{
			return N;
		}
		
		int remainder = 0;
		
		if ((M & 1) == 1)
		{
			M = M - 1;
			remainder = N;
		}
		
		int product = multiplyUtil(M >> 1, N);
		
		product = product + product + remainder;
		
		return product;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("Multiply 2x2: " + multiply(2, 2));
		System.out.println("Multiply 9x5: " + multiply(9, 5));
		System.out.println("Multiply 2x0: " + multiply(2, 0));
		System.out.println("Multiply 2x1: " + multiply(2, 1));
	}
}
