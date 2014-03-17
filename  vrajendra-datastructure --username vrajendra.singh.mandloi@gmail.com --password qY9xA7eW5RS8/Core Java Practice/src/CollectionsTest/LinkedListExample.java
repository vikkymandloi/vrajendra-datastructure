package CollectionsTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(1);
		l1.add(7);
		l1.add(4);
		l1.add(3);
		l1.add(5);
		l1.add(2);
		l1.addFirst(23);
		l1.addLast(25);
		l1.add(2, 24);
		System.out.println(l1.subList(2, 6));
		System.out.println(l1.size());
		Collections.sort(l1);

		Iterator<Integer> it = l1.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
