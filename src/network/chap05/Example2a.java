package network.chap05;

class SumTaskA implements Runnable{
	int from, to;
	
	public SumTaskA(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public void run() {
		long result;
		long sum = 0;
		for (int i = from; i <= to; ++i)
			sum += i;
		result = sum;
		System.out.print(from + "부터 " + to + " 까지 합계는 ");
		System.out.print(result);
	}
}

public class Example2a {
	public static void main(String[] args) {
		int from = 1, to = 5000000;	
		SumTaskA sumTask = new SumTaskA(from, to);
		Thread thread = new Thread(sumTask);
		thread.start();
	}
}
