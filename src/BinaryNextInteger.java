// Given positive integer
// Find next biggest and smallest integer with same number of 1 bits

public class BinaryNextInteger {

	static int getNextLargeInteger(int num)
	{
		if (num <= 0)
			return 0;
		
		int c0 = 0;
		int c1 = 0;
		int nextInt = num;
		
		// count the number of trailing zeroes
		while((nextInt != 0) && (nextInt & 1) == 0)
		{
			nextInt >>= 1;
			c0++;
		}
		
		// count sequence of 1s
		while((nextInt & 1) == 1)
		{
			nextInt >>= 1;
			c1++;
		}
		
		// check for numbers like 11110000 where there cannot be large numbers with same number of 1s
		if (((c1 + c0) >= Integer.SIZE) || ((c1 + c0) == 0))
		{
			return 0;
		}
		
		int p = c1 + c0;
		System.out.printf("c0: %d c1: %d %n", c0, c1);
		// set pth bit
		num = num | (1 << p);
		System.out.printf("Set pth bit: %d %n", num);
		
		// clear all bits after pth
		num = num & (~0 << p);  // or, ~((1 << p) - 1)
		System.out.printf("Clear all bits after pth: %d %n", num);

		// set c1-1 bits
		num = num | ((1 << (c1 - 1)) - 1);
		System.out.printf("Set last c1-1 bits: %d %n", num);

		return num;
	}
	
	
	static int getNextSmallInteger(int num)
	{
		if (num <= 0)
			return 0;
		
		int c0 = 0;
		int c1 = 0;
		int nextInt = num;
		
		// count the number of trailing zeroes
		while((nextInt & 1) == 1)
		{
			nextInt >>= 1;
			c0++;
		}
		
		// count sequence of 1s
		while((nextInt != 0) && (nextInt & 1) == 0)
		{
			nextInt >>= 1;
			c1++;
		}
		
		int p = c1 + c0;
		
		if (c1 == 0)
			return 0;

		// clear pth bit
		int mask = ~0 ^ (1 << p);
		num = num & mask;
		
		// set all bits after pth
		num = num | ((1 << p) - 1);
		
		// clear least significant c1 - 1 bits
		num = num ^ ((1 << (c1 - 1)) - 1);
		
		return num;		
	}

	public static void main(String[] args)
	{
	
		System.out.printf("Num: %d Largest: %d Smallest: %d %n%n%n", 7, getNextLargeInteger(7), getNextSmallInteger(7));

		System.out.printf("Num: %d Largest: %d Smallest: %d %n%n%n", 1, getNextLargeInteger(1), getNextSmallInteger(1));
		
		System.out.printf("Num: %d Largest: %d Smallest: %d %n%n%n", 476, getNextLargeInteger(476), getNextSmallInteger(476));
	}
}
