import java.util.Arrays;

public class MatrixRotation {

	private static void matrixRotationUtil(int[][] matrix, int offset, int N)
	{
		if (N <= 1)
		{
			return;
		}
		System.out.printf("%nOffset: %d N: %d%n", offset, N);
		// check if it's NxN matrix

		for (int i = 0; i < N - 1; i++)
		{
			int keyIndex = N -i - 1 + offset;
			int j = i + offset;
			int startIndex = offset;
			int endIndex = N + offset - 1;
			
			int temp = matrix[startIndex][j];

			matrix[startIndex][j] = matrix[keyIndex][startIndex];
			matrix[keyIndex][startIndex] = matrix[endIndex][keyIndex];
			matrix[endIndex][keyIndex] = matrix[j][endIndex];
			matrix[j][endIndex] = temp;
		}
	
		matrixRotationUtil(matrix, offset + 1, N - 2);	
	}

	/*
	private static void matrixRotation90Degree(int[][] matrix)
	{
		if ((matrix == null) || (matrix.length == 0))
		{
			return;
		}
		
		// check if it's NxN matrix

		int N = matrix.length;

		for (int i = 0; i < N - 1; i++)
		{
			int keyIndex = N -i - 1;
			int temp = matrix[0][i];
			matrix[0][i] = matrix[keyIndex][0];
			matrix[keyIndex][0] = matrix[N - 1][keyIndex];
			matrix[N - 1][keyIndex] = matrix[i][N - 1];
			matrix[i][N - 1] = temp;
		}
		
	}
	*/
	private static void matrixRotation90Degree(int[][] matrix)
	{
		if ((matrix == null) || (matrix.length == 0))
		{
			return;
		}
		
		// check if it's NxN matrix

		matrixRotationUtil(matrix, 0, matrix.length);
		
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,2,3, 4, 5}, {7,7,7,7, 7}, {8,8,8,8, 8}, {9,9,9,9,9}, {10, 10, 10, 10, 10}};
		
		System.out.printf("Input %d x %d Matrix: %n", matrix[0].length, matrix[0].length);
		Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);

		matrixRotation90Degree(matrix);
		
		System.out.println("After 90 degree rotation: ");
		Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
	}
}
