
public class PrimitiveType {

	public static void main(String[] args)
	{
		boolean isFalse = false;
		int x = 2;
		short y = 3;
		byte b = 1;
		char c = 'a';
		char c1 = 46;
		double d = 2.0;
		//float f = 3.0; - compiler error. type mismatch. should be 3.0f
		
		//y = x;     - compiler error: type mismatch
		System.out.println(x + " " + y);
		System.out.println(c + " " + c1);
		
		//c1 = b;
		//b = c1;
		c1 = (char)b;
		
		int num[];
		int[] num1;
		//int num2[20]; - not valid
		int[] num3 = {1, 2, 3};
		int[] num4 = new int[3];
		int num5[] = new int[5];

		//num3 = null; - allowed
		num3[0] = new Integer(3);
		//num3[0] =  new Double(3.1); //- not allowed
		num3[0] = (int)3.1;
	}
}
