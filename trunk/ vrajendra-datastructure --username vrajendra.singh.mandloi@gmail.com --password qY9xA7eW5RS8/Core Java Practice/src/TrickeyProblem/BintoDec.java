package TrickeyProblem;

public class BintoDec {

	public static void dec(int n){
		if(n==1 || n==0){
			System.out.print(n);
			return;
			}
		if(n%2==0)
			System.out.print(0);
		else
			System.out.print(1);
		System.out.println();
		System.out.println(Integer.toBinaryString(n));
		System.out.println();
		//dec(n/2);
	}
	
	public static void main(String[] args) {
		//dec(156);
		System.out.println("        hey hi this is Vrajendra    ".trim());
	}
}
