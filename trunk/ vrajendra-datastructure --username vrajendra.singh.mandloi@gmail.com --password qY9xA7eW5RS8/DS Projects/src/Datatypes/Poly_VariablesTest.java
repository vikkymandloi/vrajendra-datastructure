package Datatypes;

class HelloPoly{
	int a = 10;
}

public class Poly_VariablesTest extends HelloPoly{
	int a = 115;
	
	public static void main(String[] args) {
		HelloPoly a1 = new Poly_VariablesTest();
		System.out.println(a1.a);
	}

}
