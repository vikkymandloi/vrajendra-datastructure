package RecursionPackage;

public class StarPyramid {

	public static void createStar(int level){
		if(level>1)
			createStar(level-1);
		
		for(int i=0;i<level;i++){
			System.out.print("*");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		createStar(5);
	}
}
