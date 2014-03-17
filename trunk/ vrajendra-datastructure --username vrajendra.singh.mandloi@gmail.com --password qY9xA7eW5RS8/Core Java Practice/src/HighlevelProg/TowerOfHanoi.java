package HighlevelProg;

public class TowerOfHanoi {

	public int recursion1(int n){
		int total=0;
		if(n==1)	// only valid till n==1
			return total+1;
		if(n<=0)	// only valid for natural numbers.
			return 0;
		total = recursion1(n-1)+3;
		return total;
	}
	
	public int recursion2(int n){
		System.out.println(n);
		int total=0;
		if(n==0 || n==1 || n==2){
			return n;
		}
		
		if(n%2==0){
			total = (recursion2(n-1)*4);
		}
		else{
			total = (recursion2(n-2)+(recursion2(n-1)*2));
		}
		return total;
	}

	public int recursion3(int n){
		System.out.println(n);
		if(n==1)
			return 1;
		if(n<=0)
			return 0;
		
		int total = n*recursion3(n-1);
		return total;
	}
	
	public int sortCheck(int []arr, int i){
		//System.out.println(i);
		if(i==1)
			return arr[0];
		if(arr[i]>sortCheck(arr, i-1))
			return arr[0];
		return -1;
	}

	public int roomCounterAC(int subroom, int level){
		int count=0;
		//System.out.println(subroom+" "+level);
		for(int i=0;i<subroom;i++){
			if(level==0)
				return 1;
			count+=roomCounterAC(subroom, level-1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		int arr[] = {5,6,7,8,9};
		//System.out.println(new TowerOfHanoi().recursion1(4));
		//System.out.println(new TowerOfHanoi().recursion2(5));
		//System.out.println(new TowerOfHanoi().recursion3(5));
		//System.out.println(new TowerOfHanoi().sortCheck(arr, arr.length-1));
		//System.out.println(new TowerOfHanoi().roomCounterAC( 16, 2));
	}
}
