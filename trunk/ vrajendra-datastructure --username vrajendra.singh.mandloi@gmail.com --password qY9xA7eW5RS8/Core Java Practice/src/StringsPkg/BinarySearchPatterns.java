package StringsPkg;

public class BinarySearchPatterns {

	public static void main(String[] args) {
		String matcher[] = {"string search","java string search","manual c++ string search equals",
				  "c++ javasearch code","c++ java code search" };
		String[] pattern = "c++ java".split(" ");
		
		for(String match : matcher){
			for(int i=0;i<pattern.length;i++){
				if(match.contains(pattern[i]+" ")){
					if(i==pattern.length-1){
						System.out.println(match);
					}
					continue;
				}else
					break;
			}
		}
	}
}
