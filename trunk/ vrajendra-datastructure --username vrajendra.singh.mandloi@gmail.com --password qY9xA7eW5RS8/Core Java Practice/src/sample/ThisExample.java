package sample;

public class ThisExample {
	String name;
	
	public ThisExample(String name){
		this.name = name;
	}
	void m(ThisExample obj)
	{
		System.out.println(obj.name);
	}
	void call(){
		m(this);
	}
	
	public static void main(String[] args) {
		ThisExample t1 = new ThisExample("vrajendra");
		t1.call();
		ThisExample t2 = new ThisExample("Animesh");
		t2.call();
		
	}

}
