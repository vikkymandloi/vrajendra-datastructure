package linkedListPKG;

// first node itself is null. 
public class TestEmptystartlinklist {

	LINKEDLISTNODE start = new LINKEDLISTNODE();
	LINKEDLISTNODE node = start;
	
	// Add the nodes End / Front / At index..
	public void addnode(int value){
		node = node.next = new LINKEDLISTNODE(value);
	}
	public void addatBeg(int value){
		LINKEDLISTNODE newnode = new LINKEDLISTNODE(value);
		newnode.next = start.next;
		start.next = newnode;
	}
	public void addatindex(int value, int index){
		LINKEDLISTNODE newnode = new LINKEDLISTNODE(value);
		LINKEDLISTNODE node = start;
		for(int i=0;i<index-1; i++){
			node = node.next;
		}
		newnode.next = node.next;
		node.next = newnode;
	}
	
	// Delete nodes Beg / END / at index
	public void deleteNodeBeg(){
		start.next = start.next.next;
	}
	public void deleteatindex(int index){
		LINKEDLISTNODE node = start;
		for(int i=0;i<index-1;i++){
			node = node.next;
		}
		node.next = node.next.next;
	}
	public void deletelast(){
		node = null;
		return;
	}
	
	// Display
	public void display(){
		for(LINKEDLISTNODE node=start.next;node!=null;node=node.next){
			System.out.println(node.val);
		}
	}
	// Main
	public static void main(String[] args) {
		TestEmptystartlinklist t1 = new TestEmptystartlinklist();
		t1.addnode(12);
		t1.addnode(23);
		t1.addnode(14);
		t1.addnode(256);
		t1.addatindex(342, 2);
		t1.addatBeg(55);
		t1.deleteNodeBeg();
		t1.deleteatindex(5);
		//t1.deletelast();
		t1.addnode(45);
		t1.addnode(74);
		t1.display();
	}
}
