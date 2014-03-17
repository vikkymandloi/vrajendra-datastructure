package HighlevelProg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SumFinder {

	static ArrayList<Integer> su = new ArrayList<Integer>();
	static int sum;
	int count = 0 ;
	static Map<String, Integer> map = new HashMap<String, Integer>();
	
	public void sumFound(ArrayList<Integer> a, int aSum){
		
		if(aSum==sum){		
			//map.put(su.toString(), count);
			System.out.println(su.toString());
			return;
		}
		else if(aSum < sum) {
			int i = 0;
			
			while(i < a.size()) {
				su.add(a.get(i));
				count++;
				sumFound(a, aSum + a.get(i));
				su.remove(a.get(i));
				count--;
				i++;
			}
		}
		else if(aSum > sum) {
			return;
		}
	}
	
	public static void Display(){
		try {
			Set<Entry<String, Integer>> abc = map.entrySet();
			Integer least = (Integer) abc.iterator().next().getValue();
			//System.out.println(least);
			for(Map.Entry entry : abc)
			{
				if(least > (Integer)entry.getValue())
					least = (Integer) entry.getValue();
			}
			System.out.println("least "+least);
			for(Map.Entry entry : abc)
			{
				if((Integer)entry.getValue() ==  least)
					System.out.println(entry.getKey().toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(4);
		a.add(5);
		sum = 13;
		new SumFinder().sumFound(a, 0);
		Display();
	}
}
