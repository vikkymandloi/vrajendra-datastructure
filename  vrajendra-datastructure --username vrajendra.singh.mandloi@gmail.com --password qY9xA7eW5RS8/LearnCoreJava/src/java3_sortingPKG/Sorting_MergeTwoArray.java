package java3_sortingPKG;

import java.util.*;

public class Sorting_MergeTwoArray {
	int[] arr1 = {1,2,3,4,5,7,8,10,11,13};
	int[] arr2 = {0,0};
	int len1 = arr1.length;
	int len2 = arr2.length;

	public void mergetwo(){
		arr1 = Arrays.copyOf(arr1, len1+len2);
		int i = len1 - 1;
		int j = len2 - 1; 
		int x = len1 + len2 - 1; 

		while(i >= 0 && j >= 0) { 
			System.out.println(Arrays.toString(arr1));
			if (arr1[i] >= arr2[j]) 
				arr1[x--] = arr1[i--]; 
			else 
				arr1[x--] = arr2[j--]; 
		} 

		/*while(i >= 0){
			arr1[x--] = arr1[i--];
			System.out.println(Arrays.toString(arr1));
		}*/
		while(j >= 0){
			arr1[x--] = arr2[j--];
			System.out.println(Arrays.toString(arr1));
		}
	}

	public static void main(String[] args) {
		Sorting_MergeTwoArray t1 = new Sorting_MergeTwoArray();
		t1.mergetwo();
		System.out.println(Arrays.toString(t1.arr1));
	}
}
