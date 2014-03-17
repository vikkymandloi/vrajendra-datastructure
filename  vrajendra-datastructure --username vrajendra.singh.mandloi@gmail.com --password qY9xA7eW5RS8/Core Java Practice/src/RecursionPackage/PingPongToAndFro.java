package RecursionPackage;

public class PingPongToAndFro {

	private static final int limit = 1000;

	/*public static void toAndFro(int count){
		if(count > limit)
			return;

		System.out.print(count+" ");
		toAndFro(2*count);
		System.out.print(count+" ");
	}	//100 200 400 800 800 400 200 100 
	*/

	public static void toAndFro(int count){
		if(count < limit)
		{		
			System.out.print(count+"" +
					" ");
			toAndFro(2*count);
		}
		System.out.print(count+" ");
	}	// 100 200 400 800 1600 800 400 200 100 

	public static void main(String[] args) {
		toAndFro(100);
	}

}
