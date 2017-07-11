import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class InsertionSort {

	private static List<String> getStrInput() throws IOException
	{
		List<String> inputList = null;

		try(BufferedReader inputStream = new BufferedReader(new FileReader("D:\\Bikas\\Java\\Workspace\\stringList.txt")))
		{
			inputList = inputStream.lines().map(x -> x.toUpperCase()).collect(Collectors.toList());
			System.out.println("Input String: ");
			inputList.stream().forEach(System.out::println);
     	}
		catch (IOException e)
		{
			// do something
			System.out.println("IOException! type: %s" + e);
		}

		
		return inputList;
	}

	
	private static void insertionSort(List<String> input)
	{
		int inputSize = input.size();
		for (int i = 1; i < inputSize; i++)
		{
			int j = i;
			String compStr  = input.get(i);

			while ((j > 0) && (input.get(j - 1).compareTo(compStr) > 0))
			{
			  	input.set(j, input.get(j - 1));
			  	j--;
			}
			input.set(j, compStr);
/*//Option 1
			while( j >= 0)
			{
				System.out.printf("%n At i: %s j: %s %n", input.get(i), input.get(j));
				if (input.get(j).compareTo(input.get(i)) <= 0)
				{
					String temp = input.get(i);
					input.remove(i);
					input.add(j + 1, temp);
					break;
				}
				else
				{
					if (j == 0)
					{
						String temp = input.get(i);
						input.remove(i);
						input.add(j, temp);
						break;
					}
				}
				
				j = j - 1;
			}
*/			
/* Option 2
			int insertIndex = i;
			while (j >= 0)
			{
				//System.out.printf("%n At i: %s j: %s %n", input.get(i), input.get(j));
				if (input.get(j).compareTo(input.get(i)) <= 0)
				{
					break;
				}
				else
				{
					insertIndex = j;
				}
				
				j = j - 1;
			}

			if (insertIndex != i)
			{
				String temp = input.get(i);
				input.remove(i);
				input.add(insertIndex, temp);
			}
*/
			//System.out.println(input);
		}
		
	}

	public static void main(String[] args)
	{
		try
		{
			List<String> input = getStrInput();
			
			insertionSort(input);
			
			System.out.println("After Sorting: " + input.toString());
		}
		catch (IOException e)
		{
			// do something
		}
	}
}
