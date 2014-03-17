package StringsPkg;

public class RunningCharStreamFindStr {

	/* to Find the string in a character running string..!
	*/
	public static void main(String[] args) {
		char[] asd = "vrajendrasinghmandloi".toCharArray();
		char[] str = "as".toCharArray();
		int flag=0;
		for(char c: asd){
			if(c==str[0]){
				flag=1;
				continue;
			}
			System.out.println(flag);
			if(flag>0){
				if(str[flag]!=c)
					flag=0;
				if(str[flag] == c){
					if(flag==(str.length-1)){
						System.out.println("String match");
						return;
					}
					flag++;
					System.out.println("  "+flag);
				}
			}
		}
	}
}
