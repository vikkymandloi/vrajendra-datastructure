package linkedListPKG;

public class SinglyLinkListCallFunc {

	public static void main(String[] args) {
		LinkNode<String> list1 = new LinkNode<String>();
		// create a node using setters and getters.
		list1.setValue("Vrajendra");
		list1.setNext(null);
		// creating node directly calling add method
		list1.add("Ruchi");
		list1.add("Ekta");
		list1.add("Devesh");
		list1.add("Sourabh");
		// creating node at the last.
		list1.addlast("LastIndex");
		// creating node at a specified position.
		list1.addnth(3,	"3rd Position");
		// replacing the value in the node at a position.
		list1.replaceN(4, "My LinkList");
		// delete 1st node.
		//list1.delete1stNode();
		// delete Nth Node
		//list1.deleteNthNode(3);
		// delete an Object
		list1.deleteParticularObject("Vrajendra");
		list1.displayList();
	}

}
