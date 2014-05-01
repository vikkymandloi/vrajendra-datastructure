package java3_SortingtrickyProblem;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch_duplicateElemFirstIndex {

	static int MAX_SIZE = 100;
	int[] arr = new int[MAX_SIZE];
	
	public BinarySearch_duplicateElemFirstIndex(){
		for(int i=0;i<MAX_SIZE;i++)
			arr[i] = new Random().nextInt(5);
		Arrays.sort(arr);
	}
	
	public void binarysearch(int key){
		int low = 0;
		int high = MAX_SIZE-1;
		
		if(key < arr[low] || key > arr[high]){
			System.out.println("Key is not present");
			return;
		}
		
		if(key==arr[low])
		{
			System.out.println("Key is present at the 0th index");
			return;
		} else if(arr[high]== key)
		{
			if(arr[high-1] != key){
				System.out.println("Key is present at the last index");
				return;
			}
		}		
		
		while(true){
			if(low > high)
				return;
			int mid = (high + low)/2;
			if(arr[mid] < key)
				low = mid;
			else if (arr[mid] > key)
				high = mid;
			else if (arr[mid]==key)
			{
				if(arr[mid-1]!=key)
				{
					System.out.println("key is present at "+mid +" index");
					break;
				}
				high = mid;
			}
		}
	}
	
	public static void main(String[] args) {
		BinarySearch_duplicateElemFirstIndex b1 = new BinarySearch_duplicateElemFirstIndex();
		System.out.println(Arrays.toString(b1.arr));
		b1.binarysearch(7);
	}
}
