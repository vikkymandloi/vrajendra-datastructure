package linkedListPKG;

public class LinkedlistTestAll {

	// Node Class Description
	private class LinkNodes<T>{
		T value;
		LinkNodes next;

		public LinkNodes() { }
		public LinkNodes(T value){
			this.value = value;
		}
	}

	// Start node
	LinkNodes<String> start = new LinkNodes<String>();
	LinkNodes<String> node = start;
	Integer size=0;

	/* Operations to be performed on this singly linked list.
	 * 
	 * 1. Addfirst()
	 * 2. AddLast()
	 * 3. AddatIndex()
	 * 4. AddAfterValue()
	 * 4. DeleteFirst()
	 * 5. DeleteLast()
	 * 6. DeleteValue()
	 * 7. DeleteatIndex()
	 * 8. Search()
	 * 9. Sort()
	 * 10. Display()
	 */

	public void addFirst(String value){
		LinkNodes<String> newnode = new LinkNodes<String>(value);
		if(start.next==null)
			start.next = newnode;
		else{
			newnode.next = start.next;
			start.next = newnode;
		}
		size++;
	}

	public void addLast(String value){
		node = node.next = new LinkNodes<String>(value);
		size++;
	}

	public void addAtIndex(String value, int index){
		LinkNodes<String> newnode = new LinkNodes<String>(value);
		LinkNodes<String> node=start;
		for(int i=0;i<index-1;i++)
			node = node.next;
		newnode.next = node.next;
		node.next = newnode;
		size++;
	}

	public void deleteFirst(){

	}

	public void deleteLast(){

	}

	public void deleteValue(String value){

	}

	public void deleteAtIndex(int index){

	}

	public void search(String value){

	}

	public void sortLinkedList(){

	}

	public void display(){
		for(LinkNodes<String> node=start.next; node!=null; node = node.next)
			System.out.print(node.value+" ");
	}

	public static void main(String[] args) {
		LinkedlistTestAll t1 = new LinkedlistTestAll();
		t1.addFirst("Vrajendra");
		t1.addLast("Ruchi");
		t1.addLast("Ekta");
		t1.addLast("MOM");
		t1.addLast("Dad");
		t1.addLast("friends");
		t1.addAtIndex("BETWEEN", 3);
		t1.addLast("ANimesh");
		t1.addLast("Ayush");
		t1.addLast("Sunny");
		t1.display();
	}
}
