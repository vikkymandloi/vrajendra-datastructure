package RecursionPackage;

public class BubbleSortRecursion {
	
	public static void bubblesort(int arr[], int length){
		if(length==0)
			return;
		for(int i=0;i<length-1;i++){
			if(arr[i]>arr[i+1])
			{
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		bubblesort(arr, length-1);
		System.out.print(arr[length-1]+" ");
	}
	
	public static void main(String[] args) {
		int []arr = {4,2,3,6,1,5,9,7,8,10};
		bubblesort(arr, arr.length);;
	}
}
