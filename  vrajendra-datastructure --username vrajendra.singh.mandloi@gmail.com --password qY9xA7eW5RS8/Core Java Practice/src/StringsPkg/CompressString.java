package StringsPkg;

/* compressor and uncompressor of a string
*/
public class CompressString {

	public static String CompressStringMethod(String str){
		char[] str1 = str.toCharArray();
		String outStr="";
		int count=1;
		int length = str1.length-1;
		for(int i=1;i<=length;i++){
			if(str1[i-1]==str1[i]){
				count++;
			}
			else {
				outStr+=str1[i-1]+""+count;
				count=1;
			}
		}
		outStr+=str1[length]+""+count;
		return outStr;
	}

	public static String UncompressStringMethod(String str){
		String uncomp = "";
		String[] freq = str.split("[a-zA-Z]");
		int count=1;
		char[] str1 = str.toCharArray();
		for(char c : str1){
			if(Character.isLetter(c)){
				for(int i=0;i<Integer.valueOf(freq[count]);i++){
					uncomp+=c;
				}
				count++;
			}
		}
		return uncomp;
	}
	
	public static void main(String[] args) {
		String comp = CompressStringMethod("aaaasssssssssssssssssssaaaa");
		System.out.println(comp);
		String uncomp = UncompressStringMethod(comp);
		System.out.println(uncomp);
	}
}
