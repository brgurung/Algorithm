
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SelectionSort {

	
	private static void selectionSort(int[] input)
	{
		int inputSize = input.length;
		
		for (int i = 0; i < inputSize - 1; i++)
		{
			int minIndex = i;
			for (int j = i + 1; j < inputSize; j++)
			{
				if (input[minIndex] > input[j])
				{
					minIndex = j;
				}
			}
			
			if (minIndex != i)
			{
				int temp = input[minIndex];
				input[minIndex] = input[i];
				input[i] = temp;
			}
		}
	}
	
	private static int[] getIntArray() throws IOException
	{
		 List<Integer> intList = null;

		try (BufferedReader inputStream = new BufferedReader(new FileReader("D:\\Bikas\\Java\\Workspace\\intlist.txt"));)
		{
			/*
			 * 
			 intList = new ArrayList<>();
			 String readLine;
			 while ((readLine = inputStream.readLine()) != null)
			 {
				 intList.add(Integer.valueOf(readLine));
			 }
			 */
			intList = inputStream.lines().map(x -> Integer.valueOf(x)).collect(Collectors.toList());

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("Input data: " + intList);
	    return intList.stream().mapToInt(Integer::intValue).toArray();
	}

	
	public static void main(String[] args) throws IOException
	{

		int[] input = getIntArray(); // unhandled excpetion if main doesn't throw IOException

		System.out.println("Before sorting: ");
		Arrays.stream(input).forEach(x -> System.out.printf("%d ", x));
        System.out.println();

        selectionSort(input);
		
		System.out.println("After sorting: " + Arrays.toString(input));
	}
	
}
