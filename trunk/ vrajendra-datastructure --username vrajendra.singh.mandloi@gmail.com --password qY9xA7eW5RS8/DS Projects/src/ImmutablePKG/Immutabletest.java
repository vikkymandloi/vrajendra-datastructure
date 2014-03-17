package ImmutablePKG;

public class Immutabletest {
	public static void main(String[] args) {
		// Check if after changing the content of mutable Class does Hashcode changes.
		MutableClass mc1 = new MutableClass();
		System.out.println("Hash code for Mutable class without values = "+mc1.hashCode());
		mc1.setEmpid(123);
		mc1.setName("Vrajendra");
		System.out.println("Hash code for Mutable class with values = "+mc1.hashCode());
		mc1.setEmpid(2345);
		System.out.println("Hash code for Mutable class changed values = "+mc1.hashCode());
		mc1.setName("klajlsdj");
		System.out.println("Hash code for Mutable class changed values = "+mc1.hashCode());
		
		// Check if after changing the content of IMMUTABLE class does hashcode changes
		IMMutableClass imc1 = new IMMutableClass("Vrajendra", 370251);
		System.out.println("Hash code for IMMUTABLE class with values = "+imc1.hashCode());
		imc1 = new IMMutableClass("Vrajendra", 345);
		System.out.println("Hash code for IMMUTABLE same object with same values but new instance= "+imc1.hashCode());
	}
}
