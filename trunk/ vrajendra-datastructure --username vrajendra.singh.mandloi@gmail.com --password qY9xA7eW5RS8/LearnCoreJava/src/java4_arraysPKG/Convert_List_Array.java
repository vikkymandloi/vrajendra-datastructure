package java4_arraysPKG;

import java.util.Arrays;
import java.util.Random;

public class Convert_List_Array {

	static int MAX_SIZE = 100;
	static int arr[] = new int[MAX_SIZE];
	//List<Integer> arraylist = new ArrayList<Integer>();
	
	public Convert_List_Array(){
		for(int i=0;i< MAX_SIZE; i++)
			arr[i] = i;
		
		shuffle();
		System.out.println(Arrays.toString(arr));
	}
	
	public void shuffle(){
		Random rand  =  new Random();
		for(int i=0;i < MAX_SIZE*2; i++){
			int x = rand.nextInt(MAX_SIZE);
			int y = rand.nextInt(MAX_SIZE);
			swap(x, y);
		}
	}
	
	public void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		new Convert_List_Array();
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
