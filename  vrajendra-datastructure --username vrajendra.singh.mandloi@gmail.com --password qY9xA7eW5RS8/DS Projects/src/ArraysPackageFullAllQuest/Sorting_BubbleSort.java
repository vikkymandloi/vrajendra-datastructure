package ArraysPackageFullAllQuest;

import java.util.Arrays;

public class Sorting_BubbleSort {

	int array[] = {1,9,2,8,3,7,4,6,5};
	int length = array.length;

	// Integers Sorting
	public void BubbleSort() {
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]<array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	String[] str = {"Vrajendra", "Ruchi", "Ekta", "Shubham" , "Tuhin", "Sandeep"};
	// String Sorting
	public void bubblesort_string(){
		for(int i=0; i<str.length; i++){
			for(int j=0; j<str.length-i-1; j++){
				if(str[j].compareTo(str[j+1])<0){
					String temp = str[j];
					str[j] = str[j+1];
					str[j+1] = temp;				
				}
			}
		}
		System.out.println(Arrays.toString(str));
	}

	// recursive sorting
	public void recursive_BubbleSort(int length){
		if(length ==0){
			System.out.println(Arrays.toString(array));
			return;
		}

		for(int i=0;i<length-1; i++){
			if(array[i] < array[i+1])
			{
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}
		recursive_BubbleSort(length-1);
	}

	public static void main(String[] args) {
		/*new Sorting_BubbleSort().BubbleSort();
		new Sorting_BubbleSort().recursive_BubbleSort(new Sorting_BubbleSort().length);*/
		new Sorting_BubbleSort().bubblesort_string();
	}
}
