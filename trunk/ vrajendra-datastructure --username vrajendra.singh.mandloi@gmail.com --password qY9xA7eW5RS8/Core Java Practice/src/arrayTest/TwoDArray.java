package arrayTest;

import java.util.Random;

public abstract class TwoDArray {

	static int[][] asd = new int[3][3];
	public static void values(){
		for(int i=0;i<asd.length;i++){
			for(int j=0;j<asd.length;j++){
				asd[i][j] = new Random().nextInt(9);
			}
		}
		display(asd);
	}
	public static void display(int [][] asd){
		System.out.println("Array here");
		for(int i=0;i<asd.length;i++){
			for(int j=0;j<asd.length;j++){
				System.out.print(asd[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void transpose(){
		int [][] sdf = new int[3][3];
		for(int i=0;i<asd.length;i++){
			for(int j=0;j<asd.length;j++){
				sdf[i][j] = asd[j][i];
			}
		}
		display(sdf);
	}
	public static void rotate() {
		int [][] sdf = new int[3][3];
		int length = asd.length-1;
		for(int i=0;i<=length;i++){
			for(int j=0;j<=length;j++){
				sdf[i][j] = asd[length-j][i];
			}
		}
		display(sdf);
	}
	public static void diagonalsum()
	{
		int sum=0;
		int length = asd.length-1;
		for(int i=0;i<=length;i++)
		{
			System.out.println(asd[i][i]);
			System.out.println(asd[i][length-i]);
			sum+=asd[i][i]+asd[length-i][length-i];
		}
		System.out.println("The sum of Diagonal is "+sum);
	}

	public static int determinant(int [][] mat){
		int result = 0; 

		if(mat.length == 1) { 
			result = mat[0][0]; 
			//System.out.println("result of single matrix is "+result);
			return result; 
		} 

		if(mat.length == 2) { 
			result = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0]; 
			//System.out.println("result of Double matrix is "+result);
			return result; 
		} 
		
		for(int i = 0; i < mat.length; i++) { 
			int temp[][] = new int[mat.length - 1][mat.length - 1]; 
			
			for(int j = 1; j < mat.length; j++) { 
				System.arraycopy(mat[j], 0, temp[j-1], 0, i); 
				System.arraycopy(mat[j], i+1, temp[j-1], i, mat.length-i-1);
			} 
			result += mat[0][i] * Math.pow(-1, i) * determinant(temp); 
		} 

		return result; 
	}

	public static int determinant1(int [][] mat){
		int i,j,k;
		int forder = mat.length;  
		int mult;
		  int deter=1;
		  for(i=0;i<forder;i++)
		  {
			for(j=0;j<forder;j++)
			{
			  mult=mat[j][i]/mat[i][i];
			  for(k=0;k<forder;k++)
			  {
				if(i==j) break;
				mat[j][k]=mat[j][k]-mat[i][k]*mult;
			  }
			}
		  }
		  for(i=0;i<forder;i++)
		  {
			deter=deter*mat[i][i];
		  }

		return deter; 
	}
	
	public static void matmul()	// Multiplication
	{
		int[][] a = {{1,2},{3,4},{5,6}};
		int[][] b = {{5,7,9},{6,8,1}};
		int row = a.length;
		int col = b[0].length;
		int[][] mult = new int[row][col]; 
		for(int i = 0; i < row; i++) { // aRow
		    for(int j = 0; j < col; j++) { // bColumn
		      for(int k = 0; k < a[0].length; k++) { // aColumn
		        mult[i][j] += a[i][k] * b[k][j];
		      }
		    }  
		  }
		display(mult);
	}
	
	public static void main(String[] args) {		
		matmul();
		//values();
		//transpose();
		//rotate();
		//diagonalsum();
		//int [][] asd = {{1,2,5},{4,5,6},{7,8,5}};
		//System.out.println("Determinant of "+determinant1(asd));
	}
}
