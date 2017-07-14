// 3 types of eidt - inert, replace, remove
// Two input strings - Check if they are edits away

import java.util.Map;
import java.util.HashMap;

public class IsOneEditAway {

	private static void createMap(Map<Character, Integer> charMap, String inputStr)
	{
		for (int i = 0; i < inputStr.length(); i++)
		{
			Character c = inputStr.charAt(i);
			
			if (charMap.containsKey(c) == true)
			{
				int curValue = charMap.get(c);
				charMap.put(c, ++curValue);
			}
			else
			{
				charMap.put(c, 1);
			}
		}
	}

	private static boolean isOneOrZeroEditAway(Map<Character, Integer> charMap, String str)
	{
		int matchCount = 0;
		
		for (int i = 0; i < str.length(); i++)
		{
			Character c = str.charAt(i);
			if (charMap.containsKey(c) == true)
			{
				int curValue = charMap.get(c);
				charMap.put(c, --curValue);
				matchCount++;
			}
		}

	
		if (matchCount >= (str.length() - 1))
		{
			return true;
		}

		return false;
	}

	private static boolean isOneEditAway(String inputStr, String editedStr)
	{
		if ((inputStr == null) || (editedStr == null))
		{
			return false;
		}
		
		int inputLength = inputStr.length();
		int editedLength = editedStr.length();
		
		if ((inputLength == 0) || (editedLength == 0))
		{
			return false;
		}
		
		int lengthDiff = Math.abs(inputLength - editedLength);
		
		if (lengthDiff > 1)
		{
			return false;
		}
		
		Map<Character, Integer> charMap = new HashMap<>();
		String iterString;

		if (inputLength >= editedLength)
		{
			createMap(charMap, inputStr);
			iterString = editedStr;
		}
		else
		{
			createMap(charMap, editedStr);
			iterString = inputStr;
		}
		
		
		boolean result = isOneOrZeroEditAway(charMap, iterString);
		
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Is One Edit Away - input null: " + isOneEditAway(null, null));
		
		System.out.println("Is One Edit Away - input empty, abce: " + isOneEditAway("", "abce"));
		
		System.out.println("Is One Edit Away - input ple, pale: " + isOneEditAway("ple", "pale"));
		
		System.out.println("Is One Edit Away - input length mimsatch: " + isOneEditAway("abcd", "abcdef"));
		
		System.out.println("Is One Edit Away - input pale, ple: " + isOneEditAway("pale", "ple"));
		
		System.out.println("Is One Edit Away - input pale, bale: " + isOneEditAway("pale", "bale"));
		
		System.out.println("Is One Edit Away - input pale, bake: " + isOneEditAway("pale", "bake"));
	}
}
