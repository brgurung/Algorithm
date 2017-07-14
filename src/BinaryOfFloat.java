
// Give binary representation of float number between 0 & 1
public class BinaryOfFloat {

	// 0.101 = 1 * (1/2) + 0 * (1/4) + 1 * (1/8)
	static String binaryOfFloat(double num)
	{
		if ((num >= 1) || (num <= 0))
		{
			return "ERROR";
		}
		
		StringBuilder binNum = new StringBuilder();
		binNum.append("0.");
		
		while (num > 0)
		{
			if (binNum.length() > 32)
			{
				return "ERROR";
			}

			double mul = num * 2;
			
			if (mul >= 1)
			{
				binNum.append("1");
				num = mul - 1;
			}
			else
			{
				binNum.append("0");
				num = mul;
			}
		}
		
		return binNum.toString();
	}



	// second way
	static String binaryOfFloatMethod2(double num)
	{
		if (num >= 1 || num <= 0)
			return "ERROR";
		
		double factor = 0.5;
		StringBuilder binNum = new StringBuilder();
		binNum.append("0.");
		
		while (num >= factor)
		{
			if (binNum.length() > 32)
			{
				return "ERROR";
			}

			if (num >= factor)
			{
				binNum.append("1");
				num -= factor;
			}
			else
			{
				binNum.append("0");
			}
			
			factor = factor / 2;
		}
		
		return binNum.toString();
		
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("Binary representation of 0.72: " + binaryOfFloat(0.72));
		System.out.println("Binary representation of 0: " + binaryOfFloat(0));
		System.out.println("Binary representation of 1: " + binaryOfFloat(1));
		System.out.println("Binary representation of 0.75: " + binaryOfFloat(0.75));
		System.out.println("Binary representation of 0.75: " + binaryOfFloat(0.875));
		
		System.out.println("Binary representation of 0.72: " + binaryOfFloatMethod2(0.72));
		System.out.println("Binary representation of 0: " + binaryOfFloatMethod2(0));
		System.out.println("Binary representation of 1: " + binaryOfFloatMethod2(1));
		System.out.println("Binary representation of 0.75: " + binaryOfFloatMethod2(0.75));
		System.out.println("Binary representation of 0.75: " + binaryOfFloatMethod2(0.875));
	}
}
