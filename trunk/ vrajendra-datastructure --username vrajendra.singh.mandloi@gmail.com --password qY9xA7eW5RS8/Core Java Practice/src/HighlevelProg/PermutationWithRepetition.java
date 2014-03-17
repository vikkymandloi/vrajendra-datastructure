package HighlevelProg;

import java.util.ArrayList;

public class PermutationWithRepetition {

	public static void permutewithLevel(ArrayList<Integer> a, ArrayList<Integer> b, int size){
		if(size==0){
			System.out.println(b);
			return;
		}
		
		int i=0;
		while(i < a.size()){
			Integer num = a.get(i);
			b.add(num);
			permutewithLevel(a, b, size-1);
			b.remove(num);
			i++;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1); a.add(2); a.add(3); a.add(4);
		ArrayList<Integer> b = new ArrayList<Integer>();
		int size = 3;
		permutewithLevel(a,b, size);
	}
}
