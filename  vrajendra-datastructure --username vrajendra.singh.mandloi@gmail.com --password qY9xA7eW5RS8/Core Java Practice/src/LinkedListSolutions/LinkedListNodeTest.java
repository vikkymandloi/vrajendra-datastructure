package LinkedListSolutions;

class LinkedListNode{
	private String name;
	private LinkedListNode next;

	public LinkedListNode(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LinkedListNode getNext() {
		return next;
	}
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
}

class ListNodeCall{
	private LinkedListNode first;
	private int counter;

	public ListNodeCall(){
		first = new LinkedListNode(null);
		counter=0;
	}
	
	public void addNode(String data){		// add a node.
		LinkedListNode newnode = new LinkedListNode(data);
		LinkedListNode prevnode = first;
		while(prevnode.getNext()!=null)
		{ 
			prevnode = prevnode.getNext();
		}
		prevnode.setNext(newnode);
		counter++;
	}

	public void addNode(String data, int index){	// add a node at index.
		LinkedListNode newnode = new LinkedListNode(data);
		LinkedListNode prevnode = first;
		for(int i=0;i<index-1;i++){
			prevnode = prevnode.getNext();		// reaching the index node.
		}
		newnode.setNext(prevnode.getNext());	// set next for the previous node from previous.getnext()
		prevnode.setNext(newnode);				// setting previous node to the new node.
		counter++;
	}

	public void removeNode(int index){
		LinkedListNode prevnode = first;
		for(int i=0;i<index-1;i++){
			prevnode = prevnode.getNext();		// reaching the index node.
		}
		prevnode.setNext(prevnode.getNext().getNext());	// skipping one position and assigning the pointer to the next position.
		counter--;
	}

	public int size(){	// get the size of a counter
		return counter;
	}

	public String get(int index){	// get the calue of Node at the specified index.
		String str;
		LinkedListNode prevnode = first.getNext();
		for(int i=0;i<index-1;i++){
			prevnode = prevnode.getNext();		// reaching the index node.
		}
		str = prevnode.getName();
		return str;
	}

	public LinkedListNode getNode(int index){	// provides the node at given index.
		String str;
		LinkedListNode prevnode = first.getNext();
		for(int i=0;i<index-1;i++){
			prevnode = prevnode.getNext();		// reaching the index node.
		}
		return prevnode;
	}

	// Swapping the Kth node from first and last alike.
	public void specialSwap(int index){
		if(index<0 || index>size())
			return;
		LinkedListNode frontnode = first.getNext();
		LinkedListNode lastnode = first.getNext();
		frontnode = getNode(index);				// obtain the first node
		lastnode = getNode(size()-index+1);		// obtain the last node

		// Swap the Nodes values. no need  of breaking the nodes.
		String temp = frontnode.getName();
		frontnode.setName(lastnode.getName());
		lastnode.setName(temp);
	}

	@Override
	public String toString() {
		LinkedListNode travnode = first.getNext();
		String output = "";
		while(travnode != null)
		{
			output += travnode.getName() + " ";
			travnode = travnode.getNext();
		}
		return output;
	}
}

public class LinkedListNodeTest {

	public static void main(String[] args) {
		ListNodeCall l1 = new ListNodeCall();
		for(int i=65;i<91;i++){
			l1.addNode(String.valueOf((char)i));
		}
		System.out.println(l1.toString());
		System.out.println("Size of list :: "+l1.size());
		l1.specialSwap(23);
		System.out.println("After swap :: "+l1.toString());
	}
}
