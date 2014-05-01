package java3_sortingPKG;

import java.util.Arrays;

public class Sorting_ShellSort {
	
	static int[] arr = {1,0,9,2,8,3,7,4,5,6};
	static int len = arr.length;
	
	public static void main(String[] args) {
		for(int mid=len/2; mid>0; mid/=2){
			for(int i=mid; i<len; i++){
				int pivot = arr[i];
				int j;
				for(j=i; j>=mid; j-=mid){
					if(pivot < arr[j-mid])
						arr[j] = arr[j-mid];
					else
						break;
				}
				arr[j] = pivot;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
