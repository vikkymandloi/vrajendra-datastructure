package LinkListPackage;

import java.util.Arrays;

public class SinglyLinkList {
	// Node Class for creating a node
	class Node{
		private Integer value;
		private Node next;

		public Node(Integer value){
			this.value = value;
			this.next = null;
		}

		public Node(Integer value, Node next){
			this.value = value;
			this.next = next;
		}
	}

	Node head;
	int size = 0;

	public SinglyLinkList(){
		head = null;
	}

	public void addFirst(Integer value){
		head = new Node(value, head);
		size++;
	}

	public void addLast(Integer value){
		for(Node node = head; node != null; node = node.next){
			if(node.next == null){
				node.next = new Node(value);
				size++;
				break;
			}
		}
	}

	public void addPosition(int position, Integer value){
		int index = 1;
		for(Node node = head; node != null; node = node.next){
			if(position==index)
				node.next = new Node(value, node.next);
			index++;
		}
		size++;
	}

	public void deleteFirst(){
		head = head.next;
		size--;
	}

	public void deleteLast(){
		Node node = head;
		for(int i=1; i<size-1;i++)
			node = node.next;
		node.next=null;
		size--;
	}

	public void deletePosition(int position){
		Node node = head;
		for(int i=1; i<position-1; i++)
			node = node.next;
		node.next=node.next.next;
		size--;
	}

	public Node getNode(int position){
		Node node = head;
		for(int i=1; i<position-1; i++)
			node = node.next;
		return node;
	}

	// Sorting with Merge Sort
	public void sort(){
		Node node = this.head;
		Object [] arr = new Object[this.size];
		for(int i=0; i< this.size; i++)
		{
			arr[i] = node.value;
			node = node.next;
		}
		node = this.head;
		Arrays.sort(arr);
		for(Object a1 : arr){
			node.value = (Integer)a1;
			node = node.next;
		}
	}
	
	public Node joinSorted(Node node1){
		Node node = this.head;
		for(int i=0; i<this.size; i++)
			node = node.next;
		
		node.next = node1;
		return node;
	}
	
	public void Display(){
		for(Node node = head; node!=null; node = node.next){
			System.out.println(node.value);
		}
	}
}
