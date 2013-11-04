package ArraysDC_Schaum;

import java.util.Arrays;

public class Array_Initialization {

	public static void main(String[] args) {
		/* Initialize the array.
		 * 
		 * double a[][] = {{1.1,2.2}, {3.3,4.4}, null, {5.5,6.6}, null};
		a[3] = new double[66]; // Manually increase the size of one single column uptill needed.
		a[3][65] = 3.14;
		System.out.println(a[3][65]+" "+a[3][1]+" "+a[3][0]);
		*/
		
		// Check if two arrays are equal.
		String [] arr1 = {"AR","AB","FD"};
		String [] arr2 = {"AR","AB","FD"};
		
		System.out.println(Arrays.equals(arr1, arr2));
		System.out.println(arr1.equals(arr2));
	}
}
