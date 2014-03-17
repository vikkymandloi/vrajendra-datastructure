package RecursionPackage;

import java.util.Arrays;

public class returnMultiplerecurse {
	
	public static int returnmultiple(int arr[],int length){
		if(length==0)
			return arr[0];
		returnmultiple(arr,length-1);
		return arr[length];
	}
	
	public static void main(String[] args) {
		int []arr = {4,2,3,6,10,1};
		int arr2 = returnmultiple(arr,arr.length-1);
		System.out.println(arr2);
	}
}
