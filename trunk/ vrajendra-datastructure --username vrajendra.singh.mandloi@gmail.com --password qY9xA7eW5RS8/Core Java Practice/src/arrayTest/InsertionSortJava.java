package arrayTest;

import java.util.Arrays;

public class InsertionSortJava {
	public static int[] InsertionSort(int[] data){
	/* Insertion Sort Algorithm output
	 * 
	 * [8, 2, 13, 11, 4, 9, 14, 5, 10, 7, 12, 6, 15, 3]
		----------------------------------------------------------------------------
		loop 1 start >>
		Key=2
		i = 0
		Before data[i+1]=2
		data[i]=8
		data[i+1]=8
		First i=0
		After i=-1
		After data[i+1]=2
		[2, 8, 13, 11, 4, 9, 14, 5, 10, 7, 12, 6, 15, 3]
		loop one ends with swap of 8,2. the approach is from back to the key element check.  
		----------------------------------------------------------------------------
		loop 2 start >>
		Key=13
		i = 1
		----------------------------------------------------------------------------
		loop 3 start >>
		Key=11
		i = 2
		Before data[i+1]=11
		data[i]=13
		data[i+1]=13
		First i=2
		After i=1
		After data[i+1]=11
		[2, 8, 11, 13, 4, 9, 14, 5, 10, 7, 12, 6, 15, 3]
		as 11 and 13 were not in order so they get swapped.
		----------------------------------------------------------------------------
		lopp 4 start >>
		Key=4
		i = 3
		Before data[i+1]=4
		data[i]=13
		data[i+1]=13
		First i=3
		After i=2
		After data[i+1]=4
		[2, 8, 11, 4, 13, 9, 14, 5, 10, 7, 12, 6, 15, 3]    << 4 is smaller than 13
		Before data[i+1]=4
		data[i]=11
		data[i+1]=11
		First i=2
		After i=1
		After data[i+1]=4
		[2, 8, 4, 11, 13, 9, 14, 5, 10, 7, 12, 6, 15, 3]   << 4 is smaller than 11
		Before data[i+1]=4
		data[i]=8
		data[i+1]=8
		First i=1
		After i=0
		After data[i+1]=4
		[2, 4, 8, 11, 13, 9, 14, 5, 10, 7, 12, 6, 15, 3]    << 4 is smaller than 8
		----------------------------------------------------------------------------
		Key=9
		i = 4
		Before data[i+1]=9
		data[i]=13
		data[i+1]=13
		First i=4
		After i=3
		After data[i+1]=9
		[2, 4, 8, 11, 9, 13, 14, 5, 10, 7, 12, 6, 15, 3]
		Before data[i+1]=9
		data[i]=11
		data[i+1]=11
		First i=3
		After i=2
		After data[i+1]=9
		[2, 4, 8, 9, 11, 13, 14, 5, 10, 7, 12, 6, 15, 3]
		----------------------------------------------------------------------------
		Key=14
		i = 5
		----------------------------------------------------------------------------
		Key=5
		i = 6
		Before data[i+1]=5
		data[i]=14
		data[i+1]=14
		First i=6
		After i=5
		After data[i+1]=5
		[2, 4, 8, 9, 11, 13, 5, 14, 10, 7, 12, 6, 15, 3]
		Before data[i+1]=5
		data[i]=13
		data[i+1]=13
		First i=5
		After i=4
		After data[i+1]=5
		[2, 4, 8, 9, 11, 5, 13, 14, 10, 7, 12, 6, 15, 3]
		Before data[i+1]=5
		data[i]=11
		data[i+1]=11
		First i=4
		After i=3
		After data[i+1]=5
		[2, 4, 8, 9, 5, 11, 13, 14, 10, 7, 12, 6, 15, 3]
		Before data[i+1]=5
		data[i]=9
		data[i+1]=9
		First i=3
		After i=2
		After data[i+1]=5
		[2, 4, 8, 5, 9, 11, 13, 14, 10, 7, 12, 6, 15, 3]
		Before data[i+1]=5
		data[i]=8
		data[i+1]=8
		First i=2
		After i=1
		After data[i+1]=5
		[2, 4, 5, 8, 9, 11, 13, 14, 10, 7, 12, 6, 15, 3]
		----------------------------------------------------------------------------
		Key=10
		i = 7
		Before data[i+1]=10
		data[i]=14
		data[i+1]=14
		First i=7
		After i=6
		After data[i+1]=10
		[2, 4, 5, 8, 9, 11, 13, 10, 14, 7, 12, 6, 15, 3]
		Before data[i+1]=10
		data[i]=13
		data[i+1]=13
		First i=6
		After i=5
		After data[i+1]=10
		[2, 4, 5, 8, 9, 11, 10, 13, 14, 7, 12, 6, 15, 3]
		Before data[i+1]=10
		data[i]=11
		data[i+1]=11
		First i=5
		After i=4
		After data[i+1]=10
		[2, 4, 5, 8, 9, 10, 11, 13, 14, 7, 12, 6, 15, 3]
		----------------------------------------------------------------------------
		Key=7
		i = 8
		Before data[i+1]=7
		data[i]=14
		data[i+1]=14
		First i=8
		After i=7
		After data[i+1]=7
		[2, 4, 5, 8, 9, 10, 11, 13, 7, 14, 12, 6, 15, 3]
		Before data[i+1]=7
		data[i]=13
		data[i+1]=13
		First i=7
		After i=6
		After data[i+1]=7
		[2, 4, 5, 8, 9, 10, 11, 7, 13, 14, 12, 6, 15, 3]
		Before data[i+1]=7
		data[i]=11
		data[i+1]=11
		First i=6
		After i=5
		After data[i+1]=7
		[2, 4, 5, 8, 9, 10, 7, 11, 13, 14, 12, 6, 15, 3]
		Before data[i+1]=7
		data[i]=10
		data[i+1]=10
		First i=5
		After i=4
		After data[i+1]=7
		[2, 4, 5, 8, 9, 7, 10, 11, 13, 14, 12, 6, 15, 3]
		Before data[i+1]=7
		data[i]=9
		data[i+1]=9
		First i=4
		After i=3
		After data[i+1]=7
		[2, 4, 5, 8, 7, 9, 10, 11, 13, 14, 12, 6, 15, 3]
		Before data[i+1]=7
		data[i]=8
		data[i+1]=8
		First i=3
		After i=2
		After data[i+1]=7
		[2, 4, 5, 7, 8, 9, 10, 11, 13, 14, 12, 6, 15, 3]
		----------------------------------------------------------------------------
		Key=12
		i = 9
		Before data[i+1]=12
		data[i]=14
		data[i+1]=14
		First i=9
		After i=8
		After data[i+1]=12
		[2, 4, 5, 7, 8, 9, 10, 11, 13, 12, 14, 6, 15, 3]
		Before data[i+1]=12
		data[i]=13
		data[i+1]=13
		First i=8
		After i=7
		After data[i+1]=12
		[2, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 6, 15, 3]
		----------------------------------------------------------------------------
		Key=6
		i = 10
		Before data[i+1]=6
		data[i]=14
		data[i+1]=14
		First i=10
		After i=9
		After data[i+1]=6
		[2, 4, 5, 7, 8, 9, 10, 11, 12, 13, 6, 14, 15, 3]
		Before data[i+1]=6
		data[i]=13
		data[i+1]=13
		First i=9
		After i=8
		After data[i+1]=6
		[2, 4, 5, 7, 8, 9, 10, 11, 12, 6, 13, 14, 15, 3]
		Before data[i+1]=6
		data[i]=12
		data[i+1]=12
		First i=8
		After i=7
		After data[i+1]=6
		[2, 4, 5, 7, 8, 9, 10, 11, 6, 12, 13, 14, 15, 3]
		Before data[i+1]=6
		data[i]=11
		data[i+1]=11
		First i=7
		After i=6
		After data[i+1]=6
		[2, 4, 5, 7, 8, 9, 10, 6, 11, 12, 13, 14, 15, 3]
		Before data[i+1]=6
		data[i]=10
		data[i+1]=10
		First i=6
		After i=5
		After data[i+1]=6
		[2, 4, 5, 7, 8, 9, 6, 10, 11, 12, 13, 14, 15, 3]
		Before data[i+1]=6
		data[i]=9
		data[i+1]=9
		First i=5
		After i=4
		After data[i+1]=6
		[2, 4, 5, 7, 8, 6, 9, 10, 11, 12, 13, 14, 15, 3]
		Before data[i+1]=6
		data[i]=8
		data[i+1]=8
		First i=4
		After i=3
		After data[i+1]=6
		[2, 4, 5, 7, 6, 8, 9, 10, 11, 12, 13, 14, 15, 3]
		Before data[i+1]=6
		data[i]=7
		data[i+1]=7
		First i=3
		After i=2
		After data[i+1]=6
		[2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 3]
		----------------------------------------------------------------------------
		Key=15
		i = 11
		----------------------------------------------------------------------------
		Key=3
		i = 12
		Before data[i+1]=3
		data[i]=15
		data[i+1]=15
		First i=12
		After i=11
		After data[i+1]=3
		[2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 3, 15]
		Before data[i+1]=3
		data[i]=14
		data[i+1]=14
		First i=11
		After i=10
		After data[i+1]=3
		[2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 3, 14, 15]
		Before data[i+1]=3
		data[i]=13
		data[i+1]=13
		First i=10
		After i=9
		After data[i+1]=3
		[2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 3, 13, 14, 15]
		Before data[i+1]=3
		data[i]=12
		data[i+1]=12
		First i=9
		After i=8
		After data[i+1]=3
		[2, 4, 5, 6, 7, 8, 9, 10, 11, 3, 12, 13, 14, 15]
		Before data[i+1]=3
		data[i]=11
		data[i+1]=11
		First i=8
		After i=7
		After data[i+1]=3
		[2, 4, 5, 6, 7, 8, 9, 10, 3, 11, 12, 13, 14, 15]
		Before data[i+1]=3
		data[i]=10
		data[i+1]=10
		First i=7
		After i=6
		After data[i+1]=3
		[2, 4, 5, 6, 7, 8, 9, 3, 10, 11, 12, 13, 14, 15]
		Before data[i+1]=3
		data[i]=9
		data[i+1]=9
		First i=6
		After i=5
		After data[i+1]=3
		[2, 4, 5, 6, 7, 8, 3, 9, 10, 11, 12, 13, 14, 15]
		Before data[i+1]=3
		data[i]=8
		data[i+1]=8
		First i=5
		After i=4
		After data[i+1]=3
		[2, 4, 5, 6, 7, 3, 8, 9, 10, 11, 12, 13, 14, 15]
		Before data[i+1]=3
		data[i]=7
		data[i+1]=7
		First i=4
		After i=3
		After data[i+1]=3
		[2, 4, 5, 6, 3, 7, 8, 9, 10, 11, 12, 13, 14, 15]
		Before data[i+1]=3
		data[i]=6
		data[i+1]=6
		First i=3
		After i=2
		After data[i+1]=3
		[2, 4, 5, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
		Before data[i+1]=3
		data[i]=5
		data[i+1]=5
		First i=2
		After i=1
		After data[i+1]=3
		[2, 4, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
		Before data[i+1]=3
		data[i]=4
		data[i+1]=4
		First i=1
		After i=0
		After data[i+1]=3
		[2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
		[2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
	*/
	
		
		System.out.println(Arrays.toString(data));
		for(int j = 1;j<data.length;j++){
			int key = data[j];
			int i = j-1;
			while(i>=0 && data[i]>key){
				data[i+1] = data[i];
				i = i-1;
				data[i+1]=key;
			}
		}
		/*
		 * Detailed explanation of Insertion sort.
		 * for(int j = 1;j<len;j++){
			System.out.println("----------------------------------------------------------------------------");
			key = data[j];
			System.out.println("Key="+key);
			i = j-1;
			System.out.println("i = "+i);
			while(i>=0 && data[i]>key){
				System.out.println("Before data[i+1]="+data[i+1]);
				data[i+1] = data[i];
				System.out.println("data[i]="+data[i]);
				System.out.println("data[i+1]="+data[i+1]);
				System.out.println("First i="+i);
				i = i-1;
				System.out.println("After i="+i);
				data[i+1]=key;
				System.out.println("After data[i+1]="+data[i+1]);
				System.out.println(Arrays.toString(data));
			}
		}
		for(i=1;i<data.length;i++)
		{
			key=data[i];
			System.out.println(key);
			while(i>0 && data[i-1]>key) {
				int j=data[i];
				data[i]=data[i-1];
				data[i-1]=j;
				--i;
			    System.out.println(Arrays.toString(data));
			}	
		}*/
		return data;
	}

	public static int[] InsertionSort1(int[] data){
		return data;
	}
	public static void main(String[] args){
		int []arra = {8,2,13,11,4,9,14,5,10,7,12,6,15,3};
		arra = InsertionSort(arra);
		System.out.println(Arrays.toString(arra));
	}
}
