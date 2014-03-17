package StringsPkg;

public class ReverseStringwordbyword {

	public static void main(String[] args) {
		String str = "this is a string.";
		String[] str1 = str.split(" ");
		for(int i=str1.length-1;i>=0;i--){
			System.out.print(str1[i]+" ");
		}
	}
}
