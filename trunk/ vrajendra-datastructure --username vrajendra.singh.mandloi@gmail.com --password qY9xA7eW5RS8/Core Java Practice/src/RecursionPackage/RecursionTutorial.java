package RecursionPackage;

public class RecursionTutorial {
	
	public static void helloWorld(int count){
		if(count > 1)
			helloWorld(count-1);
		
		System.out.println("count"+count);
	}
	
	public static void main(String[] args) {
		helloWorld(5);
	}
}
