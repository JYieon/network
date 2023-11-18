package network.chap05;

import java.util.ArrayList;
import java.util.concurrent.*;

class SumTaskK implements Callable<Long>{
	int from, to;
	
	public SumTaskK(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public Long call() throws Exception{
		long sum = 0;
		for (int i = from; i <= to; ++i)
			sum += i;
		return sum;
	}
}

public class Example3c {

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		final int N = 10000;
		
		ExecutorService service = Executors.newFixedThreadPool(50);
		var futures = new ArrayList<Future<Long>>();
		for (int i = 0; i < N; ++i) {
			var future = service.submit(new SumTaskK(1,(i+1)+10000));
			futures.add(future);
		}
		service.shutdown();
		
		for (var future : futures)
			System.out.println(future.get());
		System.out.println("완료");
	}
}
