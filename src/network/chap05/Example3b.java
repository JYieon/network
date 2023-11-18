package network.chap05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SumTaskJ implements Runnable{
	int from, to;
	
	public SumTaskJ(int from, int to) {
	this.from = from;
	this.to = to;
	}
	
	@Override
	public void run() {
		long sum = 0;
		for (int i = from; i <= to; ++i)
			sum += i;
		System.out.println(sum);
	}
}


public class Example3b {

	public static void main(String[] args) throws InterruptedException{
		final int N = 10000;
		
		ExecutorService service = Executors.newFixedThreadPool(50);
		for (int i = 0; i < N; ++i)
			service.submit(new SumTaskJ(1, (i+1)*10000));
		service.shutdown();
		
		service.awaitTermination(60, TimeUnit.SECONDS);
		System.out.println("완료");
	}
}
