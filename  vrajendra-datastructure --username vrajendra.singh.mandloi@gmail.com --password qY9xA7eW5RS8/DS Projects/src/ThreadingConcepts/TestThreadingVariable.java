package ThreadingConcepts;

class ParentClass
{
	
}

class ThreadClass implements Runnable{
	
	public void printcount(){
		int count = 0;
		synchronized (ParentClass.class) {
			for(int i=0;i<=20;i++){
				System.out.print(" "+count++);
			}
			System.out.println("");	
		}
	}
	
	@Override
	public void run() {
		printcount();
	}
}

public class TestThreadingVariable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadClass());
		Thread t2 = new Thread(new ThreadClass());
		Thread t3 = new Thread(new ThreadClass());
		Thread t4 = new Thread(new ThreadClass());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
