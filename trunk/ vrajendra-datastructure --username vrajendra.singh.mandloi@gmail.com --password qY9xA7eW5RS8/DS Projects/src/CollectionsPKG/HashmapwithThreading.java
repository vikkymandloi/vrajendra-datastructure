package CollectionsPKG;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashmapwithThreading implements Runnable{
	Map<String, String> map1 = new HashMap<String, String>();
	static int count = 1;
	
	@Override
	public void run() {
		String key = Thread.currentThread().getName().toString()+(count++);
		map1.put(key, "Hello");		
	}
	
	public void Display(){
		Set set1 = map1.keySet();
		Iterator it1 = set1.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		HashmapwithThreading h1 = new HashmapwithThreading();
		
		for(int i=0;i<1000;i++){
			String str = "thr"+i;
			Thread obj = new Thread(h1, str);
		}
		
		Thread thread1 = new Thread(h1, "thread1");
		Thread thread2 = new Thread(h1, "thread2");
		Thread thread3 = new Thread(h1, "thread3");
		Thread thread4 = new Thread(h1, "thread4");
		Thread thread5 = new Thread(h1, "thread5");
		Thread thread6 = new Thread(h1, "thread6");
		Thread thread7 = new Thread(h1, "thread7");
		// start the thread execution i.e. run method
		
		thread1.start();
	    thread2.start();
	    thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		//System.out.println("Filling up the map started");
		//Thread.sleep(1000);
		h1.Display();
	}
}
