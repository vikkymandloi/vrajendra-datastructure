package LinkedListCareerCup;

public class AddDelNode {
	static LinkedListNode<Integer> node = null;
	
	public AddDelNode(){
		node = new LinkedListNode<Integer>(null);
	}
	
	public static void addNode(int data){
		LinkedListNode<Integer> newnode = new LinkedListNode<Integer>(data);
		while(node.next != null){
			node = node.next;
		}
		node.next = newnode;
	}
	
	public static String displayToString() {
		String str = "";
		LinkedListNode<Integer> l1 = node;
		while(l1.next != null){
			str += l1.data.toString();
			l1 = l1.next;
		}
		return str;
	}
	
	public static void main(String[] args) {
		node = new LinkedListNode<Integer>(5);
		addNode(4);
		addNode(8);
		addNode(6);
		addNode(9);
		addNode(10);
		System.out.println(displayToString());
	}
}
