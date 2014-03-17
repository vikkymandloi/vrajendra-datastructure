package arrayTest;

import java.util.Arrays;

public class MergeSortJava {

	public static int[] mergeSort(int[] data){
		int lenD = data.length;
		if(lenD<=1){
			return data;
		}
		else{
			int[] sorted = new int[lenD];
			int middle = lenD/2;
			int rem = lenD-middle;
			int[] L = new int[middle];
			int[] R = new int[rem];
			System.arraycopy(data, 0, L, 0, middle);
			System.arraycopy(data, middle, R, 0, rem);
			L = mergeSort(L);
			R = mergeSort(R);
			sorted = merge(L, R);
			return sorted;
		}
	}

	public static int[] merge(int[] L, int[] R){
		int lenL = L.length;
		int lenR = R.length;
		int[] merged = new int[lenL+lenR];
		int i = 0;
		int j = 0;
		while(i<lenL||j<lenR){
			if(i<lenL & j<lenR){
				if(L[i]<=R[j]){
					merged[i+j] = L[i];
					i++;
				}
				else{
					merged[i+j] = R[j];
					j++;
				}
			}
			else if(i<lenL){
				merged[i+j] = L[i];
				i++;
			}
			else if(j<lenR){
				merged[i+j] = R[j];
				j++;
			}
		}
		return merged;
	}


	public static void main(String[] args) {
		int []arra = {8,2,13,11,4,9,14,5,10,7,12,6,15,3};
		arra = mergeSort(arra);
		System.out.println(Arrays.toString(arra));
	}
}
