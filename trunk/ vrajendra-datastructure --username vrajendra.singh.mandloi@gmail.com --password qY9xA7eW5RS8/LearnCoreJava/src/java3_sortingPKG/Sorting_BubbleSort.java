package java3_sortingPKG;

import java.util.Arrays;

public class Sorting_BubbleSort {

	static int []arr = {5,6,3,4,7,9,8,1,2,0};
	int len = arr.length;

	public void bubblesort(){
		for(int i=0;i<len;i++){
			for(int j=0;j<len-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		new Sorting_BubbleSort().bubblesort();
	}
}
