package RecursionPackage;

import java.util.Arrays;

public class SelectionSortRecursion {

/*	public static void selectionSort(int arr[]){
		for(int i=0;i<arr.length;i++){
			int k=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[k])
					k=j;
			}
			int temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}  */
	
	public static void selectionSort(int arr[], int length){
		if(length==0)
			return;
		//System.out.println(Arrays.toString(arr));
		int key = length-1;
		for(int i=key-1;i>=0;i--){
			if(arr[i]>arr[key])
				key = i;
		}
		int temp = arr[length-1];
		arr[length-1] = arr[key];
		arr[key] = temp;
		selectionSort(arr,length-1);
		System.out.print(arr[length-1]+" ");
	}

	public static void main(String[] args) {
		int []arr = {4,2,3,6,10,1,5,9,7,8,11,19,17,14,16,13,18,12,20};
		//selectionSort(arr);
		selectionSort(arr, arr.length);
	}
}
