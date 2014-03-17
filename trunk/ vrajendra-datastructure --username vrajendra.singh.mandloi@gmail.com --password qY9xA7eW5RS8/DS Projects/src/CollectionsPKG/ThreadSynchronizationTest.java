package CollectionsPKG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EmployeeDet{
	String name;
	Integer id;
	Integer salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}


public class ThreadSynchronizationTest{
	List<EmployeeDet> list = new ArrayList<EmployeeDet>();
	
	public synchronized void writeData(String name){
		for(int i=0;i<100;i++){
			EmployeeDet empdet = new EmployeeDet();
			empdet.setId(100+i);
			empdet.setName(name+i);
			empdet.setSalary(10000+i);
			list.add(empdet);
		}
	}
	
	public synchronized void readData(){
		Iterator<EmployeeDet> itr = list.iterator();
		while(itr.hasNext()){
			EmployeeDet employee = itr.next();
			System.out.println(employee.getId()+" -- "+employee.getName()+" -- "+employee.getSalary());
		}
	}
	
	public static void main(String[] args) {
		final ThreadSynchronizationTest t1 = new ThreadSynchronizationTest();
		// writing was processed by 1 thread
		Thread write1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Writing 1 in process");
				String threadname = Thread.currentThread().getName();
				t1.writeData(threadname);	
			}
		},"writeThread1 ");
		
		// writing by 2 threads
		Thread write2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Writing 2 in process");
				String threadname = Thread.currentThread().getName();
				t1.writeData(threadname);	
			}
		},"writeThread2 ");
		
		Thread read = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("reading in process");
				t1.readData();		
			}
		},"readThread");
			
			write1.setPriority(Thread.MAX_PRIORITY);
			write2.setPriority(Thread.NORM_PRIORITY);
			read.setPriority(Thread.MIN_PRIORITY);
			
			try {
				write1.start();
				write1.join();
				write2.start();
				write2.join();
				read.join();
				read.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
}
