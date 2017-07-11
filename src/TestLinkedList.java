import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class TestLinkedList {

	public static void main(String[] args)
	{
	    String[] colorArray = {"Red", "Green", "Blue", "Orange"};
	    List<String> colorList1 = new LinkedList<>();
	    
	    for(String color : colorArray)
	    {
	    	colorList1.add(color);
	    }
	
	    String[] colorArray2 = {"Yellow", "Black", "White"};
	    List<String> colorList2 = new LinkedList<>();
	    
	    for(String color : colorArray2)
	    {
	    	colorList2.add(color);
	    }
	   
	    // add list 2 to list 1
	    colorList1.addAll(colorList2);
	    printList(colorList1);
	    
	    // change each element of the list to uppercase
	    toUpperCase(colorList1);
	    
	    // remove element
	    removeElements(colorList1, 2, 4);
	    printList(colorList1);
	    
	    System.out.print("Printing in reverse: ");
	    printListReverse(colorList1);
	    
	}

	private static void removeElements(List<String> strList, int start, int end)
	{
		// best way to remove sublist
		strList.subList(start, end).clear();
	}
	
	private static void toUpperCase(List<String> strList)
	{
		ListIterator<String> iter = strList.listIterator();
		
		while (iter.hasNext())
		{
			String color = iter.next();
			iter.set(color.toUpperCase());
		}
	}
	static void printList(List<String> colorList)
	{
		for (String color : colorList)
		{
			System.out.printf("%s ", color);
		}
		System.out.println();
	}

	static void printListReverse(List<String> colorList)
	{
		// get list iterator starting at last element
		ListIterator<String> iter = colorList.listIterator(colorList.size());
		
		while(iter.hasPrevious())
		{
			System.out.printf("%s ", iter.previous());
		}
	}

}
