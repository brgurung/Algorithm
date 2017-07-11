import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.function.Supplier;

public class MergeSort {

	
	private static void merge(List<Integer> mergedList, List<Integer> leftList, List<Integer> rightList)
	{
		int i = 0, j = 0, k = 0;
		
		// get copy of left and right
		List<Integer> left = new ArrayList<>(leftList);
		List<Integer> right = new ArrayList<>(rightList);

		while ((i < left.size()) && (j < right.size()))
		{
			if (left.get(i) < right.get(j))
			{
				mergedList.set(k, left.get(i));
				i++;
			}
			else
			{
				mergedList.set(k, right.get(j));
				j++;
			}
			k++;
		}
		
		while (i < left.size())
		{
			mergedList.set(k, left.get(i));
			i++;
			k++;
		}
		
		while (j < right.size())
		{
			mergedList.set(k, right.get(j));
			j++;
			k++;
		}
		
		//System.out.println(mergedList);
	}

	private static void mergeSort(List<Integer> input)
	{
		if (input.size() <= 1)
		{
			return;
		}
		else
		{
			int midPoint = input.size() / 2;
			List<Integer> leftList = input.subList(0, midPoint);
			List<Integer> rightList = input.subList(midPoint, input.size());
			mergeSort(leftList);
			//System.out.println("Left side: " + leftList);
			mergeSort(rightList);
			//System.out.println("Right side: " + rightList);


			merge(input, leftList, rightList);
		}
	}

	private static List<Integer> getInput()
	{
		List<Integer> readList = null;

		try(BufferedReader inputStream = new BufferedReader(new FileReader("D:\\Bikas\\Java\\Workspace\\intlist.txt")))
       	{
			Supplier<List<Integer>> supplier = ArrayList::new;
       		//readList = inputStream.lines().map(x -> Integer.valueOf(x)).collect(Collectors.toList());
			readList = inputStream.lines().map(x -> Integer.valueOf(x)).collect(Collectors.toCollection(supplier));
       	}
       	catch (IOException e)
       	{
       		// do something
       	}
		
		return readList;
	}
	
	public static void main(String[] args)
	{
		List<Integer> input = getInput();
		
		System.out.println("Input List: " + input);
		System.out.println("Size of input list: " + input.size());
		
		//System.out.println("Size of subList 0->5: " + input.subList(0, 6).size());
		//input.subList(0, 6).set(1, 2);
		//System.out.println("Input List after changing subList: " + input);
		
		mergeSort(input);
		System.out.println("After sorting: " + input);
		
	}
}
