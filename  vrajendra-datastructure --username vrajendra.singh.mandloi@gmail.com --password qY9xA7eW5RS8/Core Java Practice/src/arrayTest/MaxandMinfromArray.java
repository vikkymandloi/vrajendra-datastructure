package arrayTest;

import java.util.Scanner;

public class MaxandMinfromArray {

	public static void main(String[] args) {
		int n,m, max, min, i, numb1, numb2;
		int large[] = new int[100];
		int small[] = new int[100];
		int index1 = 1, index2 =1;
		//		read N
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Max number of values to be entered :");
		n = scan.nextInt();
		
		System.out.println("N="+n);
		
		// initialize Max and min
		max=scan.nextInt();
		min = max;
		m = n-1;
		if(n%2==0){
			min = scan.nextInt();
			if(max < min)
				//swap(max,min);
			m--;
		}
		for(i=1; i<m/2; i++){
			numb1 = scan.nextInt();
			numb2 = scan.nextInt();
			if(numb1 >= numb2){
				large[index1] = numb1; index1++;
				small[index2] = numb2; index2++;
			}
			else
			{
				large[index1++] = numb2;
				small[index2++] = numb1;
			}
		}
	}
}
