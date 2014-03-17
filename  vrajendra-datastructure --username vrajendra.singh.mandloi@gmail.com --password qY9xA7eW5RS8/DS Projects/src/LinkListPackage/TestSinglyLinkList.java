package LinkListPackage;

public class TestSinglyLinkList {

	public static void main(String[] args) {
		SinglyLinkList list1 = new SinglyLinkList();
		list1.addFirst(123);
		list1.addFirst(989);
		list1.addFirst(345);
		list1.addFirst(742);
		list1.addFirst(455);
		
		list1.addFirst(789);
		list1.addFirst(665);
		list1.addFirst(445);
		list1.addFirst(321);
		list1.addFirst(653);
		
		list1.sort();
		list1.Display();
	}
}
