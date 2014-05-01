package java2_oopsPKG;

class Parent{
	final static int a = 10;
	
	protected void method1(){
		System.out.println("Parent Method");
	}
	
	protected void method3(){
		System.out.println("Parent Method 2");
	}
}

class Child extends Parent{

	public Child(){
		System.out.println(a);
	}
	
	public void method1(){
		System.out.println("Child Method");
	}
	
	public void method2(){
		System.out.println("Child Method 2");
	}
}

public class oop_InheritanceTest {

	public static void main(String[] args) {
		Parent c1 = new Child();
		System.out.println(c1.a);
		c1.method1();
		c1.method3();
		
		Child c2 = new Child();
		System.out.println(c2.a);
		c2.method1();
		c2.method2();
		c2.method3();
		
		/*Child c3 = (Child) new Parent();// downcasting not allowed in java
		c3.method1();
		c3.method2();
		c3.method3();*/
	}
}
