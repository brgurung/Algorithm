import java.util.Map;
import java.util.HashMap;

public class BSTTargetSumPathCount {

	class Node
	{
		int data;
		Node left;
		Node right;
		
		Node(int data)
		{
			this.data = data;
		}
	}

	Node root;
	
	
	int totalPathWithTargetSum(Node root, int targetSum)
	{
		Map<Integer, Integer> sumMap = new HashMap<>();
		
		return totalPathWithTargetSumUtil(root, targetSum, 0, sumMap);
	}
	
	int totalPathWithTargetSumUtil(Node root, int targetSum, int runningSum, Map<Integer, Integer> sumMap)
	{
		if (root == null)
			return 0;
		
		runningSum += root.data;
		
		int sum = runningSum - targetSum;
		
		int totalPath = getPathCount(sum, sumMap);
		
		if (runningSum == targetSum)
		{
			totalPath++;
		}
		
		updatePathCount(runningSum, sumMap, 1);
		totalPath += totalPathWithTargetSumUtil(root.left, targetSum, runningSum, sumMap);
		totalPath += totalPath += totalPathWithTargetSumUtil(root.right, targetSum, runningSum, sumMap);
		updatePathCount(runningSum, sumMap, -1);
		
		return totalPath;
	}
	
	int getPathCount(int sum, Map<Integer, Integer> sumMap)
	{
		if (sumMap.containsKey(sum) == false)
		{
			return 0;
		}
		else
		{
			return sumMap.get(sum);
		}
	}
	
	void updatePathCount(int runningSum, Map<Integer, Integer> sumMap, int delta)
	{
		if (sumMap.containsKey(runningSum) == true)
		{
			int curValue = sumMap.get(runningSum);
			curValue += delta;
			if (curValue == 0)
			{
				sumMap.remove(runningSum);
			}
			else
			{
				sumMap.put(runningSum, curValue);
			}
		}
	}
}
