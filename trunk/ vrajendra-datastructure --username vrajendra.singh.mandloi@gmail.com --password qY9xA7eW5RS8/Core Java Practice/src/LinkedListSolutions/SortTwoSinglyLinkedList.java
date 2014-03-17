package LinkedListSolutions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class LinkedNode{
	private Object number;
	private LinkedNode next;

	public LinkedNode(Object number){
		this.setNumber(number);
	}
	public void setNumber(Object number) {
		this.number = number;
	}
	public Object getNumber() {
		return number;
	}
	public void setNext(LinkedNode next) {
		this.next = next;
	}
	public LinkedNode getNext() {
		return next;
	}
}

class LinkedCall{
	private LinkedNode first;
	private int counter;
	
	public LinkedCall(){
		first = new LinkedNode(null);
		counter=0;
	}
	
	public void addNode(Object data){		// add a node.
		LinkedNode newnode = new LinkedNode(data);
		LinkedNode prevnode = first;
		while(prevnode.getNext()!=null)
		{ 
			prevnode = prevnode.getNext();
		}
		prevnode.setNext(newnode);
		counter++;
	}
	
	public void addNode(Object data, int index){	// add a node at index.
		LinkedNode newnode = new LinkedNode(data);
		LinkedNode prevnode = first;
		for(int i=0;i<index-1;i++){
			prevnode = prevnode.getNext();		// reaching the index node.
		}
		newnode.setNext(prevnode.getNext());	// set next for the previous node from previous.getnext()
		prevnode.setNext(newnode);				// setting previous node to the new node.
		counter++;
	}

	public void removeNode(int index){
		LinkedNode prevnode = first;
		for(int i=0;i<index-1;i++){
			prevnode = prevnode.getNext();		// reaching the index node.
		}
		prevnode.setNext(prevnode.getNext().getNext());	// skipping one position and assigning the pointer to the next position.
		counter--;
	}

	public int size(){	// get the size of a counter
		return counter;
	}

	public Object get(int index){	// get the calue of Node at the specified index.
		Object str;
		LinkedNode prevnode = first.getNext();
		for(int i=0;i<index-1;i++){
			prevnode = prevnode.getNext();		// reaching the index node.
		}
		str = prevnode.getNumber();
		return str;
	}

	public LinkedNode getNode(int index){	// provides the node at given index.
		LinkedNode prevnode = first.getNext();
		for(int i=0;i<index-1;i++){
			prevnode = prevnode.getNext();		// reaching the index node.
		}
		return prevnode;
	}
	
	public LinkedNode[] getNodes(){	// provides the node at given index.
		LinkedNode[] node = new LinkedNode[counter];
		LinkedNode travNode = first.getNext();
		for(int i=0;i<counter;i++){
			travNode = travNode.getNext();  
			node[i] = travNode;
		}
		return node;
	}

	@Override
	public String toString() {
		LinkedNode travnode = first.getNext();
		String output = "";
		LinkedList l1 = new LinkedList();

		while(travnode != null)
		{
			output += travnode.getNumber() + " -> ";
			travnode = travnode.getNext();
		}
		return output;
	}	
}

public class SortTwoSinglyLinkedList {

	//Merge sort for 2 linked list.
	public static LinkedList sort(LinkedCall l1, LinkedCall l2){
		LinkedList list = new LinkedList();
		
		System.out.println(list.toString());
		return list;
	}
	
	public static void main(String[] args) {
		LinkedCall l1 = new LinkedCall();
		l1.addNode(1);
		l1.addNode(2);
		l1.addNode(3);
		l1.addNode(4);
		l1.addNode(5);
		LinkedCall l2 = new LinkedCall();
		l2.addNode(3);
		l2.addNode(4);
		l2.addNode(5);

		sort(l1, l2);
		System.out.println(l1.toString());
		System.out.println(l2.toString());
	}
}
