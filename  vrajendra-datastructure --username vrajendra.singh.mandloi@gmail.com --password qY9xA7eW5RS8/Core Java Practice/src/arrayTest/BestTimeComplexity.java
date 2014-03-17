package arrayTest;

public class BestTimeComplexity {

	public static void Max(int[] arr){
		for(int j=0,i=0;i<arr.length;i++){
			if(arr[j]<arr[i])
				j=i;
			if(i==arr.length-1)
				System.out.println(arr[j]);
		}
	}

	public static void Search(int[] arr, int num){
		int upper = arr.length-1;
		for(int lower=0;lower<=upper;)// no increment coz if there is any increment then the 
					//last two values will not be judged and so the answere remains unknown.
		{
			int mid = (lower+upper)/2;
			System.out.println("------"+arr[mid]);
			
			if(arr[mid]==num){
				System.out.println("number "+num+" is at = "+arr[mid]);
				break;
			}
			if(num>mid)
				lower = mid+1;
			else
				upper = mid-1;
		}
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		//Max(arr);
		Search(arr,3);
	}
}