package RecursionPackage;

public class SumRecursionSeries {

	/*public int sumSeries(int count, int y){
		if(count<1)
			return y;
		return count + sumSeries(count-1,y);
	}// this function gives the sum of x(x+1)/2 + y=?;
	*/
	
	public int sumSeries(int count, int y){
		if(count<1)
			return y;
		return sumSeries(count-1,count+y);
	}
	// this function gives the sum of x(x+1)/2 + y=?;
	
	public static void main(String[] args) {
		System.out.println(new SumRecursionSeries().sumSeries(5,2));
	}
}
