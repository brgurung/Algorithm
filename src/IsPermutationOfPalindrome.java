// Method to check if given string is permutation of palindrome

import java.util.HashMap;
import java.util.Set;


public class IsPermutationOfPalindrome {
	
	private static void createPalMap(HashMap<Character, Integer> palMap, String inputStr)
	{
		for (int i = 0; i < inputStr.length(); i++)
		{
			Character c = inputStr.charAt(i);
			
			if (palMap.containsKey(c) == true)
			{
				int curValue = palMap.get(c);
				palMap.put(c, ++curValue);
			}
			else
			{
				palMap.put(c, 1);
			}
		}
	}

	private static boolean isPermutationOfPalindrome(String inputStr)
	{
		if ((inputStr == null) || (inputStr.length() == 0))
			return false;
		
		HashMap<Character, Integer> palMap = new HashMap<>();
        createPalMap(palMap, inputStr);
        
        Set<Character> palSet = palMap.keySet();
    	int oddValueCountLimit = 0;

    	if (inputStr.length() % 2 != 0)
    	{
    		oddValueCountLimit = 1;
    	}     

    	for(Character c : palSet)
        {
    		int curValue = palMap.get(c);
    		//System.out.printf("%c CurValue %d %n", c, curValue);

    		if ((curValue %2) != 0)
    		{
    			if (oddValueCountLimit == 0)
    			{
    				return false;
    			}
    			
    			oddValueCountLimit--;
    		}
        }
	
    	return true;
	}

	
	public static void main(String[] args)
	{
		System.out.println("Is Permutation - input null: " + isPermutationOfPalindrome(null));
		
		System.out.println("Is Permutation - input empty: " + isPermutationOfPalindrome(""));
		
		System.out.println("Is Permutation - input abab: " + isPermutationOfPalindrome("abab"));
		
		System.out.println("Is Permutation - input aaaaa: " + isPermutationOfPalindrome("aaaaa"));
		
		System.out.println("Is Permutation - input abcabca: " + isPermutationOfPalindrome("abcabca"));
		
		
	}
}
