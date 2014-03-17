package arrayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DuplicateArrays {

	public static void main(String[] args) {
		//int arr[] = new int[30];
		//arr = randomNumb(arr);
		int arr[] = {5, 5, 3, 1, 3, 2, 4, 4, 4, 2, 4, 2, 5, 3, 4, 1, 6, 1, 6, 5, 3, 5, 5, 5, 1, 3, 4, 2, 3, 6};
		System.out.println(Arrays.toString(arr));
		uniqueNumb(arr);
		FreqNumb(arr);
		uniqueArray1(arr);
		RotateNumb();
	}

	public static void uniqueArray1(int[] arr)
	{
		Object[] uar = uniqueNumb(arr);
		List<Integer> list = new ArrayList<Integer>();
		for(int qw:arr)
			list.add(qw);
		for(Object a: uar)
			System.out.println(a+" repeated "+Collections.frequency(list, Integer.parseInt(a.toString()))+" times.");
	}
	
	public static void RotateNumb()
	{
		List numbers = new ArrayList();
		for (int i = 5; i < 25; i++) {
			numbers.add(i);
		}
		System.out.println(Arrays.toString(numbers.toArray()));
		for(int a=1;a<25;a++)
			Collections.rotate(numbers, 2);
		System.out.println(Arrays.toString(numbers.toArray()));
	}

	public static Object[] uniqueNumb(int[] arr)
	{
		Set<Integer> se = new HashSet<Integer>();
		for(int a:arr)
			se.add(a);
		System.out.println(Arrays.toString(se.toArray()));
		return se.toArray();
	}

	public static void FreqNumb(int[] arr)
	{
		List<Integer> asd = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)
			asd.add(arr[i]);

		System.out.println(Collections.frequency(asd, 2));
	}

	public static int[] randomNumb(int[] arr)
	{
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(new Random().nextInt(6))+1;
		}
		return arr;
	}
}
