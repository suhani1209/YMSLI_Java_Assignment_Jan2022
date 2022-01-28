package com.day7.q2;

import java.util.Random;

class MyJob implements Runnable{
	private int sum;
	boolean isDone=false;
	int count=0;
	Random random=new Random();
	
	@Override
	public void run() {
		int randomNumber=random.nextInt(10)+1;
		System.out.println("Random number produced by thread "+Thread.currentThread().getName()+" is "+randomNumber);
		synchronized (this) {
			count++;
			sum=sum+randomNumber;
			
			if(count==5)
			{
				synchronized (this) {
					isDone=true;
					notifyAll();
				}
				
			}
		}
		
	}
	public synchronized int getSum() {
		if(!isDone)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
	
}
public class que2 {
	public static void main(String[] args) {
		MyJob job=new MyJob();
		Thread thread1 =new Thread(job,"A");
		Thread thread2 =new Thread(job,"B");
		Thread thread3 =new Thread(job,"C");
		Thread thread4 =new Thread(job,"D");
		Thread thread5 =new Thread(job,"E");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		System.out.println("The sum of random number produced by 5 threads is "+job.getSum());
	}
}
