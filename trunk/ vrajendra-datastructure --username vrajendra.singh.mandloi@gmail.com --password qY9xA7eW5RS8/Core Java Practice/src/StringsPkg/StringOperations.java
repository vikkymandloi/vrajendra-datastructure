package StringsPkg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperations {

	public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

	  public static void main(String[] args) {
	    Pattern pattern = Pattern.compile("\\w+");
	    Matcher matcher = pattern.matcher(EXAMPLE_TEST);
	    while (matcher.find()) {
	      System.out.print("Start index: " + matcher.start());
	      System.out.print(" End index: " + matcher.end() + " ");
	      System.out.println(matcher.group());
	    }
	    Pattern replace = Pattern.compile("\\s+");
	    Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
	    System.out.println(matcher2.replaceAll("\t"));
	  }
	
/*	public static void main(String[] args) {
		String str = "hasdkjhuwirdmnklajsfkj";
		// CompareTo method will return 0 if the two strings are equal. -ve is the string is less +ve if the string is more..
		System.out.println(str.codePointCount(4, 6));
		System.out.println(str.compareToIgnoreCase("haSDkjhuwkj"));
	}*/
}
