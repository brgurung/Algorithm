import java.util.Map;
import java.util.HashMap;

public class StringPermutation {

	void permutation(String str)
	{
		if (str.length() <= 1)
		{
			System.out.println("Permutaion: " + str);
		}
		else
		{
			Map<String, Integer> record = new HashMap<>();
			System.out.println("Recursion with duplicates: ");
			permutation("", str);
			
			System.out.println("Recursion without duplicates: ");
			permutation("", str, record);
		}
	}
	

	void permutation(String prefix, String rem, Map<String, Integer> record)
	{
		if (rem.length()  == 0)
		{
			String finalPerm = prefix + rem;
			if (record.get(finalPerm) == null)
			{
				System.out.println(finalPerm);
				record.put(finalPerm, 1);
			}
		}
		else
		{
			for (int i = 0; i < rem.length(); i++)
			{
				String newPrefix = prefix + String.valueOf(rem.charAt(i));
				String newRem = rem.substring(0, i) + rem.substring(i + 1);
				permutation(newPrefix, newRem, record);
			}
		}
	}

	void permutation(String prefix, String rem)
	{
		if (rem.length() == 0)
		{
			System.out.println(prefix + rem);
		}
		else
		{
			for (int i = 0; i < rem.length(); i++)
			{
				String newPrefix = prefix + String.valueOf(rem.charAt(i));
				String newRem = rem.substring(0, i) + rem.substring(i + 1);
				permutation(newPrefix, newRem);
			}
		}
	}
	
	public static void main(String[] args)
	{
		StringPermutation permObj = new StringPermutation();
		permObj.permutation("abb");
		System.out.println("Returned from recursion!");
	}
}
