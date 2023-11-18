package network.chap05;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class SumTaskH implements Callable<Long>{
	int from, to;
	
	public SumTaskH(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public Long call() {
		long sum = 0;
		for(int i = from; i<=to; ++i)
			sum += i;
		return sum;
	}
}

public class Example2ff {

	public static void main(String[] args) throws Exception{
		FutureTask<Long> future1 = new FutureTask<Long>(new SumTaskH(1, 5000000));
		FutureTask<Long> future2 = new FutureTask<Long>(new SumTaskH(1, 6000000));
		FutureTask<Long> future3 = new FutureTask<Long>(new SumTaskH(1, 7000000));
		
		new Thread(future1).start();
		new Thread(future2).start();
		new Thread(future3).start();
		
		System.out.println(future1.get());
		System.out.println(future2.get());
		System.out.println(future3.get());
	}
}
