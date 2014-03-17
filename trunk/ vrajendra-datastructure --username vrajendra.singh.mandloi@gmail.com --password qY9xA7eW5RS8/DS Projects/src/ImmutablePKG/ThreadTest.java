package ImmutablePKG;

import CollectionsPKG.Threadtest;

public class ThreadTest extends Thread{
	
	private static int count = 0;
	
	private static synchronized void helloru(){
		for(int i=0;i<10;i++)
			System.out.println(count++);
	}
	
	public void run() {
		helloru();
	}
	
	public static void main(String[] args) {
		Thread t1 = new Threadtest();
		Thread t2 = new Threadtest();
		
		t1.start();
		t2.start();
	}
}
