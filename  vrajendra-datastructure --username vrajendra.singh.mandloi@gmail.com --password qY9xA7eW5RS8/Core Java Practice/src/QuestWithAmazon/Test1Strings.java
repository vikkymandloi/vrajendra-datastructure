package QuestWithAmazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Test1Strings {

	/**
	 * @param str
	 * @param cmpStr
	 * @return res
	 */
	public String CompressorString(String str)
	{
		String res = "";
		Map<Character, Integer> cmpStr = new TreeMap<Character, Integer>();
		char[] strArray = str.toCharArray();
		List listChar = new ArrayList();
		for(char c : strArray){
			listChar.add(Character.valueOf(c));
		}
		for(char c : strArray){
			cmpStr.put(c, Collections.frequency(listChar, c));
		}
		for(Map.Entry emp1 : cmpStr.entrySet()){
			//System.out.println(emp1.getKey()+" == "+emp1.getValue());
			res += emp1.getKey().toString()+emp1.getValue().toString();
		}
		return res;
	}
	
	public String expansionString(String str){
		String res = "";
		char[] strArray = str.toCharArray();
		String[] splitIter = str.split("[a-zA-Z]");
		Map<Character, String> expMap = new TreeMap<Character, String>();
		int count=0;
		for(int i=0;i<strArray.length;i++){
			if(Character.isLetter(strArray[i]))
			{
				expMap.put(strArray[i], splitIter[++count]);
			}
		}
		for(Map.Entry emp1 : expMap.entrySet()){
			//System.out.println(emp1.getKey()+" == "+emp1.getValue());
			for(int i=0;i<Integer.valueOf(emp1.getValue().toString());i++)
				res += emp1.getKey().toString();
		}
		return res;
	}
	
	public static void main(String[] args) {
		String str = "aaaaaaaaaaaaaaaaaaaaaaaabbbccccccdd";
		Test1Strings t1 = new Test1Strings();
		String compressedString = t1.CompressorString(str);
		System.out.println(compressedString);
		String expandedStr = t1.expansionString(compressedString);
		System.out.println(expandedStr);
	}
}
