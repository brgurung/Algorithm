import java.util.List;
import java.util.Collections;
import java.util.Arrays;

public class TestCollections {
	
	public static void main(String[] args)
	{
		String[] face = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

		List<String> faceList = Arrays.asList(face);

		System.out.println("Input list: " + faceList);

		// Ascending order sort
        Collections.sort(faceList);
        System.out.println("Ascending order sort: " + faceList);

        // Descending order sort
        Collections.sort(faceList, Collections.reverseOrder());
        System.out.println("Descending order sort: " + faceList);
        
		// Fill
		
		// frequency
		System.out.println("Frequency of Six: " + Collections.frequency(faceList, "Six"));
		// search
		
		// reverse
		
		// disjoint
		
		// max and min
		System.out.println("Max: " + Collections.max(faceList));
		System.out.println("Min: " + Collections.min(faceList));
		// copy
		
		// shuffle
	}

}
