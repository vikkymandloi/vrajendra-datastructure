package AmazonTest;

class hello{
	class hell{
		
	}
}

public class Quest1 extends Thread{

	@Override
	public void run(){
		System.out.println("Running");
		try {
			//Thread.sleep(4000);
			this.wait(1000);
		} catch (Exception e) {
			System.out.println("M Message 1s: "+e.getMessage());
		}
		System.out.println("Running after 1 Sec");
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Quest1());
		t1.start();
		//t1.interrupt();
	}
}
