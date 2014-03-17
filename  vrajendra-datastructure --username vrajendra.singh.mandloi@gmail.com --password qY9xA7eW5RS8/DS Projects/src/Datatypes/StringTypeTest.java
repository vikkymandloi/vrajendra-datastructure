package Datatypes;

public class StringTypeTest {

	public static void main(String[] args) {
		Stringtype st = new Stringtype("Hello");
		System.out.println(st);
	}
}

class Stringtype{
	String str="";
	public Stringtype(String str){
		this.str = str;
	}
	
	@Override
	public String toString() {
		return str;
	}
}
