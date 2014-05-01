package LinkedListTESTING;

import java.util.Arrays;

class Node{
	private int value;
	private Node next;
	private int size=1;
	
	public Node(int value) {
		this.value = value;
	}

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	// Add operation to be performed on a list.
	public void addLast(int value){
		for(Node node = this; node != null; node = node.next){
			if(node.next == null){
				node.next = new Node(value);
				size++;
				break;
			}
		}
	}
	
	public void addLast(Node list){
		for(Node node = this; node != null; node = node.next){
			if(node.next == null){
				node.next = list;
				size += list.size;
				break;
			}
		}
	}

	public static Node MergeSort(Node n1, Node n2){
		n1.addLast(n2);
		int [] array = new int[n1.size];
		int count = 0;
		
		for(Node node = n1; node != null; node = node.next){
			array[count] = node.value;
			count++;
		}
		
		Arrays.sort(array);
		count = 0;
		for(Node node = n1; node != null; node = node.next){
			node.value= array[count];
			count++;
		}

		return n1;
	}
	
	public void Display(){
		for(Node node= this; node != null; node = node.next){
			System.out.print(node.value+" - ");
		}
	}
}

public class LinkNode {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.addLast(2);
		head.addLast(7);
		head.addLast(4);
		head.addLast(3);

		Node head2 = new Node(8);
		head2.addLast(6);
		head2.addLast(4);
		head2.addLast(2);
		head2.addLast(5);

		Node sortmerge = Node.MergeSort(head, head2);
		sortmerge.Display();
	}
}
