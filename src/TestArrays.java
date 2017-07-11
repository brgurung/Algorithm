import java.util.Arrays;

public class TestArrays {

	public static void main(String[] args)
	{
		double[] d = {1.0, 4.0, 2.9, 2.7, 3.6, 1.5, 2.8};
		String[] s = {"zebra", "ball", "orange", "chocolate", "milk", "candy"};
		
		Arrays.sort(d);
		int index = Arrays.binarySearch(d, 2.8);
		for(double i:d)
		{
			System.out.println(i);
		}
		System.out.println("Searched index: " + index);
		
		Arrays.sort(s);
		for(String ss:s)
		{
		    System.out.println(ss);
		}

		double[] e = new double[5];
		Arrays.fill(e, 0.0);
		System.out.println(Arrays.toString(e));
		
		System.arraycopy(d, 0, e, 0, e.length);
		System.out.println(Arrays.toString(e));
		
		System.out.println(Arrays.toString(s));
		
		System.out.println(e.equals(d));
		
		double[] f = Arrays.copyOf(e, 10);
		System.out.println(Arrays.toString(f));
		
	}
}
