package arrayTest;

public class Uneven2Darray {

	public static void main(String[] args) {
		int[][] uneven = {
				{1,2,3,4,5},
				{6,7,8},
				{9,10,11,12},
				{13,14}
		};
		for(int i=0;i<uneven.length;i++){
			for(int j=0;j<uneven[i].length;j++){
				System.out.print(uneven[i][j]);
			}
			System.out.println(" ");
		}
	}
}
