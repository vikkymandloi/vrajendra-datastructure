package HighlevelProg;

import java.util.Stack;

class StackName {
	Stack stk;
	String name;
	
	StackName (Stack stk, String name) {
		this.stk = stk;
		this.name = name;
	}
}

public class TOHanoi {

	public static void Toh(StackName a,StackName b,StackName c, int n){
		if(n==0)
			return;
		Toh(a, c, b, n-1);
		b.stk.push(a.stk.pop());
		System.out.println("Moved "+b.stk.peek()+" from "+a.name+" to "+b.name);
		Toh(c, b, a, n-1);
	}
	
	public static void Display(StackName a,StackName b,StackName c){
		System.out.println("a= "+a.stk.toString());
		System.out.println("b= "+b.stk.toString());
		System.out.println("c= "+c.stk.toString());
	}
	
	public static void main(String[] args) {
		Stack a = new Stack();
		a.push("5");
		a.push("4");
		a.push("3");
		a.push("2");
		a.push("1");
		Stack b = new Stack();
		Stack c = new Stack();
		StackName an = new StackName(a, "a");
		StackName bn = new StackName(b, "b");
		StackName cn = new StackName(c, "c");
		System.out.println(a.size());
		Toh(an, bn, cn, a.size());
		Display(an, bn, cn);
	}
}
