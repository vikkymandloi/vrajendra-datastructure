package ArraysPackageFullAllQuest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting_AllInOne {

	int MAX_SIZE = 10000;
	List<Integer> arraylist = new ArrayList<Integer>();
	int[] arr;
	public Sorting_AllInOne(){
		for(int i=0;i<MAX_SIZE;i++){
			arraylist.add(i);
		}
		Collections.shuffle(arraylist);

		arr = new int[MAX_SIZE];
		for(long i=0;i<MAX_SIZE;i++){
			arr[(int) i] = arraylist.get((int) i);
		}
	}

	public void isSorted(){
		int i=0;
		while(true){
			if(i == MAX_SIZE-2)
			{
				System.out.println("Array is Sorted");
				break;
			}
			if(arraylist.get(i) > arraylist.get(i+1))
			{
				System.out.println("Sorry The array is not Sorted");
				break;
			}
			if(arraylist.get(i) < arraylist.get(i+1))
				i++;
		}
	}

	public void swap(int i, int j){
		Collections.swap(arraylist, i, j);
	}

	public void bubbleSort_arraylist(){
		long starttime = System.currentTimeMillis();
		for(int i=0;i<MAX_SIZE-1;i++){
			for(int j=0;j<MAX_SIZE-i-1;j++){
				if(arraylist.get(j) > arraylist.get(j+1)){
					swap(j, j+1);
				}
			}
		}
		long endtime = System.currentTimeMillis();
		System.out.println("Sorting Done in "+(endtime - starttime)+" milli Seconds.");
	}

	public void bubbleSort(){
		long starttime = System.currentTimeMillis();
		for(int i=0;i<MAX_SIZE-1;i++){
			for(int j=0;j<MAX_SIZE-i-1;j++){
				if(arr[j] < arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		long endtime = System.currentTimeMillis();
		System.out.println("Sorting Done in "+(endtime - starttime)+" milli Seconds.");
	}

	public void quickSort_1(){
		long starttime = System.currentTimeMillis();
		quickSort_arraylist(0, MAX_SIZE-1);
		long endtime = System.currentTimeMillis();
		System.out.println("Sorting Done in "+(endtime - starttime)+" milli Seconds.");
	}

	public void quickSort_2(){
		long starttime = System.currentTimeMillis();
		quickSort_array(0, MAX_SIZE-1);
		long endtime = System.currentTimeMillis();
		System.out.println("Sorting Done in "+(endtime - starttime)+" milli Seconds.");
	}

	public void quickSort_array(int low, int high){
		int i=low; int j = high;
		int pivot = arr[low+(high-low)/2];

		while(i<=j){
			while(pivot > arr[i]) i++;
			while(pivot < arr[j]) j--;

			if(i<=j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++; j--;
			}
		}

		if(low < j)
			quickSort_array(low, j);
		if(i < high)
			quickSort_array(i, high);
	}

	public void quickSort_arraylist(int low, int high){
		int i=low; int j = high;
		int pivot = arraylist.get(low+(high-low)/2);

		while(i<=j){
			while(pivot > arraylist.get(i)) i++;
			while(pivot < arraylist.get(j)) j--;

			if(i<=j){
				swap(i, j); i++; j--;
			}
		}

		if(low < j)
			quickSort_arraylist(low, j);
		if(i < high)
			quickSort_arraylist(i, high);
	}

	public void mergeSort_1(){
		long starttime  = System.currentTimeMillis();
		mergesort_ArrayList(0, MAX_SIZE-1);
		isSorted();
		long endtime  = System.currentTimeMillis();
		System.out.println("Sorting Done in "+(endtime - starttime)+" milli Seconds.");
	}

	public void mergesort_ArrayList(int low, int high){
		if(low >= high)
			return;

		int middle = low + (high-low)/2;
		mergesort_ArrayList(low, middle);
		mergesort_ArrayList(middle+1, high);

		int secondstart = middle+1;

		while(low <= middle && secondstart <= high){
			if(arraylist.get(low) < arraylist.get(secondstart))
				low++;
			else
			{
				int pivot = arraylist.get(secondstart);
				for(int i = secondstart-1; i>=low ; i--){
					arraylist.set(i+1, arraylist.get(i));
				}
				arraylist.set(low, pivot);

				low++;
				secondstart++;
				middle++;
			}
		}
	}

	public void shellsort(){
		for(int mid = MAX_SIZE/2; mid>0; mid/=2){
			for(int i = mid; i<MAX_SIZE-1; i++){
				int j, temp = arraylist.get(i);
				for(j=i; j>=mid; j-=mid)
				{
					if(temp < arraylist.get(j-mid))
						arraylist.set(j, arraylist.get(j-mid));
					else
						break;
				}
				arraylist.set(j, temp);
			}
		}
		isSorted();
	}

	public void insertionsort(){
		long starttime  = System.currentTimeMillis();
		
		for(int i=1; i < MAX_SIZE-1; i++){
			int j=i-1;
			int pivot = arraylist.get(i);
			while(j>=0 && pivot < arraylist.get(j))
			{
				arraylist.set(j+1, arraylist.get(j));
				j--;
				arraylist.set(j+1, pivot);
			}
		}

		long endtime  = System.currentTimeMillis();
		System.out.println("Sorting Done in "+(endtime - starttime)+" milli Seconds.");
		isSorted();
	}

	public static void main(String[] args) {
		Sorting_AllInOne a1 = new Sorting_AllInOne();
		//a1.bubbleSort_arraylist();
		//a1.bubbleSort();
		//a1.quickSort_1();
		//a1.quickSort_2();
		//a1.mergeSort_1();
		//a1.shellsort();
		a1.insertionsort();
	}
}
