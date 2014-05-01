package ArraysPackageFullAllQuest;

import java.util.Arrays;

public class Sorting_MergeSort {
	private static int[] array = {4,2,5,7,8,9,1,3,6,88,91,76,39,47,28,26,63,49,54,93,62,95,72,92,10};
	//private static int[] array = {14,12,15,17,18,19,11,13,16};
	//private static int[] array = {4,2,5,7,8,9,1,3,6};
	//private static int[] helper = new int[array.length];

	/*private static void mergesort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private static void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			array[k] = helper[i];
			k++;
			i++;
		}
	}*/
	
	public static void isSorted(){
		for(int i=0;i<array.length-1;i++){
			if(array[i]<array[i+1])
					continue;
			else
				{
				System.out.println("NO");
					break;
				}
		}
	}

	public static void mergesort(int low, int high){

		int middle = (low + high) / 2;
		if (low >= high) {
			return;
		}

		mergesort(low, middle);
		mergesort(middle + 1, high);
		
		int secondstart = middle + 1;
		
		while ((low <= middle) && (secondstart <= high)) {
			if (array[low] < array[secondstart]) {
				low++;
			} else {
				int Temp = array[secondstart];
				//System.arraycopy(array, low, array, low+1, secondstart-1-low);
				for (int k = secondstart- 1; k >= low; k--) {
					array[k+1] = array[k];
				}
				array[low] = Temp;
				low++;
				middle++;
				secondstart++;
			}
		}
	}

	public static void main(String[] args) {
		mergesort(0, array.length-1);
		isSorted();
		System.out.println(Arrays.toString(array));
	}

}
