package java3_SortingtrickyProblem;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch_FirstIndex {

	int MAX_SIZE = 10000;
	int[] arr = new int[MAX_SIZE];
	//int [] arr = {0,0,0,0,0,0,0,0,0,1};

	public BinarySearch_FirstIndex(){
		for(int i=0; i<MAX_SIZE;i++)
			arr[i] = new Random().nextInt(2);
		 
		Arrays.sort(arr);
	}

	public void binarySearch(){
		int low = 0, high = MAX_SIZE-1;
		if(arr[low]==1){
			System.out.println("Key is at 0th Index");
			return;
		} else if(arr[high]==1) {
			if(arr[high-1]==0)
			{
				System.out.println("Key is at Last Index");
				return;
			}
		}
		if(arr[high]==0){
			System.out.println("Key is not present");
			return;
		}

		while(true){
			if(low > high)
				return;

			int mid = (high + low)/2;
			if(arr[mid] == 0)
				low = mid;
			else if(arr[mid] == 1)
			{
				if(arr[mid-1] == 0) {
					System.out.println("key is at "+mid+" position");
					break;
				}
				high=mid;
			}
		}
	}

	public static void main(String[] args) {
		BinarySearch_FirstIndex i1 = new BinarySearch_FirstIndex();
		System.out.println(Arrays.toString(i1.arr));
		i1.binarySearch();
	}

}
