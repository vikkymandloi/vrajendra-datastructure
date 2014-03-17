package RecursionPackage;

import java.util.Arrays;

public class InsertionSortRecursion {
	public static int[] insertionSort(int arr[], int length)
	{
		if(length>arr.length-1)
			return null;
		
		int key = arr[length];
		int i=length-1;
		
		while(i>=0 && arr[i]>key){
			arr[i+1] = arr[i];
			arr[i] = key;
			i--;
		}
		insertionSort(arr, length+1);
		//System.out.print(arr[length-1]+" ");
		return arr;
	}
	
	public static void main(String[] args) {
		int []arr = {4,2,3,6,10,1,5,9,7,8,11,19,17,14,16,13,18,12,20};
		System.out.println(Arrays.toString(insertionSort(arr,1)));
	}
}
