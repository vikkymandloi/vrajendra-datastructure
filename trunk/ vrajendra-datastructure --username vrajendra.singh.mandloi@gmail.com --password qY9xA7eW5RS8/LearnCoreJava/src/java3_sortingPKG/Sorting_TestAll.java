package java3_sortingPKG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting_TestAll {

	static int MAX_SIZE = 100000;
	Integer[] arr = new Integer[MAX_SIZE];
	ArrayList<Integer> list1 = new ArrayList<Integer>();

	public Sorting_TestAll() {
		for(int i=0;i<MAX_SIZE;i++){
			list1.add(i);
		}
		Collections.shuffle(list1);
		arr = list1.toArray(arr);
	}

	public void bubble_sort(int low, int high){
		long startTime = System.currentTimeMillis();
		for(int i=low; i<high; i++){
			for(int j=low; j<high-i-1; j++){
				if(arr[j]>arr[j+1])
					swap(j,j+1);
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Bubble Sort Time of Execution is "+(endTime-startTime));
		System.out.println(Arrays.toString(arr));
	}

	public void insertion_sort(int low, int high){
		long startTime = System.currentTimeMillis();
		for(int i=1; i<high; i++){
			int k = i-1;
			int pivot = arr[i];
			while(k>=0 && pivot < arr[k]){
				arr[k+1] = arr[k];
				k--;
				arr[k+1] = pivot;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("insertion Sort Time of Execution is "+(endTime-startTime));
		System.out.println(Arrays.toString(arr));
	}

	public void selection_sort(int low, int high){
		long startTime = System.currentTimeMillis();
		for(int i=0; i<high; i++){
			int k = i;
			for(int j=i+1;j<high;j++){
				if(arr[k]>arr[j])
					k=j;
			}
			swap(i,k);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("insertion Sort Time of Execution is "+(endTime-startTime));
		System.out.println(Arrays.toString(arr));
	}

	public void shell_sort(int low, int high){
		long startTime = System.currentTimeMillis();
		for(int mid=high/2; mid>0; mid/=2){
			for(int i=mid; i<high; i++){
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
		long endTime = System.currentTimeMillis();
		System.out.println("insertion Sort Time of Execution is "+(endTime-startTime));
		System.out.println(Arrays.toString(arr));
	}

	public void merge_sort(){
		long startTime = System.currentTimeMillis();
		merge_sort(0, MAX_SIZE-1);
		long endTime = System.currentTimeMillis();
		System.out.println("insertion Sort Time of Execution is "+(endTime-startTime));
		System.out.println(Arrays.toString(arr));
	}

	public void merge_sort(int low, int high){
		if(low >= high)
			return;

		int mid = low + (high-low)/2;
		merge_sort(low,mid);
		merge_sort(mid+1, high);

		int secondstart = mid+1;

		while(low <= mid && secondstart <= high){
			if(arr[low]<arr[secondstart])
				low++;
			else
			{
				int temp = arr[secondstart];
				System.arraycopy(arr, low, arr, low+1, secondstart-low);
				arr[low] = temp;
				low++;
				secondstart++;
				mid++;
			}
		}
	}

	public void quick_sort(){
		long startTime = System.currentTimeMillis();
		quick_sort(0, MAX_SIZE-1);
		long endTime = System.currentTimeMillis();
		isSorted();
		System.out.println("insertion Sort Time of Execution is "+(endTime-startTime));
		System.out.println(Arrays.toString(arr));
	}

	public void quick_sort(int low, int high){
		int pivot = arr[low+(high-low)/2];
		int i=low, j=high;

		while(i<=j){
			while(pivot > arr[i]) i++;
			while(pivot < arr[j]) j--;

			if(i<=j) {
				swap(i,j);
				i++;  j--;
			}
		}

		if(low < j)
			quick_sort(low, j);
		if(i < high)
			quick_sort(i, high);
	} 

	public void swap(int x, int y){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public boolean isSorted(){
		int count=0;
		while(true){
			if(count == MAX_SIZE-1)	{
				System.out.println("The Array is sorted"); return true;
			}
			if(arr[count] < arr[count+1])
				{count++; continue;}
			else
				{System.out.println("Sorry the Array is not sorted"); return false;}
		}
	}

	public void binary_Search(int key){
		int low = 0;
		int high = MAX_SIZE-1;
		
		if(key > arr[high] || key <arr[low]) {
			System.out.println("Key Not valid");
			return;
		}
		
		while(true){
			if(low >=high)
				return;
			int mid = (high + low)/2;
			if(arr[mid] == key) {
				System.out.println("index is : "+mid);
				break;
			} else if(arr[mid] > key) {
				high = mid;
				if(arr[high]==key){
					System.out.println("index is : "+mid);
					break;
				}					
			} else if(arr[mid] < key) {
				low = mid;
				if(arr[low]==key){
					System.out.println("index is : "+mid);
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Sorting_TestAll t1 = new Sorting_TestAll();
		//t1.bubble_sort(0, MAX_SIZE);
		//t1.insertion_sort(0, MAX_SIZE);
		//t1.selection_sort(0, MAX_SIZE);
		//t1.shell_sort(0, MAX_SIZE);
		//t1.merge_sort();
		t1.quick_sort();
		long starttime = System.currentTimeMillis();
		t1.binary_Search(1);
		long endtime = System.currentTimeMillis();
		System.out.println("Binary Search Executed in :"+(endtime-starttime)+" millis");
	}
}
