package java3_sortingPKG;

import java.util.Arrays;

public class Sorting_MergeSort {

	static int[] array = {1,0,9,2,8,3,7,4,5,6,23,19,32,16,18,15,12,22};
	static int len = array.length;

	public void mergesort(int low,int high){
		if(low >= high)
			return;
		
		int middle = low + (high - low)/2;
		mergesort(low, middle);
		mergesort(middle+1, high);
		
		int secondstart = middle +1;
		while(low <= middle && secondstart <=high){
			if(array[low] < array[secondstart])
				low++;
			else
			{
				int pivot = array[secondstart];
				System.arraycopy(array, low, array, low+1, secondstart-low);
				array[low] = pivot;
				low++;
				secondstart++;
				middle++;
			}
		}
	}
	
	public static void main(String[] args) {
		new Sorting_MergeSort().mergesort(0,len-1);
		System.out.println(Arrays.toString(array));
	}

}
