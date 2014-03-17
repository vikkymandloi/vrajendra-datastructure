package arrayTest;

import java.util.Arrays;

public class BubbleSortJava {

	public static int[] bubbleSort(int[] data){
		int lenD = data.length;
		for(int i=0;i<lenD-1;i++) {
			for(int j=0;j<lenD-1-i;j++) {
				if(data[j]>data[j+1]) {
					int x=data[j];
					data[j]=data[j+1];
					data[j+1]=x;
				}
			}
		}
		return data;
	}

	public static void main(String[] args) {
		int []arra = {8,2,1,13,11,4,9,14,5,10,7,12,6,15,3};
		arra = bubbleSort(arra);
		System.out.println(Arrays.toString(arra));
	}

}
