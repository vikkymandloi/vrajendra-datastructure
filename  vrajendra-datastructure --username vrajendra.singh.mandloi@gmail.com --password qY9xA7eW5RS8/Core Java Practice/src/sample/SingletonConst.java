package sample;

class Singgleton
{
	private static Singgleton instance = null;
	
	private Singgleton()
	{	}
	
	public Singgleton(Singgleton a1){
		if(a1 == null) {
			a1 = new Singgleton();
			a1=instance;
		}
		a1=instance;
	}
	
	public Singgleton getInstance(Singgleton a1)
	{
		if (a1 instanceof Singgleton) {
			Singgleton instance = (Singgleton) a1;
		}
		return instance;
	}
}

public class SingletonConst {
	static String s1 = "";
	static public void hellpo(){
		s1 = "Hello";
		System.out.println(s1);
		System.out.println(s1.hashCode());
		s1 = "Hello World";
		System.out.println(s1);
		System.out.println(s1.hashCode());
	}
	
	
	public static void main(String[] args) {
		/*Singgleton s1 = null;
		s1=new Singgleton(s1);
		Singgleton s2 = null;
		s2=new Singgleton(s1);
		*/
		
		new SingletonConst().hellpo();
	}
}
