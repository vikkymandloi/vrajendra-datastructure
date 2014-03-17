package ThreadingConcepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Connection{
	private static Connection instance = new Connection();
	private int count = 0;
	private Semaphore sem = new Semaphore(10, true);
	
	
	private Connection(){
	}

	public static Connection getinstance(){
		return instance;
	}

	public void connect() throws InterruptedException{
		try {
			sem.acquire();
			doConnect();
		}
		finally{
			sem.release();
		}
	}
	
	public void doConnect(){
		try {
			synchronized (this) {
				count++;
				System.out.println("Open : "+count+" \n Instance :"+instance.hashCode());
			}
			
			Thread.sleep(2000);
			
			synchronized (this) {
				count--;
				System.out.println("Closed : "+count+" \n Instance :"+instance.hashCode());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

public class SemaphorExampleConnection extends Thread{

	@Override
	public void run() {
		try {
			Connection.getinstance().connect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=0;i<200;i++){
			executor.submit(new SemaphorExampleConnection());
		}
		executor.shutdown();
		try {
			executor.awaitTermination(1,TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
