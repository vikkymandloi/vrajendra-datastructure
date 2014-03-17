package CollectionsPKG;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTestImplementation {

	public static void main(String[] args) {
		// Stack Implementation
		Stack<String> str = new Stack<String>();
		str.add("Vrajendra");
		str.push("Decesh");
		str.add("Vishal");
		str.push("Sourabh");
		
		System.out.println(str.toString());
		str.pop();
		System.out.println(str.toString());
		System.out.println(str.peek());
		
		// Queue Implementation
		Queue<String> que = new LinkedList<String>();
		//Queue<String> que = new PriorityQueue<String>();
		que.add("Vrajendra");
		que.add("Hello");
		que.add("this is great");
		que.poll();
		que.poll();
		que.poll();
		que.poll();
		System.out.println(que.toString());
		
	}
}
