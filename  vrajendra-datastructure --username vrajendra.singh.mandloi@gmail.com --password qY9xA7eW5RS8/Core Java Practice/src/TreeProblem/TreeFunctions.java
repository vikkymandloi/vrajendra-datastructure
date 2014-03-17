package TreeProblem;

import java.util.Random;
import java.util.Scanner;

class Node1 extends Node{

	public Node1(int value) {
		super(value);
	}
	
	public boolean ValidateTree(){
		return true;
	}
}


public class TreeFunctions {
	public static void main(String[] args) {
		Node n1 = new Node(5);
		int i=0;
		// To fill up the Tree...
		while(i<30){
			n1.insertNode(n1, new Random().nextInt(100));
			i++;
		}
	}
}
