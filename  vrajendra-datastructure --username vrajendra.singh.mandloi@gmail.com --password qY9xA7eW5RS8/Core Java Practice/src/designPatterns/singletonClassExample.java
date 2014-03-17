package designPatterns;

class Foo {  
	private static Foo instance;  
	public static synchronized Foo getInstance() {  
		return (instance != null) ? instance : new Foo();  
	}  
	public Foo() {  
		synchronized (Foo.class) {  
			if (instance != null) {  
				throw new IllegalStateException();  
			}  
			instance = this;  
		}  
	}  
}  
// singleton class with public constructor.. 

public class singletonClassExample {
	
	public static void main(String[] args) {
		Foo f1 = new Foo();
		Foo f2 = new Foo();
		//Foo f3 = new Foo();
		
		System.out.println(f1.hashCode());
		System.out.println(f2.hashCode());
		//System.out.println(f3.hashCode());
	}
}
