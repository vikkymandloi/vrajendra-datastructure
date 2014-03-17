package AmazonTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Vector;


public class Solution {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Assuming the array is {1, 3, 4, 5, 7}
		int array[] = {1,3,4,5,7};
		int s = 34;
		//int minimum = findMinReq(array, s);
		//System.out.print(minimum);
		Vector <Integer> a = new Vector<Integer>();
		a.toArray();
	}

	private static int findMinReq(Vector<Integer> a, int S) {
		if(S == 0)
			return 0;
		int minimum = -1;
		boolean first = true;
		Iterator itvector = a.iterator();
		while(itvector.hasNext()) {
			int element = (Integer) itvector.next();
			if(S < element) {
				continue;
			}
			int minChild = findMinReq(a, S - element);
			if(minChild == -1)
				continue;
			
			if(first) {
				minimum = minChild;
				first = false;
			}
			
			if (minimum > minChild)
				minimum = minChild;
		}
		if(minimum == -1)
			return -1;
		return minimum + 1;
	}
}
