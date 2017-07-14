
public class URLify {

	private static int getTotalSpaces(String inputStr, int trueLength)
	{
		int spaceCount = 0;
		
		for(int i = 0; i < trueLength; i++)
		{
			if (inputStr.charAt(i) == ' ')
			{
				spaceCount++;
			}
		}
		
		return spaceCount;
	}

	private static String urlify(String inputStr, int trueLength)
	{
		if ((inputStr == null) || (trueLength == 0))
		{
			return null;
		}

	
		int spaceCount = getTotalSpaces(inputStr, trueLength);
		System.out.printf("%nTotal white spaces: %d%n", spaceCount);
		
		char[] charArray = new char[trueLength + 2 * spaceCount];
		System.out.printf("Input string length: %d Char Array size: %d%n", trueLength, charArray.length);
		
		inputStr.getChars(0, trueLength, charArray, 0);
		
		int i = trueLength - 1;
		int j = charArray.length - 1;

		while (i >= 0)
		{
			if (charArray[i] == ' ')
			{
				charArray[j] = '0';
				charArray[--j] = '2';
				charArray[--j] = '%';
			}
			else
			{
				charArray[j] = charArray[i];
			}
			i--;
			j--;
		}
		
		return String.valueOf(charArray);
	}



	public static void main(String[] args)
	{
		String str = "Mr John Smith";
		
		System.out.println("URLify -Mr John Smith: " + urlify(str, str.length()));
		
		str = " Mr J A Smith ";
		System.out.println("URLify - Mr J A Smith " + urlify(str, str.length()));

	}
}


