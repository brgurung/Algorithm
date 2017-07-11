import java.io.FileReader;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;

public class QuickSort {
	
	private static List<Integer> getInputList()
	{
		List<Integer> inputList = null;

		Path filePath = Paths.get("D:\\Bikas\\Java\\Workspace\\intlist.txt");
		try (BufferedReader inputStream = Files.newBufferedReader(filePath))
		{
			inputList = inputStream.lines().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
		}
		catch (IOException e)
		{
			// handle IOException
		}
		
		return inputList;
	}

	
	private static int doPartition(List<Integer> input, int leftIndex, int rightIndex, int pivot)
	{
		if (leftIndex >= rightIndex)
		{
			return 0;
		}
		
		while (true)
		{
			while((leftIndex < rightIndex) && (input.get(leftIndex) < pivot))
			{
				leftIndex++;
			}
			
			while((rightIndex > leftIndex) && (input.get(rightIndex) > pivot))
			{
				rightIndex--;
			}
			
			if (leftIndex < rightIndex)
			{
				if (input.get(leftIndex) == input.get(rightIndex))
				{
					rightIndex--;
				}
				else
				{
					Integer temp = input.get(leftIndex);
					input.set(leftIndex, input.get(rightIndex));
					input.set(rightIndex, temp);
				}
				
			}
			else
			{
				break;
			}
		}
		
		return rightIndex;
	}

	private static void doQuickSort(List<Integer> input, int leftIndex, int rightIndex)
	{
		// base case
		if (leftIndex >= rightIndex)
		{
			return;
		}
		
		// main body
		int pivot = input.get((leftIndex + (rightIndex - leftIndex) / 2));
		int partitionIndex = doPartition(input, leftIndex, rightIndex, pivot);
		doQuickSort(input, leftIndex, partitionIndex - 1);
		doQuickSort(input, partitionIndex + 1, rightIndex);
	}
	
	private static void quickSort(List<Integer> input)
	{
	    if ((input == null) || (input.size() <= 1))
	    	return;
	    
	    doQuickSort(input, 0, input.size() - 1);
	}

	public static void main(String[] args)
	{
		List<Integer> input = getInputList();

		System.out.println("Input List: " + input);
		quickSort(input);
		System.out.println("After sorting: " + input);
	}
}
