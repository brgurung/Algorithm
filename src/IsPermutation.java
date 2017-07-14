// Find out if two strings are permutation of each other

import java.util.HashMap;



public class IsPermutation {

	private static void createMap(HashMap<Character, Integer> checkMap, String inputStr)
	{
		for (int i = 0; i < inputStr.length(); i++)
		{
			Character c = Character.valueOf(inputStr.charAt(i));
			if (checkMap.containsKey(c) == false)
			{
				checkMap.put(c, 1);
			}
			else
			{
				int curValue = checkMap.get(c);
				checkMap.put(c, curValue++);
				//checkMap.computeIfPresent(c, (key,x) -> {return (x + 1);});
			}
			
		}
	}
	
	private static boolean isPermutationWithHashMap(String str1, String str2)
	{
		if ((str1 == null) || (str2 == null))
		{
			return false;
		}
		
		if (str1.length() != str2.length())
		{
			return false;
		}
		
		HashMap<Character, Integer> checkMap = new HashMap<>();
		createMap(checkMap, str1);
		
		for(int i = 0; i < str2.length(); i++)
		{
			Character c = Character.valueOf(str2.charAt(i));
			if (checkMap.containsKey(c) == true)
			{
				int curValue = checkMap.get(c);
				checkMap.put(c, curValue--);
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}


	public static void main(String[] args)
	{
		System.out.println("Is Permutation - input null: " + isPermutationWithHashMap(null, null));
		
		System.out.println("Is Permutation - input abcd, abcc: " + isPermutationWithHashMap("abcd", "abce"));
		
		System.out.println("Is Permutation - input empty: " + isPermutationWithHashMap("", "abc"));
		
		System.out.println("Is Permutation - input length mimsatch: " + isPermutationWithHashMap("abcd", "abcde"));
		
		System.out.println("Is Permutation - input abcd, dacb: " + isPermutationWithHashMap("abcd", "dacb"));
		
	}
}
