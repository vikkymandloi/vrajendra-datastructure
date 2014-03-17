package CollectionsTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionsList {
	
	public static void main(String[] args) {
		//Queue q1 = new ArrayDeque();
		//Deque q1 = new ArrayDeque();
		Queue q1 = new PriorityQueue();
		q1.add(123);
		q1.add(234);
		q1.add(123);
		q1.add(122);
		q1.add(121);
		
		Iterator it = q1.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
