package CollectionsTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class mapExample {

	public static void main(String[] args) {
		HashMap mp1 = new HashMap();
		//LinkedHashMap mp1 = new LinkedHashMap();
		//TreeMap mp1 = new TreeMap();
		mp1.put("A", 1);
		mp1.put("B", 2);
		mp1.put("C", 3);
		mp1.put("D", 4);
		mp1.put("E", 5);
		mp1.values();
		
		//mp1.comparator();
		for(Map.Entry entry : (Set<Map.Entry>)mp1.entrySet())
		{
			System.out.println(entry.getKey()+" = "+entry.getValue());
		}
	}
}
