package arrayTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class UniqueCharString {
	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}

	public static boolean isUniqueArray(int[] str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length; i++) {
			int val = str[i];
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	public static char[] removeDuplicates(char[] str) {
		if (str == null || str.length==1) return str;
		int len = str.length;
		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j]) break;
			}
			if (j == tail) { 
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		return str;
	}

	public static void FrequencyCounter(String str)
	{
		int[] counter = new int[256];
		for(char c: str.toCharArray())
		{
			++counter[c];
		}
		for(int i:counter)
		{
			if(i==0) continue;
			System.out.print(i+" ");
		}
	}
	
	public static void Anagrams(String str,String str2)
	{
		int[] counter = new int[256];
		for(char c: str.toCharArray())
		{
			++counter[c];
		}
		for(int i:counter)
		{
			if(i==0) continue;
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		/*System.out.println(isUniqueChars2("Vrajendra"));
		//int[] arr = {5, 5, 3, 1, 3, 2, 4, 4, 4, 2, 4, 2, 5, 3, 4, 1, 6, 1, 6, 5, 3, 5, 5, 5, 1, 3, 4, 2, 3, 6};
		int[] arr = {111,222,3233,4444,51245,6123};
		System.out.println(isUniqueArray(arr));*/
		/*char[] abcd = {'a','b','c','a','b','c','b','c'};

		System.out.println(Arrays.toString(abcd));
		System.out.println(Arrays.toString(removeDuplicates(abcd)));
		FrequencyCounter("AbcdAbcdAbcdAbcdAbcd");*/
		
		Anagrams("Vrajendra","Vrajendra");
	}
}
