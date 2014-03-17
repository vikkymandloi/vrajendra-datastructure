package QuestWithAmazon;

import java.util.StringTokenizer;

public class RemoveDuplicates {

	public static void reverseStrring(char[] str){
		
	}
	public static void main(String[] args) {
		String str = "Hello how are you";
		StringTokenizer tokens = new StringTokenizer(str," ");
		str=tokens.nextToken();
		while(tokens.hasMoreTokens()){
			str+= "%20"+tokens.nextToken().toString();
		}
		System.out.println(str);
		
		char[] asd = str.toCharArray();
		System.out.println(asd.length);
		java.lang.reflect.Array.newInstance(asd.getClass().getComponentType(), 6);
		System.out.println(asd.length);
	}
}
