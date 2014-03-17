package CollectionsPKG;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class ListTestImplementation {

	public static void main(String[] args) {
		//Collection<String> list = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		//List<String> list = new ArrayList<String>();
		//List<String> list = new LinkedList<String>();
		//List<String> list = new Stack<String>();
		//List<String> list = new Vector<String>();
		
		list.add("Vrajendra");
		list.add("Devesh");
		list.add("Sourabh");
		list.add("vishal");
		list.add("anoop");
		list.add("vrajendra");
		
		System.out.println(list.toString());   // Displayed all the elements
		System.out.println(list.indexOf("hello"));
		Collections.sort(list);
		System.out.println(list.toString());
		System.out.println(Collections.binarySearch(list, "-1"));
		System.out.println(Collections.reverseOrder().toString());
		
	}

}
