package RecursionPackageFullAllQuestions;

public class SeriesNsumFunction {

	public static int func(int x, int y){
		if(x==0)
			return y;
		else
			return func(x-1,x+y);
	}
	
	public static void main(String[] args) {
		System.out.println(func(5,2));
	}
}
