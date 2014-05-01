package ArraysPackageFullAllQuest;

import java.util.Arrays;

public class Sorting_QuickSort {
	private static int[] array = {4,2,5,7,8,9,1,3,6,88,91,76,39,47,28,26,63,49,54,93,62,95,72,92,10};
	//private static int[] array = {14,12,15,17,18,19,11,13,16};
	//private static int[] array = {4,2,5,7,8,9,1,3,6};
	
	private void quicksort(int low, int high) {
		int i=low, j=high;
		int pivot = array[low+(high-low)/2];
		
		while(i<=j){
			while(pivot > array[i]) i++;
			while(pivot < array[j]) j--;
			
			if(i<=j){
				swap(i,j);
				i++;
				j--;
			}
		}
		if(low < j)
			quicksort(low, i);
		if(i < high)
			quicksort(i, high);
	}

	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		new Sorting_QuickSort().quicksort(0,array.length-1);
		System.out.println(Arrays.toString(array));
	}

}
