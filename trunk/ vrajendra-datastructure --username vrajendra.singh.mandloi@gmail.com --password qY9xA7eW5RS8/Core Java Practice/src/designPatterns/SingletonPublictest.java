package designPatterns;

class HelloSingle
{
	static HelloSingle h1 = new HelloSingle();
	public HelloSingle()
	{
		h1 = instance();
	}
	public static HelloSingle instance()
	{
		if(h1==null)
			h1=new HelloSingle();
		return h1;
	}
}
public class SingletonPublictest {

	public static void main(String[] args) {
		HelloSingle h2 = new HelloSingle();
		//HelloSingle h3 = new HelloSingle();
		//HelloSingle h4 = new HelloSingle();

		System.out.println(h2.hashCode());
		//System.out.println(h3.hashCode());
		//System.out.println(h4.hashCode());
	}
}
