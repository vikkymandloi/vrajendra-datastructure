package StringsPkg;

public class PermutationOfString {
	// 
	public static boolean ispermute(String str1, String str2){
		int[] count = new int[256];
		for(char c: str1.toCharArray())
			++count[c];
		for(char c: str2.toCharArray())
		{
			if(count[c]==0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(ispermute("aasddg", "aagsdd"));
	}
}
