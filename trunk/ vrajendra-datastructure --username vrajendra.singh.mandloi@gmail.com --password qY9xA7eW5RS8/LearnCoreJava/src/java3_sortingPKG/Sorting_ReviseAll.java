package java3_sortingPKG;

import java.util.Arrays;
import java.util.Random;

public class Sorting_ReviseAll {

	private static int MAX_SIZE = 10000;
	private static int arr[] = new int[MAX_SIZE];
	
	public Sorting_ReviseAll(){
		for(int i=0;i<MAX_SIZE;i++){
			arr[i] = i;
		}
		shuffle();
	}	
	
	public void shuffle() {
		Random rand = new Random();
		for(int i=0; i<MAX_SIZE; i++){
			int x = rand.nextInt(MAX_SIZE);
			int y = rand.nextInt(MAX_SIZE);
			swap(arr, x,y);
		}
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void isSorted(int arr[]){
		int low = 0;
		int high = MAX_SIZE-1;
		while(true){
			if(low>=high){
				System.out.println("Array is Sorted");
				break;
			}
			if(arr[low]>arr[low+1]){
				System.out.println("Sorry the array is not Sorted.");
				break;
			}
			low++;
		}
	}
	
	public int[] bubbleSort(int[] arr){
		long starttime = System.currentTimeMillis();
		int len = arr.length;
		
		for(int i=0;i<len;i++){
			for(int j=0; j<len-i-1;j++){
				if(arr[j]>arr[j+1])
					swap(arr, j, j+1);
			}
		}
		long endtime = System.currentTimeMillis();
		System.out.println("Bubble sort done in "+ (endtime-starttime)+" millis.");
		return arr;
	}
	
	public int[] insertionsort(int arr[]){
		long starttime = System.currentTimeMillis();
		for(int i=1; i<MAX_SIZE; i++){
			int j = i-1;
			int pivot = arr[i];
			while(j>=0 && pivot < arr[j]){
				arr[j+1] = arr[j];
				j--;
				arr[j+1] = pivot;
			}
		}
		long endtime = System.currentTimeMillis();
		System.out.println("Insertion sort done in "+ (endtime-starttime)+" millis.");
		return arr;
	}
	
	public int[] shellsort(int arr[]){
		long starttime = System.currentTimeMillis();
		for(int mid=MAX_SIZE/2; mid>0; mid/=2){
			for(int i=mid; i<MAX_SIZE; i++){
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
		long endtime = System.currentTimeMillis();
		System.out.println("Shell sort done in "+ (endtime-starttime)+" millis.");
		return arr;
	}
	
	public int[] mergesort(int arr[]){
		long starttime = System.currentTimeMillis();
		arr = mergesort(arr, 0, MAX_SIZE-1);
		long endtime = System.currentTimeMillis();
		System.out.println("Merge sort done in "+ (endtime-starttime)+" millis.");
		return arr;
	}
	
	public int[] mergesort(int[] arr, int low, int high){
		if(low >= high)
			return arr;
		
		int mid = (high + low) / 2;
		mergesort(arr, low, mid);
		mergesort(arr, mid+1, high);
		
		int secondstart = mid+1;
		while(low <= mid && secondstart <= high){
			if(arr[low] < arr[secondstart])
				low++;
			else
			{
				int pivot = arr[secondstart];
				System.arraycopy(arr, low, arr, low+1, secondstart-low);
				arr[low] = pivot;
				
				low++;
				secondstart++;
				mid++;
			}
		}
		return arr;
	}
	
	public int[] quicksort(int arr[]){
		long starttime = System.currentTimeMillis();
		arr =quicksort(arr, 0, MAX_SIZE-1);
		long endtime = System.currentTimeMillis();
		System.out.println("Quick sort done in "+ (endtime-starttime)+" millis.");
		return arr;
	}
	
	public int[] quicksort(int[] arr, int low, int high){
		int i = low, j=high;
		int pivot = arr[low+(high-low)/2];
		while(i<=j){
			while(pivot > arr[i]) i++;
			while(pivot < arr[j]) j--;
			if(i<=j){
				swap(arr,i,j);
				i++;  j--;
			}
		}
		if(i < high)
			quicksort(arr, i, high);
		if(low < j)
			quicksort(arr, low, j);
		return arr;
	}
	
	public static void main(String[] args) {
		Sorting_ReviseAll a1 = new Sorting_ReviseAll();
		int bubblesort[] = a1.bubbleSort(arr);
		isSorted(bubblesort);
		int insertsort[] = a1.insertionsort(arr);
		isSorted(insertsort);
		int shellsort[] = a1.shellsort(arr);
		isSorted(shellsort);
		int mergesort[] = a1.mergesort(arr);
		isSorted(mergesort);
		int quicksort[] = a1.quicksort(arr);
		isSorted(quicksort);
	}
}
