package arrayTest;

import java.util.Arrays;

public class ArraysClassTest {

	public static void main(String[] args) {
		int[] a1 = {1,2,3,4,8,6,7,5};
		int a2[] = {1,2,3,4,8,6,7,5};  //{1,3,2,4,5,6,7,8}
		int [][] a = {a1,a2};
		
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.equals(a1, a2));
		Arrays.sort(a1);
		String s1 = "Vrajendrasinghmandloi";
		
		System.out.println(s1);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(a1));
	}
}
