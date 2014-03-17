package arrayTest;

import java.util.Arrays;

public class MergeTwoArray {

	public static void main(String[] args) {
		int i,j,k;
		int[] arr1 = {4,5,2,8,1};
		int[] arr2 = {3,6,7,9,0};
		int[] arr3 = new int[arr1.length+arr2.length];

		for(k=0,j=0,i=0;i<=arr3.length;i++){
			System.out.println("I Loop Runing");
			if(arr1[k]<arr2[j]){
				arr3[i]=arr1[k];
				k++;
				if(k>=arr1.length){
					for(i++;j<arr2.length;j++,i++)
					{
						arr3[i] = arr2[j];
						System.out.println("K Loop Runing");
					}
				}
			}
			else
			{
				arr3[i]=arr2[j];
				j++;
				if(j>=arr2.length){
					for(i++;k<arr1.length;k++,i++)
					{
						arr3[i] = arr1[k];
						System.out.println("J Loop Runing");
					}
				}
			}
		}
		System.out.println(Arrays.toString(arr3));
	}
}
