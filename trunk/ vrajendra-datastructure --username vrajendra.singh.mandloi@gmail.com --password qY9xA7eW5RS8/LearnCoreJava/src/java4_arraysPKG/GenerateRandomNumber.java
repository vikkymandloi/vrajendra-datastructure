package java4_arraysPKG;

import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class GenerateRandomNumber {
	static long seed = 0; 

	public static void main(String[] args) 
	{
		int r = randomn(20);
		System.out.println(r); 
		System.out.println(System.nanoTime());
	} 

	static private int randomn(int n) 
	{
		Date dt = new Date();
		
		int reandomnum = 0; 
		long m = System.currentTimeMillis() +dt.getSeconds() + 60 * dt.getMinutes() + 3600 * dt.getHours(); 
		if(seed == 0) { 
			seed = m; 
		} 
		reandomnum = (int) (m + seed) % n; 
		return reandomnum; 
	} 
}
