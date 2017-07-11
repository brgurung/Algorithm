public class KnapSack {

	private static int value[] = {1, 5, 12};
	private static int weight[] = {1, 3, 2};
	private static int limit = 4;
	private static int record[][] = new int[value.length][limit + 1];
	private static int selection[][] = new int[value.length][limit + 1];
	
	
	private static int knapSack(int index, int limit)
	{
		int result = 0;

		if (index < 0 || limit <= 0)
		{
			result = 0;
		}
		else if (record[index][limit] > 0)
		{
			result = record[index][limit];
		}
		else
		{		
			if (weight[index] > limit)
			{
				result = knapSack(index - 1, limit);
				selection[index][limit] = -1;
			}
			else
			{
				int doNotTake = knapSack(index - 1, limit);
				int take = knapSack(index - 1, limit - weight[index]) + value[index];
			
				result = Math.max(doNotTake, take);
				
				if (take > doNotTake)
				{
					selection[index][limit] = 1;
				}
				else
				{
					selection[index][limit] = -1;
				}

			}
			
			record[index][limit] = result;
		}	

		return result;
	}
	
	static void printSelection(int items, int limit)
	{
		System.out.printf("%n Selected weights: ");
		
		while (items >= 0)
		{
			if (selection[items][limit] == 1)
			{
				limit = limit - weight[items];
				System.out.printf("%d ", weight[items]);
			}

			items--;
		}
	}

	public static void main(String[] args)
	{
		System.out.println("Maximum value is: " +  knapSack(value.length - 1, limit));
	
		printSelection(value.length - 1, limit);
		
	}
}
