package StringsPkg;

public class ReverseSubstringmatch {

	public static void main(String[] args) {
		String str = "asdfghjklpopliuytdsa";
		char[] str1 = str.toCharArray();
		String[] segments = new String[str1.length-2];
		int length = str1.length;
		for(int i=0;i<length-2;i++){
			segments[i] = String.valueOf(str1[i+2])+String.valueOf(str1[i+1])+String.valueOf(str1[i]);
		}
		for(int i=0;i<segments.length;i++){
			if(str.indexOf(segments[i])!=-1){
				System.out.println(segments[i]);
			}
		}
	}
}
