package ArraysDC_Schaum;

import java.util.Date;
import java.util.Arrays;

public class Arrays1_FillMethod {

	public static void display(Object[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		Integer[] arr1 = new Integer[10];
		String[] arr2 = new String[10];
		
		
		Arrays.fill(arr1, 12);
		Arrays.fill(arr2, "Vicky");
		
		display(arr1);   // Can not cast primitive data types to Object type.
		display(arr2);
		
		Object[] a = new Object[4]; // Universal type which can accept any value.
		
		Arrays.fill(a, 22);
		display(a);
		Arrays.fill(a, "Yo!");
		display(a);
		Arrays.fill(a, 22.45);
		display(a);
	}
}
