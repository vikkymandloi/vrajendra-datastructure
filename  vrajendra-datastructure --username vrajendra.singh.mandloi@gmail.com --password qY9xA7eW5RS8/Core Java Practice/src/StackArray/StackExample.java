package StackArray;

import java.util.Stack;

class StackImpl{
	private int maxSize = 10;
	private int[] stackArray = null;
	private int top = 0;
	
	public StackImpl(int size){
		maxSize=size;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int j){
		if(top==maxSize)
			return;
		stackArray[++top] = j;
	}
	
	public int pop() {
		return stackArray[top--];
	}
	
	public boolean empty(){
		if(top==-1)
			return true;
		else
			return false;
	}
}

public class StackExample {

	public static void main(String[] args) {
		int[] str = {1,2,3,4,5,6,7,8,9,0};
		//Stack stc = new Stack();
		StackImpl stc = new StackImpl(10);
		for(int i=0;i<str.length;i++){
			stc.push(str[i]);
		}
		for(int i=0;i<str.length;i++){
			System.out.print(stc.pop());
		}
	}
}
