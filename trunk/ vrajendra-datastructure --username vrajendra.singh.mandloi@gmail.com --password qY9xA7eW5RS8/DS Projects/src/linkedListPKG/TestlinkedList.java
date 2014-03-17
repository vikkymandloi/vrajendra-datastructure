package linkedListPKG;

/* this is a simple linked list with 
*/
public class TestlinkedList {

	LINKEDLISTNODE start = new LINKEDLISTNODE(1);
	LINKEDLISTNODE node = start;

	public void addnodes(Integer value){
		//node = node.next = new LINKEDLISTNODE(value);
		LINKEDLISTNODE newnode = new LINKEDLISTNODE(value);
		node.next = newnode;
		node = node.next;
	}

	public void addatindex(Integer value, int index){
		LINKEDLISTNODE newnode = new LINKEDLISTNODE(value);
		LINKEDLISTNODE node = start;
		for(int i=0;i<index-1;i++) {
			node = node.next;
		}
		newnode.next = node.next;
		node.next = newnode;
		
	}

	private void display() {
		for(LINKEDLISTNODE node = start; node != null; node = node.next){
			System.out.println(node.val);
		}
	}

	public static void main(String[] args) {
		TestlinkedList t1 = new TestlinkedList();
		t1.addnodes(12);
		t1.addnodes(23);
		t1.addnodes(34);
		t1.addnodes(56);
		t1.addnodes(123);
		t1.addnodes(687);
		t1.addnodes(987);
		t1.addatindex(432,4);
		t1.display();		
		t1.addnodes(879);
		t1.addnodes(189);
		t1.display();
	}
}
