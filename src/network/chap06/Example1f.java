package network.chap06;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class Example1f {

	static class SumTask{
		int from, to;
		
		public SumTask(int from, int to) {
			this.from = from;
			this.to = to;
		}
		
		public void run() {
			int sum = 0;
			for(int i = from; i<=to; ++i)
				sum += i;
			System.out.printf("from %d to %d: %d \n", from, to, sum);
		}
	}
	
	static Queue<SumTask> queue = new ArrayDeque<SumTask>();
	static SumTask END = new SumTask(-1, -1);
	
	static class Producer extends Thread{
		final int count = 100;
		Random random = new Random();
		
		@Override
		public void run() {
			try {
				for (int i = 0; i < count; ++i) {
					Thread.sleep(10);
					int from = random.nextInt(50);
					int to = from + random.nextInt(50);
					synchronized(queue) {
						queue.add(new SumTask(from, to));
						queue.notify();
					}
				}
				synchronized(queue) {
					queue.add(END);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Consumer extends Thread{
		Random random = new Random();
		
		@Override
		public void run() {
			try {
				SumTask sumTask;
				while (true) {
					synchronized(queue) {
						while(queue.size()==0)
							queue.wait();
						sumTask = queue.remove();
					}
					if(sumTask == END) break;
					sumTask.run();
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; ++i)
			new Consumer().start();
		for (int i = 0; i < 5; ++i)
			new Producer().start();
	}
}
