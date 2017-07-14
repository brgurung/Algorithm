// Given integer
// You can flip only one 0 to 1
// Find length of the longest sequence of 1

public class BinaryLongestSeq {

	static int lengthOfLongestSeq(int num)
	{
		if (num == 0)
			return 1;
		
		if ((~0 ^ num) == 0)
		{
			return Integer.SIZE;
		}
		
		int maxSeq = 1;
		int curLength = 0;
		int prevLength = 0;
		
		while (num > 0)
		{
			if ((num & 1) == 1)
			{
				curLength++;
			}
			else
			{
				maxSeq = Math.max(curLength + prevLength + 1, maxSeq);
				prevLength = curLength;
				curLength = 0;
			}
			
			num >>>= 1;
			if (num == 0)
			{
				maxSeq = Math.max(curLength + prevLength, maxSeq);
			}
		}
		
		return maxSeq;
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("Max sequence in 1775: " + lengthOfLongestSeq(1775));
		
		System.out.println("Max sequence in 1: " + lengthOfLongestSeq(1));
		
		System.out.println("Max sequence in 15: " + lengthOfLongestSeq(15));
		
		System.out.println("Max sequence in 0: " + lengthOfLongestSeq(0));
	}
}
