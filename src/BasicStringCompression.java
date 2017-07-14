// basic compression using count of repeated chars
// If compressed string length cannot be less than original, return original

public class BasicStringCompression {

	
	private static String basicCompressionWithExtraBuffer(String inputStr)
	{
		if (inputStr == null)
			return null;
		
		if (inputStr.length() < 2)
			return inputStr;
		
		StringBuilder outStr = new StringBuilder();
		
		int charCount = 1;
		
		for(int i = 0; i < inputStr.length(); i++)
		{
			if ((i != inputStr.length() - 1) && (inputStr.charAt(i)) == inputStr.charAt(i + 1))
			{
				charCount++;
			}
			else
			{
				outStr.append(inputStr.charAt(i));
				outStr.append(charCount);
				charCount = 1;
			}
		}
		
		if(outStr.length() > inputStr.length())
		{
			return inputStr;
		}
		else
		{
			return outStr.toString();
		}
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("Basic compression of aa:" + basicCompressionWithExtraBuffer("aa"));
		System.out.println("Basic compression of aabcddeaae:" + basicCompressionWithExtraBuffer("aabcddeaae"));
		System.out.println("Basic compression of aaaaa:" + basicCompressionWithExtraBuffer("aaaaa"));
		System.out.println("Basic compression of AABaaA:" + basicCompressionWithExtraBuffer("AABaaaa"));
	}
}
