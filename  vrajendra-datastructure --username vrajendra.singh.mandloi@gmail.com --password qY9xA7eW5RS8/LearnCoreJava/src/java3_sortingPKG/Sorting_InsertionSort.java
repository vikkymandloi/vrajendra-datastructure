package java3_sortingPKG;

import java.util.Arrays;

public class Sorting_InsertionSort {
	
	static int[] arr = {1,0,9,2,8,3,7,4,5,6};
	static int len = arr.length;
	
	public static void main(String[] args) {
		for(int i=1;i<len;i++){
			int j = i-1;
			int pivot = arr[i];
			while(j>=0 && arr[j] > pivot){
				arr[j+1] = arr[j];
				j--;
				arr[j+1] = pivot;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
