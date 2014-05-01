package ArraysPackageFullAllQuest;

import java.util.Arrays;

public class Sorting_SelectionSort {

	int array[] = {1,9,2,8,4,7,3,6,5};
	int length = array.length;
	
	public void SelectionSort(){
		// traverse through the length
		for(int i=0;i<length;i++){
			int index=i;
			for(int j=index+1; j<length ;j++)
				if(array[index]<array[j])
					index=j;
			
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		new Sorting_SelectionSort().SelectionSort();
	}
}
