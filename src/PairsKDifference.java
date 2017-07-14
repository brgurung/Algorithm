
import java.io.*;
import java.util.*;
	
public class PairsKDifference {



	  static int[][] findPairsWithGivenDifference(int[] arr, int k) {
	    
	    if ((arr == null) || (arr.length == 0))
	    {
	      return null;
	    }

	    // your code goes here
	    Arrays.sort(arr);
	    
	    int[][] finalResult = new int[arr.length][2];
	    
	    int i = 0;
	    int resultIndex = 0;
	    for (int j = 1; j < arr.length; j++)
	    {
	      int num = arr[i] + k;
	      if (arr[j] == num)
	      {
	         finalResult[resultIndex][0] = arr[i];
	         finalResult[resultIndex][1] = num;
	         i = i + 1;
	        resultIndex++;
	      }
	      else if (arr[j] > num)
	      {
	        i = i + 1;
	        j = j - 1;
	      }
	    }
	    
	    return finalResult;
	  }

	  public static void main(String[] args) {

		  int[] input = {1, 4, -2, 7};
		  int[][] result =  findPairsWithGivenDifference(input, 3);
		  for (int i = 0; i < result.length; i ++)
		  {
			  for (int j = 0; j < 2; j++)
			  {
				  System.out.print(result[i][j] + " ");
			  }
			  System.out.println();
		  }

	  }






}
