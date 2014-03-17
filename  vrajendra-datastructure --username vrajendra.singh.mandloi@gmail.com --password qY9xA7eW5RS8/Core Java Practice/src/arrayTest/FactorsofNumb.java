package arrayTest;

public class FactorsofNumb {

	public static void main(String[] args) {
		int nub = 23;
		for(int i=2;i<nub;i++){
			if(nub%i==0){
				System.out.println(i+"*"+nub/i+" = "+nub);
			}
		}
	}
}
