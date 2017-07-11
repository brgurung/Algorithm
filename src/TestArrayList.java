import java.util.*;

public class TestArrayList {

	public static void main(String[] args)
	{
		ArrayList<String> strList = new ArrayList();
		
		strList.add("Bikas");
		strList.add("Seema");
		String[] strArray = {"Poquito", "Neil", "Baba", "Aama"};
		
		System.out.println(Arrays.toString(strArray));
        List<String> basicList = Arrays.asList(strArray);
        System.out.println("Basic List: " + basicList);
		//add whole str
		strList.addAll(basicList);

		System.out.println("After adding basic list: " + strList.toString());
		strList.add(1, "Bijay");
		strList.remove("Poquito");
		System.out.println("Add Bijay and remove Poqui:" + strList.toString());
	
		System.out.println("At index 2: " + strList.get(2));;
		
		
		strList.clear();
		System.out.println("After clear: " + strList.toString());
		
		
	}
}
