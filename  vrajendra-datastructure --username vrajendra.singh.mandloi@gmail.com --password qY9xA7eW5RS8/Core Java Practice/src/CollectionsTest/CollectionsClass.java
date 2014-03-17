package CollectionsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsClass {

	static boolean issorted(int[] a){
		for(int i=0;i<a.length-1;i++){
			if(a[i]>a[i+1])
				return false;
		}
		return true;
	}

	static Integer[] removeDuplicate(int[] a)
	{
		List<Integer> l1 = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++){
			boolean match = false;
			for(int j=0;(j<i)&&(match==false);j++)
			{
				if(a[i]==a[j])
					match=true;
			}
			if(!match){
				System.out.println(a[i]);
				l1.add(a[i]);
			}
		}
		return (Integer[])l1.toArray();
	}
	public static void main(String[] args) {
		int[] a={1,1,2,2,2,3,3,3,3,3,4,4,4,4,5,5,5,6,6,7,7};
		Integer[] a1 = removeDuplicate(a);
		System.out.println(Arrays.toString(a1));
		System.out.println(new CollectionsClass().issorted(a));
	}
}
