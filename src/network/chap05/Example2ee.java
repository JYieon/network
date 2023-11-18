package network.chap05;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class SumTaskG implements Callable<Long>{
	int from, to;
	
	public SumTaskG(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public Long call() {
		long sum = 0;
		for (int i = from; i<=to; ++i)
			sum += i;
		return sum;
	}
}

public class Example2ee {

	public static void main(String[] args) throws Exception{
		int from = 1, to = 5000000;
		var future = new FutureTask<Long>(new SumTaskG(from, to));
		new Thread(future).start();
		long result = future.get();
		System.out.print(from + " 부터 " + " 까지 합게는 ");
		System.out.print(result);
	}
}
