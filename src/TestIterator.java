
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class TestIterator {

	public static void main(String[] args)
	{
    	List<String> names = new LinkedList<String>();
    	
    	names.add("Bikas");
    	names.add("Seema");
    	names.add("Poquito");
    	names.add("Neil");
    	names.add("Baba");
    	names.add("Aama");
    	
    	System.out.println(names.size());   	
    	Iterator<String> c = names.iterator();
    	while(c.hasNext())
    	{
    		System.out.println(c.next());
    		c.remove();
    	} 	
    	System.out.println(names.size());
    	
    	TestIterator obj = new TestIterator();
    	System.out.println(obj.getClass().getName());
	}


	
	
	
}
