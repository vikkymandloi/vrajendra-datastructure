package StringsPkg;
public class FindLargestRepeated {

	public static int repeated(String str) {
		char [] c = str.toCharArray();
		int runner = 1;
		int position = 0;
		int counter = 1;
		int oldpos = 0;
		int f = 1;

		while(runner < c.length -1) {
			if (c[position] == c[runner] ) {
				counter++;
			} else 
			{
				if (f < counter) 
				{
					f = counter;
					oldpos = position;
				}
				counter = 1;
				position = runner;
			}	
			runner++;
		}
		return oldpos;
	}

	public static void main(String args[]) {
		System.out.println(repeated("abeerrrrrrrrrrrrrrreeeffffeeeeeeeeeegkk"));
	}
}