// Robot sitting upper left corner of r rows and c col
// Robot can move right and down
// certain cells off limit
// Find path from top left to bottom right


public class RobotPath {

	public static int findPathUtil(int[][] T, int row, int col)
	{
		if ((T == null) || (row < 0) || (col < 0))
		{
			return 0;
		}
		
		if ((row == 0) && (col == 0))
		{
			return 1;
		}
		
		if (T[row][col] == -1)
		{
			return 0;
		}
		
		if (T[row][col] == 1)
		{
			return 1;
		}
		
		int rightPath = findPath(T, row, col - 1);
		int downPath = findPath(T, row - 1, col);
		
		if ((rightPath == 0) && (downPath == 0))
		{
			return 0;
		}
		
		if (rightPath == 1)
		{
			T[row][col - 1] = 1;
		}
		
		if (downPath == 1)
		{
			T[row - 1][col] = 1;
		}
		
		return 1;
	}
	
	public static int findPath(int[][] T, int row, int col)
	{
		int result = findPathUtil(T, row, col);
		if (result == 1)
		{
			T[row][col] = 1;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		/*int[][] input =
			{{0, 0, 0},
			 {0, -1, 0},
			 {0, 0, 0}
			};
		*/
		int[][] input =
			{
				{0, 0, -1, 0},
				{-1, 0, 0, 0},
				{0, 0, -1, 0},
				{0, 0, 0, 0}
			};
		
		findPath(input, input.length - 1, input[0].length - 1);
		
		for (int[] x: input)
		{
			for (int y : x)
			{
				System.out.print(y + "  ");
			}
			System.out.println();
		}
		
		
	}
	
}
