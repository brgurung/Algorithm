// Given an array of integers arr, you’re asked to calculate for each index i
// the product of all integers except the integer at that index (i.e. except arr[i]). 
// Implement a function arrayOfArrayProducts that takes an array of integers and returns 
// an array of the products.
// Solve without using division and analyze your solution’s time and space complexities.

public class ArrayOfProducts {
 
	  static int[] arrayOfArrayProducts(int[] arr) {
	    // your code goes here
	    if (arr == null)
	    {
	      return null;
	    }
	    
	    if (arr.length <= 1)
	    {
	      return new int[0];
	    }

	    int[] finalList = new int[arr.length];

	    arrayProductsUtil(arr, finalList, 0, 1);
	    
	    return finalList;
	  }
	  
	  static int arrayProductsUtil(int[] arr, int[] output, int index, int product)
	  {
	    if (index == (arr.length - 1))
	    {
	      output[index] = product;
	      return arr[index];
	    }
	    
	    int multiplier = arrayProductsUtil(arr, output, index + 1, product * arr[index]);
	    output[index] = multiplier * product;
	    
	    return (multiplier * arr[index]);
	  }

	  public static void main(String[] args) {

	  }


	  static int[] arrayOfArraySimpler(int[] arr)
	  {
		  if (arr == null)
		  {
			  return null;
		  }
		  
		  int arrLength = arr.length;
		  
		  if (arrLength <= 1)
		  {
			  return new int[0];
		  }
		  
		  int product = 1;
		  int[] finalList = new int[arrLength];
		  for (int i = 0; i < arrLength; i++)
		  {
			  finalList[i] = product;
			  product *= arr[i];
		  }
		  
		  product = 1;
		  for (int i = arrLength - 1; i >= 0; i--)
		  {
			  finalList[i] *= product;
			  product *= arr[i]; 
		  }
		  
		  return finalList;
	  }
}
