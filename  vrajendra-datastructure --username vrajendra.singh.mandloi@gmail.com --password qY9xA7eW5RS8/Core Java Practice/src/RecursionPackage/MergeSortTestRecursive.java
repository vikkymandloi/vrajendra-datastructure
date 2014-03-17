package RecursionPackage;

import java.util.Arrays;

public class MergeSortTestRecursive {
	static int arr[] = {3,6,4,8,2,7,1,5,9};
	public static void dubleRecurseOutput(int [] arr, int low, int high){
		if(low < high){
			int mid = (low + high) / 2;
			System.out.println("Low one recurrsed "+arr[mid]);
			dubleRecurseOutput(arr,low,mid);
			display("1 call");
			System.out.println("High one recurrsed "+arr[mid]);
			dubleRecurseOutput(arr,mid+1,high);
			display("2 call");
		}
	}
	public static void display(String arr){
		System.out.println(arr);
	}

	public static void main(String[] args) {
		dubleRecurseOutput(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
