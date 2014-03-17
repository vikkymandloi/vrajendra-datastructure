package CollectionsPKG;

public class Threadtest extends Thread{

	public void display(){
		synchronized (this) {
			for(int i=0;i<50;i++){
				//System.out.print("Current thread "+ Thread.currentThread().getName());
				System.out.print(i);
			}
			System.out.println(" ");
			System.out.println(" ");
		}
	}
	
	@Override
	public void run() {
		display();
	}
	
	public static void main(String[] args) {
		Thread t1 = new Threadtest();
		Thread t2 = new Threadtest();
		Thread t3 = new Threadtest();
		

			t1.start();
			
			t2.start();

			t3.start();

		
	}

}
