package LinkedListSolutions;

public class LinkedListImpl {

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.add("Vrajendra");
		l1.add("Singh");
		l1.add("Mandloi");
		l1.add("The");
		l1.add("Great");
		l1.add("Gatsby");
		l1.add("Gatsby3",3);
		
		System.out.println(l1.get(3));
		System.out.println(l1.toString());
	}
}
