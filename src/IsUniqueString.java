import java.util.HashSet;

public class IsUniqueString {

	boolean IsUniqueWithHash(String inputStr)
	{
		if ((inputStr == null) || inputStr.isEmpty())
		{
			return true;
		}
		
		int strLength = inputStr.length();
		HashSet<Character> cSet = new HashSet<>();
		
		for(int i = 0; i < strLength; i++)
		{
			Character c = Character.valueOf(inputStr.charAt(i));
			
			if(cSet.contains(c) == true)
			{
				return false;
			}
			else
			{
				cSet.add(c);
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args)
	{
		IsUniqueString isUnique = new IsUniqueString();
		
		System.out.println("Is null unique: " + isUnique.IsUniqueWithHash(null));
		
		System.out.println("Is empty string unique: " + isUnique.IsUniqueWithHash(""));
		
		System.out.println("Is abcd unique: " + isUnique.IsUniqueWithHash("abcd"));
		
		System.out.println("Is abcab unique: " + isUnique.IsUniqueWithHash("abcab"));
	}
}

