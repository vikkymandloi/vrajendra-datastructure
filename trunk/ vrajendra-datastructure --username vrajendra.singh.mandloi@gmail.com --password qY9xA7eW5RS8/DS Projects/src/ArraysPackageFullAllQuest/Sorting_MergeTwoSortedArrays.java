package ArraysPackageFullAllQuest;

import java.util.ArrayList;
import java.util.List;

public class Sorting_MergeTwoSortedArrays {

	List<Integer> arraylist1 = new ArrayList<Integer>();
	List<Integer> arraylist2 = new ArrayList<Integer>();
	List<Integer> finallist = new ArrayList<Integer>();

	public Sorting_MergeTwoSortedArrays(){
		for(int i=0;i<10;i++)
			arraylist1.add(i);
		for(int i=5; i<15; i++)
			arraylist2.add(i);
	}

	public void merge(){
	    int i = 0, j = 0;

	    while (i < arraylist1.size() && j < arraylist2.size())
	    {
	        if (arraylist1.get(i) < arraylist2.get(j))       
	            finallist.add(arraylist1.get(i++));
	        else   
	        	finallist.add(arraylist2.get(j++));              
	    }
	    while (i < arraylist1.size())  
	    	finallist.add(arraylist1.get(i++));
	    
	    while (j < arraylist2.size())    
	    	finallist.add(arraylist2.get(j++));
	    
	    System.out.println(finallist.toString());
	}

	public static void main(String[] args) {
		Sorting_MergeTwoSortedArrays a1 = new Sorting_MergeTwoSortedArrays();
		a1.merge();
	}
}
