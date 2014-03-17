package Datatypes;

public class NestedClassTEst {	
	int var1 = 123;
	static int var2 = 234;
	final int var3 = 345;
	static final int var4 = 567;

	class nest1{ //a nested class can access any member of a class
		{
			System.out.println("Hello");
		}
		class nestnest{
			public nestnest(){
				System.out.println(var1);
				System.out.println(var2);
				System.out.println(var3);
				System.out.println(var4);
			}
		}
		
		nest1(){
			System.out.println(var1);
			System.out.println(var2);
			System.out.println(var3);
			System.out.println(var4);
		}
		public void helloworld(){
			System.out.println(var1);
			System.out.println(var2);
			System.out.println(var3);
			System.out.println(var4);
		}
	}
	
	static class nest2{	// static class will only access static member variables of a class.
		
		static{
			System.out.println("Hello");
		}
	
		public nest2(){
			System.out.println(var2);
			System.out.println(var4);
		}
		public void helloworld(){
			System.out.println(var2);
			System.out.println(var4);
		}
	}
	
	final class nest3{ //a nested class can access any member of a class
		
		nest3(){
			System.out.println(var1);
			System.out.println(var2);
			System.out.println(var3);
			System.out.println(var4);
		}
		public void helloworld(){
			System.out.println(var1);
			System.out.println(var2);
			System.out.println(var3);
			System.out.println(var4);
		}
	}
	
	public NestedClassTEst(){
		class nest4{
			{
				System.out.println("Hello");
			}
			nest4(){
				System.out.println(var1);
				System.out.println(var2);
				System.out.println(var3);
				System.out.println(var4);
			}
			public void helloworld(){
				System.out.println(var1);
				System.out.println(var2);
				System.out.println(var3);
				System.out.println(var4);
			}
		}
	}
	
	public NestedClassTEst(int asd){
		final class nest5{	// static class is not permitted inside a constructor
			{
				System.out.println("Hello");
			}
			nest5(){
				System.out.println(var2);
				System.out.println(var4);
			}
			private void helloworld(){
				System.out.println(var2);
				System.out.println(var4);
			}
		}
	}

	public void NestedTEst(){
		class nest6{
			{	System.out.println("Hello");
			}
			nest6(){
				//System.out.println(var1);
				System.out.println(var2);
				//System.out.println(var3);
				System.out.println(var4);
			}
			public void helloworld(){
				//System.out.println(var1);
				System.out.println(var2);
				//System.out.println(var3);
				System.out.println(var4);
			}
		}
	}
	public static void statNestedTEst(){
		class nest7{ 
			{	System.out.println("Hello");
			}
			nest7(){
				//System.out.println(var1);
				System.out.println(var2);
				//System.out.println(var3);
				System.out.println(var4);
			}
			public void helloworld(){
				//System.out.println(var1);
				System.out.println(var2);
				//System.out.println(var3);
				System.out.println(var4);
			}
		}
	}
	public static final void statfinalNestedTEst(){
		class nest7{ 
			{	System.out.println("Hello");
			}
			nest7(){
				//System.out.println(var1);
				System.out.println(var2);
				//System.out.println(var3);
				System.out.println(var4);
			}
			public void helloworld(){
				//System.out.println(var1);
				System.out.println(var2);
				//System.out.println(var3);
				System.out.println(var4);
			}
		}
	}
	public final void finalNestedTEst(){
		class nest7{ 
			{	System.out.println("Hello");
			}
			nest7(){
				//System.out.println(var1);
				System.out.println(var2);
				//System.out.println(var3);
				System.out.println(var4);
			}
			public void helloworld(){
				//System.out.println(var1);
				System.out.println(var2);
				//System.out.println(var3);
				System.out.println(var4);
			}
		}
	}
}
