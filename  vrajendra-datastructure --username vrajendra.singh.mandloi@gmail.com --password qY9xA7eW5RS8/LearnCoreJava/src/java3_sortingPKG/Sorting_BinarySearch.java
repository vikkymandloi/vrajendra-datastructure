package java3_sortingPKG;

public class Sorting_BinarySearch {
	static int arr[] = {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};
	static int key = 20;
	
	public void binarysearch() {
		int low = 0;
		int high = arr.length-1;
		
		if(key > arr[high] || key <arr[low]) {
			System.out.println("Key Not valid");
			return;
		}
		
		while(true){
			if(low > high)
				return;
			int mid = (high + low)/2;
			if(arr[mid] == key) {
				System.out.println("index is : "+mid);
				break;
			} else if(arr[mid] > key) {
				high = mid;
				if(arr[high]==key){
					System.out.println("index is : "+mid);
					break;
				}					
			} else if(arr[mid] < key) {
				low = mid;
				if(arr[low]==key){
					System.out.println("index is : "+mid);
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {		
		Sorting_BinarySearch b1 = new Sorting_BinarySearch();
		b1.binarysearch();
	}
}
