package StringsPkg;

public class RemoveDuplicatesfromString {
// this program will not even allow the spaces or the dots to come next time.
	public static void main(String[] args) {
		String str = "this is the game and i need to play it with full dedication.. Winners Win coz they FOCUS";
		int[] count = new int[256];
		String str1 = "";
		for(char c: str.toCharArray()){
			if(count[c]>0) 
				continue;
			else
			{
				str1+=c;
				count[c]++;
			}
		}
		System.out.println(str1);
	}
}
