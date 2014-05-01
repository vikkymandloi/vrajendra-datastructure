package java1_variablesPKG;

import java.util.Arrays;

class Value { int val; }

public class ReferenceMatchClassVariable {
	public static void main(String[] args) {
		// Primitive Types
		Integer i1 = 3;
		Integer i2 = i1;
		
		i2 = 4;
		System.out.print("i1==" + i1);
		System.out.println(" but i2==" + i2);
		
		// Reference Type
		
		Value v1 = new Value();
		v1.val = 5;
		Value v2 = v1;
		v2.val = 6;
		System.out.print("v1.val==" + v1.val);
		System.out.println(" and v2.val==" + v2.val);
		// Array Reference Type
		int[] arr1 = {1,2,3,4,5,6,7,8,9};
		int arr2[] = arr1;
		
		arr2[2] = 89;
		System.out.println(Arrays.toString(arr1));
	}
}
