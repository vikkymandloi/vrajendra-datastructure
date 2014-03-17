package HighlevelProg;
import java.util.*;

public class PermutationProblem {
	public static void main(String args[]) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1); a.add(2); a.add(3); //a.add(4);
		ArrayList<Integer> b = new ArrayList<Integer>();
		permute(a, b);
	}
	public static void permute(ArrayList<Integer> a, ArrayList<Integer> b) {
		if(a.size() == 0) {
			System.out.println(b);
		}
		int i = 0;
		while(i < a.size()) {
			Integer num = a.get(i);
			b.add(num);
			a.remove(num);
			permute(a, b);
			b.remove(num);
			a.add(i, num);
			i++;
		}
	}
}
