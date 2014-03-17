package CollectionsPKG;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Employee {
	Integer empid;
	String name;
	
	public Employee(Integer empid, String name){
		this.empid = empid;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		String obj = this.name+this.empid;
		int result = obj.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee other = (Employee) obj;
		
		if (empid == null) {
			if (other.empid != null)
				return false;
		} 
		else if (!empid.equals(other.empid))
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} 
		else if (!name.equals(other.name))
			return false;
		
		return true;
	}
}

public class HashMapTestObjectKey {

	public static void main(String[] args) {
		HashMap<Employee, String> h1 = new HashMap<Employee, String>();
		Employee e1 = new Employee(123,"Vrajendra");
		h1.put(e1, null);
		Employee e2 = new Employee(123,"Vrajendra");
		h1.put(e2, null);

		Set er1 = h1.entrySet();
		Iterator it1 = er1.iterator();
		while(it1.hasNext()){
			Map.Entry entry = (Entry) it1.next();
			Employee emp1 = (Employee)entry.getKey();
			System.out.println(emp1.empid+" == "+emp1.name+" == "+entry.getValue());
		}
	}
}
