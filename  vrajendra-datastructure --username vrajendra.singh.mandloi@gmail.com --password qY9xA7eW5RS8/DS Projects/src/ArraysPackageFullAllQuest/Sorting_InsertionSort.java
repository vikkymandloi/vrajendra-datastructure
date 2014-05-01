package ArraysPackageFullAllQuest;

import java.util.Arrays;

public class Sorting_InsertionSort {
	
	int array[] = {1,9,2,8,4,7,3,6,5};
	int length = array.length;
	
	public void insertionSort(){
		for(int j = 1;j<array.length;j++){
			int key = array[j];
			int i = j-1;
			while(i>=0 && array[i]>key){
				array[i+1] = array[i];
				i = i-1;
				array[i+1]=key;
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public void recursive_InsertionSort(int length){
		if(length < 1) {
			System.out.println(Arrays.toString(array));
			return;
		}
		
		int key = array[length];
		int i=length-1;
		while(i>=0 && array[i] > key) {
			array[i+1] = array[i];
			i--;
			array[i+1] = key;
		}
		recursive_InsertionSort(length-1);
	}
	
	public static void main(String[] args) {
		new Sorting_InsertionSort().insertionSort();
		new Sorting_InsertionSort().recursive_InsertionSort(new Sorting_BubbleSort().length-1);
	}
}
