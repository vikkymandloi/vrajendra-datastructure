package java3_sortingPKG;

import java.util.Arrays;

public class Sorting_SelectionSort {
	static int[] arr = {1,0,9,2,8,3,7,4,5,6};
	static int len = arr.length;
	String classname = this.getClass().getName();
	
	public static void main(String[] args) {
		for(int i=0;i<len;i++){
			int k = i;
			for(int j=i;j<len;j++){
				if(arr[j] > arr[k]){
					k=j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}
		
		System.out.println(new Sorting_SelectionSort().classname+" = "+Arrays.toString(arr));
	}
}
