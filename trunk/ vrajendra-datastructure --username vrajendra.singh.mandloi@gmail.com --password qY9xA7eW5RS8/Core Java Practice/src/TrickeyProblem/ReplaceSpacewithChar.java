package TrickeyProblem;

import java.util.Arrays;

public class ReplaceSpacewithChar {

	public static void main(String[] args) {	
		String strname = "Click to start the game on tv            ";
		char [] str  = strname.toCharArray();
		int length = strname.trim().length();
		int newLength = strname.length();

		for (int i = length - 1; i >= 0; i--) { 
			if (str[i] == ' ') { 
				str[newLength - 1] = '0'; 
				str[newLength - 2] = '2'; 
				str[newLength - 3] = '%'; 
				newLength = newLength - 3; 
			} else { 
				str[newLength - 1] = str[i]; 
				newLength = newLength - 1; 
			} 
		} 

		System.out.println(new String(str));
	}
}

