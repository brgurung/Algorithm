// Given n boxes of height h, width w and depth d, find maximum height
// that can be reached by stacking one box on top of others.
// Criteria: Box B1 can only be stacked on top of Box B2 if B1.height < B2.height && B1.width < B2.width && B1.
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

public class StackOfBoxes {
	
	private class Box
	{
		int height;
		int width;
		int depth;
		
		Box(int height, int width, int depth)
		{
			this.height = height;
			this.width = width;
			this.depth = depth;
		}
		
		boolean canBeOnTopOf(Box b)
		{
			if ((height < b.height) && (width < b.width) && (depth < b.depth))
			{
				return true;
			}
			
			return false;
		}
	}
	
	class BoxComparator implements Comparator<Box>
	{
		public int compare(Box b1, Box b2)
		{
			return (b2.height - b1.height);
		}
	}
	
	
	int stackOfBoxesUtil(List<Box> boxList, int index, Box prevBox, int[] boxMap)
	{
		if (index == boxList.size())
		{
			return 0;
		}
		
		int takeHeight = 0;
		int doNotTakeHeight = 0;
		
		Box curBox = boxList.get(index);
		
		if ((prevBox == null) || (curBox.canBeOnTopOf(prevBox) == true))
		{
			if (boxMap[index] == 0)
			{
				boxMap[index] = stackOfBoxesUtil(boxList, index + 1, curBox, boxMap);
				boxMap[index] += curBox.height;
			}
			
			takeHeight = boxMap[index];
		}
		
		doNotTakeHeight = stackOfBoxesUtil(boxList, index + 1, prevBox, boxMap);
		
		return Math.max(takeHeight, doNotTakeHeight);
	}
	
	int stackOfBoxes(List<Box> boxList)
	{
		if (boxList == null)
			return 0;
		
		if (boxList.size() == 1)
			return boxList.get(0).height;
		
		Collections.sort(boxList, new BoxComparator());
		
		int[] boxMap = new int[boxList.size()];
		
		return stackOfBoxesUtil(boxList, 0, null, boxMap);
	}

}
