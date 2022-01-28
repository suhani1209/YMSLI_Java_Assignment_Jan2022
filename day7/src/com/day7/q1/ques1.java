package com.day7.q1;

class MyJob implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<=100;i++) {
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}
	
}
public class ques1 {
	public static void main(String[] args) {
		MyJob job=new MyJob();
		Thread thread1 =new Thread(job,"A");
		Thread thread2 =new Thread(job,"B");
		Thread thread3 =new Thread(job,"C");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
