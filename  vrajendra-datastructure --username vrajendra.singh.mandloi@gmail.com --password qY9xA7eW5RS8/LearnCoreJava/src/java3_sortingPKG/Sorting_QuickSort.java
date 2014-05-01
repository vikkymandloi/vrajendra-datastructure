package java3_sortingPKG;

import java.util.Arrays;

public class Sorting_QuickSort {
	static int[] arr = {1,0,9,2,8,3,7,4,5,6,23,19,32,16,18,15,12,22};
	static int len = arr.length;
	
	public static void quicksort(int low, int high){
		int i = low, j = high;
		int pivot = arr[low + (high-low)/2];
		while(i<=j){
			while(pivot > arr[i]) i++;
			while(pivot < arr[j]) j--;
			if(i<=j){				
				swap(i,j);
				i++; j--;
			}
		}
		
		if(i < high)
			quicksort(i, high);
		if(low < j)
			quicksort(low, j);
	}
	
	public static void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		quicksort(0, len-1);
		
		System.out.println(Arrays.toString(arr));
	}

}
