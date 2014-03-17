package CollectionsPKG;

import java.util.HashSet;
import java.util.Set;

public class SetTestImplementation {
	// Set implementations 
	public static void main(String[] args) {
		//Collection<String> s1 = new HashSet<String>(); // Set implementation
		Set<String> s1 = new HashSet<String>(); // Set Implementation but no order stable
		//Set<String> s1 = new TreeSet<String>(); // Set Implementation sorted order
		//Set<Integer> s1 = new LinkedHashSet<Integer>(); // Set Implementation store the value in the order inserted
		
		String[] arr = new String[500];
		s1.add("Vrajendra");
		s1.add("Devesh");
		s1.add("Sourabh");
		s1.add("Vishal");
		s1.add("Vrajendra");
		s1.add("Anoop");
		/*s1.add(123);
		s1.add(234);
		s1.add(345);
		s1.add(456);
		s1.add(567);
		s1.add(678);*/
		
		//s1 = Collections.synchronizedSortedSet((SortedSet<String>) s1);
		arr = s1.toArray(arr);  // the type should be same
		//System.out.println(Arrays.toString(arr));
		System.out.println(s1.toString());
		s1.remove("Vrajendra");
		
		//s1 = Collections.synchronizedSet(s1);
		System.out.println(s1.toString());
	}
}
