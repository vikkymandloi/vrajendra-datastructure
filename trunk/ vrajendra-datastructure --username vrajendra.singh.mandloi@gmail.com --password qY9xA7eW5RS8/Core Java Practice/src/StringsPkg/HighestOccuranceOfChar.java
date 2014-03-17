package StringsPkg;

public class HighestOccuranceOfChar {

	public static char highestOccurance(String str){
		char[] str1 = str.toCharArray();
		int[] occ = new int[123];
		for(int i=0;i<str1.length;i++){
			++occ[str1[i]];
		}
		int largest = occ[0], index = 0;
		for (int i = 1; i < occ.length; i++) 
		{
			if(occ[i] > largest){
				largest = occ[i];
				index = i;
			}
		}
		return (char)index;
	}

	public static void main(String[] args) {
		String str = "abcdefgaaaaasdsddaaaaggeeeettttthhggfffwwggggZZZZZZZZZ";
		System.out.println(highestOccurance(str));
	}
}
