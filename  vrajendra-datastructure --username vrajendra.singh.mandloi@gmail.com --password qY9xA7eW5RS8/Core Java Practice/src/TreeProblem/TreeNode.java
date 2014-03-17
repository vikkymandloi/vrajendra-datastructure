package TreeProblem;

import java.util.Random;
import java.util.Scanner;

class Node{
	private int value;
	private Node left;
	private Node right;

	public Node(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public void insertNode(Node root, int value){
		if(root.value>value){
			if(root.left ==null){
				System.out.println(value +" inserted value at left of "+root.value);
				root.left = new Node(value);
			}
			else
			{
				insertNode(root.left, value);
			}
		}
		if(root.value<value){
			if(root.right ==null){
				System.out.println(value +" inserted value at right of "+root.value);
				root.right = new Node(value);
			}
			else
			{
				insertNode(root.right, value);
			}
		}
	}

	public void ValidateTree(Node node){
		System.out.println("Left Total : " + AddNodes(node.left));
		System.out.println("Right Total : " + AddNodes(node.right));
	}

	public int AddNodes(Node node){
		int count = 1;
		//System.out.println("Val: " + node.value);
		if(node.left == null) {
			if(node.right == null) {
				;
			}
			else {
				count += AddNodes(node.right);
				//System.out.println(" LbarR : " + count);
			}
		}
		else {
			if(node.right == null) {
				count+=AddNodes(node.left);
				//System.out.println(" LRbar : " + count);
			}
			else {
				count+=AddNodes(node.left);
				count+=AddNodes(node.right);
				//System.out.println(" LR : " + count);
			}
		}
		return count;
	}
}

public class TreeNode {

	/*public static void main(String[] args) {
		Node n1 = new Node(5);
		Scanner scan = new Scanner(System.in);
		System.out.println("want to insert new Node??");
		String answer = scan.next();
		while(answer.equalsIgnoreCase("y"))
		{
			n1.insertNode(n1, scan.nextInt());
			System.out.println("want to insert new Node??");
			answer = scan.next();
		}
	}*/

	public static void main(String[] args) {
		Node n1 = new Node(5);
		int i=0;
		// To fill up the Tree...
		while(i<30){
			n1.insertNode(n1, new Random().nextInt(100));
			i++;
		}
		n1.ValidateTree(n1);
	}
}
