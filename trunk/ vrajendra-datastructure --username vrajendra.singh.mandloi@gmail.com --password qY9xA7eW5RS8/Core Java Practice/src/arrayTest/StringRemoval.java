package arrayTest;
// remove all the characters from one string which are present in other string.
public class StringRemoval {

	public static void main(String[] args) {
		String s1 = "vrajendrasinghmandloi";
		String s2 = "aie";
		
		/*for(int i=0;i<s1.length();i++){
			char key = s1.charAt(i);
			if(s2.indexOf(key)!=-1)
				s1=s1.replaceAll(String.valueOf(key),"");
		}*/
		
		for(int i=0;i<s2.length();i++){
			s1 = s1.replace(String.valueOf(s2.charAt(i)), "");
		}
		System.out.println(s1);
	}

}
