
public class TestInteger {
	public static void main(String[] args)
	{
		Integer i = 32;
		Integer[] j = {1,2,3};
		Integer k = new Integer(42);
		int o = k;
		String s = "42";

		int l = Integer.valueOf(42);
		
		int m = i.intValue();
		
		int n = Integer.valueOf("22");
		System.out.println(n);
		
		n = Integer.parseInt(s);
		System.out.println(n);
		
		//int p = Integer.parseInt("hello"); - gives NumberFormatException
	}

}
