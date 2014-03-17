package arrayTest;

public class RemoveAllChar {

	/*replace the characters of String.
	*/
	public static void main(String[] args) {
		String str = "vrajendrasinghmandloi";	//Orignal String
		String rep = "rajendrasin";	// replace these characters
		char[] str1 = str.toCharArray();
		int count=0;

		for(int i=0;i<str1.length;i++){
			if(rep.indexOf(str1[i])!=-1){
				count++; continue;
			}
			str1[i-count]=str1[i];
		}
		str="";
		for(int i=0;i<str1.length-count;i++)
			str += str1[i];
		System.out.println(str);
	}
}
