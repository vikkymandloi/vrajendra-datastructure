package ArraysPackageFullAllQuest;

public class MorganStanley {

	static int getRotationDistance(String str1, String str2) {
		String teststring = str1 + str1;
		int rotation = (teststring.indexOf(str2)+1)/2;
		return rotation;
	}
	
	static String subsetReverse(int K, String str) {
		String [] arrayofStr = str.split("(?<=\\G.{" + K + "})");
		String result = "";
		for(String arr : arrayofStr){
			if(arr.length() < K)
				result +=arr;
			for(int i=K-1; i>=0;i--){
				result+=arr.charAt(i);
			}
		}
		return result;
    }
	
    static String getLargestNumber(int[] arr) {
    	int len = arr.length;
		String[] str = new String[len];
		for(int i = 0; i<len ; i++ ){
			str[i] = String.valueOf(arr[i]);
		}
		// can obtain better result using Quick Sort for sorting
		for(int i=0; i<str.length; i++){
			for(int j=0; j<str.length-i-1; j++){
				if(str[j].charAt(0) < str[j+1].charAt(0)){	// rearranging the array checking all the variables at index 0
					String temp = str[j];
					str[j] = str[j+1];
					str[j+1] = temp;				
				}
			}
		}
		String result = "";
		for(String s : str)
			result += s;
		
    	return result;
    }
   
	public static void main(String[] args) {
		
		int arr[] = {45, 60, 540, 87, 11};
		System.out.println(getRotationDistance("ABACD", "DABAC"));
		//	System.out.println(subsetReverse(2, "abcdefgh"));
		//System.out.println(getLargestNumber(arr));
	}

}
