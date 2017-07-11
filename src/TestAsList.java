import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class TestAsList
{
	public static void main(String[] args)
	{
		String[] strArray = {"Apple", "Orange", "Banana", "Pineapple"};
		
		List<String> strList = Arrays.asList(strArray);
		// List<String> strList = Arrays.asList("Apple", "Orange", "Banana", "Pineapple");
		
		//strList.add("Coconut"); // gives UnsupportedException
		strList.set(1, "Tangerine");

		Iterator<String> iter = strList.iterator();
		
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		LinkedList<String> strLinkedList = new LinkedList<>(Arrays.asList(strArray));
		strLinkedList.add("Coconut");
		strLinkedList.addFirst("Pineapple");
		strLinkedList.add(2, "Papaya");
		strLinkedList.addLast("Melon");
		
		//strArray = strLinkedList.toArray();  // gives compilation error
		strArray = strLinkedList.toArray(new String[strLinkedList.size()]);
		System.out.println(Arrays.toString(strArray));
	}
}
