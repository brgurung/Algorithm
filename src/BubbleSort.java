import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> {
	ArrayList<T> sortList;
	
	public BubbleSort(ArrayList<T> inputList)
	{
		this.sortList = inputList;
	}

	public void sort()
	{
		int i = 0;
		int j = 0;
		int N = sortList.size();
		
		if (N == 0)
		{
			System.err.println("List is empty!");
			return;
		}
		
		for (i = 0; i < N - 1; i++)
		{
			for (j = 0; j < N - i - 1; j++)
			{
				T indexJ = sortList.get(j);
				T indexJPlus1 = sortList.get(j+1);
				if (indexJ.compareTo(indexJPlus1) > 0)
				{
					T temp = indexJ;
					sortList.set(j, indexJPlus1);
					sortList.set(j+1, temp);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		String[] strArray = {"Bikas", "Bakas", "Seema", "Neil", "Aama", "Baba"};
		
		// How to convert array of string to ArrayList
		ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strArray));
		
		System.out.println("Input List: " + strList.toString());
		
		BubbleSort<String> sortAlgo = new BubbleSort<String>(strList);
		
		sortAlgo.sort();
		
		System.out.println("After running Bubblesort: " + strList.toString());
		
		Integer[] intArray = {2, 5, 1, 3, 7, 6};
		
		ArrayList<Integer> intList = new ArrayList<Integer>(Arrays.asList(intArray));
		System.out.println("Input List: " + intList.toString());
		
		BubbleSort<Integer> sortInt = new BubbleSort<>(intList);
		
		sortInt.sort();
		System.out.println("After running Bubblesort: " + intList.toString());
	}
}
