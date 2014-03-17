package StringsPkg;

import java.util.Arrays;

public class TwoStringsFillingEachother {

	public static char[] fillString(char[] str1, char[] str2){
		int flag1 = 0;
		int flag2 = 0;
		for(int i=0;i<str1.length;i++){
			System.out.println(str1[i]);
			if(flag1>0){
				if(str1[i]=='?'){
					if(flag1==str2.length)	
						flag1=0;
					str1[i]= str2[flag1];
					flag1++;
					System.out.println("===="+flag1);
					continue;
				}
				if(str1[i]==str2[flag1]){
					flag1++;
					System.out.println("===="+flag1);
					continue;
				}
			}
			if(str1[i]==str2[0]){
				flag1=1; 
				System.out.println("===="+flag1);
				continue;
			}
			if(str1[i]=='?'){
				if(flag2==str2.length)	
					flag2=0;
				str1[i]=str2[flag2];
				System.out.println("+++++"+flag2);
				flag2++;
				continue;
			}
		}
		return str1;
	}
	
	public static void main(String[] args) {
		String str1 = "ABAAMA?????MAZON??????????AMA??????????????????";
		String str2 = "AMAZON";
		char[] str = fillString(str1.toCharArray(), str2.toCharArray());
		System.out.println(str);
	}
}
