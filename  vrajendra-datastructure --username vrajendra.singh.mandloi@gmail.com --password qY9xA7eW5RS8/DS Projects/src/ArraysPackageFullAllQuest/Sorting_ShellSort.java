package ArraysPackageFullAllQuest;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Sorting_ShellSort {
	int[] array = {4,2,5,7,8,1,3,6};
	int i, j, length = array.length;

	public void sort(){
		for (int mid = length / 2; mid > 0; mid /= 2) {
			shellsort(mid);
		}
	}

	public void shellsort(int mid)
	{
		for (i = mid; i < length; i++) {
			int temp = array[i];

			for (j = i; j >= mid; j -= mid) 
			{
				if (temp < array[j - mid])
					array[j] = array[j - mid];
				else 
					break;
			}
			array[j] = temp;
		}
	}

	public void Display(){
		// Display
		System.out.println("After Sorting:");
		for (int i1 = 0; i1 < array.length; i1++) {
			System.out.print(array[i1]+" ");
		}
	}

	public static void main(String[] args) {
		Sorting_ShellSort s1 = new Sorting_ShellSort();
		s1.sort();
		s1.Display();
	}
}
