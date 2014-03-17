package StringsPkg;

public class StringMemoryRep {

	public static void main(String[] args) {
		String s1;
		s1 = new String();
		String s2 = new String();
		// only variables are created till this point no memory point is used.
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		s1 = "Hello";	//<<<<<- here is the place where memory reference is provided to the variable.
		s2 = "Hello";
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
}
