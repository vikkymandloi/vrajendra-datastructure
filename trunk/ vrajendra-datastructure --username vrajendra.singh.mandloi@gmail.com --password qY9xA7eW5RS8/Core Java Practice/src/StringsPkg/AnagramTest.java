package StringsPkg;

public class AnagramTest {

	public static boolean anagramt(String str1, String str2){
		int[] count1 = new int[256];
		int[] count2 = new int[256];

		if(str1.length()!=str2.length())
			return false;
		else
		{
			for(int i=0;i<str1.length();i++){
				++count1[str1.charAt(i)];
				++count2[str2.charAt(i)];
			}
			for(int i=0;i<count1.length;i++){
				if(count1[i]!=count2[i])
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(anagramt("asdlkjjjjalskdh", "asdlkjjjjalskdh"));
	}
}
