package Datatypes;

import Datatypes.hells.red;

abstract class hells{
	public int getval(){
		return 55;
	}
	abstract class red{
		public int getval(){
			return 25;
		}
	}
}

public abstract class della {
	
	static int asd = 123;
	
	public static void main(String[] args) {
		hells h1 = new hells() {
			public int getval(){
				return 88;
			} 
		};		
		
		red h2 = h1.new red() {	// if a class has some other class in it .. you can not provide the reference of the main class to the sub class
			public int getval(){
				return 45;
			} 
		};
		System.out.println(h2.getval()+"   "+ h1.getval());
	}

}
