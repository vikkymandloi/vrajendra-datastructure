/*package linkedListPKG;

class Linknode{
	Integer value;
	Linknode next;

	public Linknode(){	}

	// Cons Operation in JAVA
	public Linknode(Integer value,Linknode next){
		this.value = value;
		this.next = next;
	}

	public Linknode(Integer value){
		this(value,null);
	}

	// to insert an element after a particular node.
	public void insertAfter(int value){
		this.next = new Linknode(value, this.next); 
	}

	// to Display all nodes available.
	public void displayList(){
		for(Linknode node=this; node != null; node = node.next)
			System.out.println(node.value);
	}

	// to find the position of a Node value in a list
	public Linknode findNth(int position){
		if(position == 1)
			return this;
		if((position < 1) || (this.next == null))
			return null;
		// recursive till the position comes to 1 and then the current pointer will be passed
		return this.next.findNth(position-1);
	}

	// to find the node at a particular position in a list
	public Linknode findNthsimple(int position){
		int index = 1;
		for (Linknode node = this; node != null; node = node.next) {
			if (index==position)	// equals operation will validate the values inside Integer object
				return node;
			index++;
		}
		return null;
	}

	// to find the position of a given value.
	public int indexOf(Integer obj) {
		int index = 1;
		for (Linknode node = this; node != null; node = node.next) {
			if (obj.equals(node.value))	// equals operation will validate the values inside Integer object
				return index;
			index++;
		}
		return -1;
	}
}

public class LinkBarclay1 {
	// to display the Linked List we need to use Recursion. This is a recursive data type


	public static void main(String[] args) {
		Linknode l1 = new Linknode(), l2 = new Linknode(), l3 = new Linknode();
		l1.value = 123;
		l2.value = 234;
		l3.value = 345;
		l1.next = l2;
		l2.next = l3;
		l3.next = null;

		l2.insertAfter(567);// this line will insert an element after L2.
		l2.insertAfter(890);// this will add a value after l2 and the next of preious l2 i.e. 567 will now be pointing to this node.
		l1.next.insertAfter(654); // this will add a element after l1.next i.e. after l2.

		for(int i=0;i<10;i++){
			l2.insertAfter(i+100);
		}

		//System.out.println(l2.next.value);
		//we can create the same list as above in one shot just by writing 
		//Linknode list1 = new Linknode(123, new Linknode(234, new Linknode(345, null)));

		// to Display the list
		l1.displayList();
		// Display the list from beginning and finding the 4th element from the starting of list

		System.out.println("1th value in a list is == "+l1.findNth(1).value);
		System.out.println("4th value in a list is == "+l1.findNth(4).value);
		System.out.println("16th value in a list is == "+l1.findNth(16).value);
		//System.out.println("20th value in a list is == "+l1.findNth(20).value);
		//System.out.println("-ve value in a list is == "+l1.findNth(-0).value);
		// Display the list from beginning and finding the 4th element from the new start which is L2 now.
		System.out.println("1th value in a new list starting from L2 is == "+l2.findNthsimple(1).value);
		System.out.println("4th value in a new list starting from L2 is == "+l2.findNthsimple(4).value);
		System.out.println("15th value in a new list starting from L2 is == "+l2.findNthsimple(15).value);
		//System.out.println("16th value in a new list starting from L2 is == "+l2.findNthsimple(16).value);
		//System.out.println("-ve value in a new list starting from L2 is == "+l2.findNthsimple(-0).value);
		// to find the position of a value in the list
		System.out.println("position of 123 in the list = "+l1.indexOf(123));
		System.out.println("position of 345 in the list = "+l1.indexOf(345));
		System.out.println("position of 103 in the list = "+l1.indexOf(103));
		System.out.println("position of 1233 in the list = "+l1.indexOf(1233));
	}
}
*/