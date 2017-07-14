// PowerSet: all the subsets of a set

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {

	private static List<List<Integer>> powerSet(List<Integer> superSet, int index)
	{
		if (superSet == null)
		{
			return null;
		}
		
		if (index < 0)
		{
			List<Integer> newSet = new ArrayList<>();
			List<List<Integer>> newSuperList = new ArrayList<>();
			newSuperList.add(newSet);
			return newSuperList;
		}
		
		List<List<Integer>> setList = powerSet(superSet, index - 1);
		
		List<List<Integer>> subList = new ArrayList<>();

		for( List<Integer> list : setList)
		{
			List<Integer> newSet = new ArrayList<>(list);		
			newSet.add(superSet.get(index));
			subList.add(newSet);
		}
		
		setList.addAll(subList);
		
		return setList;
	}
	
	
	public static void main(String[] args)
	{
		List<Integer> inputSet = Arrays.asList(1, 2, 3, 4);
		
		List<List<Integer>> subSets = powerSet(inputSet, inputSet.size() - 1);
		
		subSets.stream().forEach(System.out::println);
	}
}
