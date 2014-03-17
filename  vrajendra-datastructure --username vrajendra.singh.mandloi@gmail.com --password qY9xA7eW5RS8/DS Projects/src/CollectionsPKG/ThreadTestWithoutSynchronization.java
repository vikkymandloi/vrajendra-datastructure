package CollectionsPKG;

public class ThreadTestWithoutSynchronization extends Thread{

	private volatile static long sum = 0;
	
	public long sumreturn(){
		for(long i=0;i<10;i++)
			sum +=i;
		
		return sum;
	}
	
	@SuppressWarnings("deprecation")
	public synchronized void dedlock(){
		Thread.currentThread().stop();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" return sum = "+sumreturn());
		Thread.currentThread().stop();
		//dedlock();
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadTestWithoutSynchronization(),"Thread1");
		Thread t2 = new Thread(new ThreadTestWithoutSynchronization(),"Thread2");
		Thread t3 = new Thread(new ThreadTestWithoutSynchronization(),"Thread3");
		Thread t4 = new Thread(new ThreadTestWithoutSynchronization(),"Thread4");
	
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
