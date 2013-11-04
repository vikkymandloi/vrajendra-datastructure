package ArraysDC_Schaum;

import java.util.Arrays;

public class Array_BinarySearch {

	public void BinarySearch(int[] arr, int value){
		try {
			int lower = arr[0];
			int upper = arr.length;
			Arrays.sort(arr); // to sort the unsorted array.
			
			if(value > arr[upper-1])
				throw new Exception("The value is not in Scope..!");
			
			for(int i=lower;i<upper;i++){
				int mid = (lower+upper)/2;
				if(arr[mid]==value){
					System.out.println("Ypiii... the value is at "+i+" index.");
					break;
				}
				else if(arr[mid]<value){
					lower = mid+1;
					continue;
				}
				else if(arr[mid]>value){
					upper = mid;
					continue;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {	
		int arr[] = {1,2,3,4,5,6,7,8,9};
		new Array_BinarySearch().BinarySearch(arr, 5);
	}
}
