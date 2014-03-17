package StringsPkg;

public class PalindromeTest {

	public static boolean palindromet(String str1){
		char[] str = str1.toCharArray();
		int length = str1.length()-1;
		for(int i=0;i<str1.length();i++){
			if(str[i] != str[length-i])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(palindromet("asdaadsa"));
	}
}
