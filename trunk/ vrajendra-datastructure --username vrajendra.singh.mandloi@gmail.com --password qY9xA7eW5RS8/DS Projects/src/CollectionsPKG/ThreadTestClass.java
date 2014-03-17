package CollectionsPKG;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ThreadTestClass extends Thread{
	private Thread waitThread;
	private Lock lock = new ReentrantReadWriteLock().readLock();

	public ThreadTestClass(Thread waitThread) {
		this.waitThread = waitThread;
	}

	@Override
	public void run(){
		for(int i=0;i<5;i++){
			try {
				//Thread.sleep(500);
				if (!(waitThread == null))
					{
						//waitThread.join();
						waitThread.yield();
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			System.out.println(Thread.currentThread().getName());
		}
	}

	/*@Override
	public void run(){
		lock.lock();
		synchronized (this) {

			for(int i=0;i<100;i++){
				try {
					Thread.sleep(500);
					//if (!(waitThread == null))
						//waitThread.join();
				} catch (Exception e) {	e.printStackTrace();}
				System.out.println(Thread.currentThread().getName());
			}
		}
		lock.unlock();
	}*/

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadTestClass(null),"Thread1");
		Thread t2 = new Thread(new ThreadTestClass(t1),"Thread2");
		Thread t3 = new Thread(new ThreadTestClass(t2),"Thread3");
		Thread t4 = new Thread(new ThreadTestClass(t3),"Thread4");

		System.out.println("main thread started");
		t1.start();
		//t1.join();

		t2.start();
		//t2.join();

		t3.start();
		//t3.join();
		
		t4.start();
		//t4.join();

		System.out.println("main thread Completed");
	}
}
