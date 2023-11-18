package network.chap05;

class SumTaskI implements Runnable{
	int from, to;
	
	public SumTaskI(int from, int to) {
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

public class Example3a {

	public static void main(String[] args) throws InterruptedException{
		final int N = 10000;
		
		var threads = new Thread[N];
		for (int i = 0; i < N; ++i) {
			threads[i] = new Thread(new SumTaskI(1, (i+1+10000)));
			threads[i].start();
		}
		for (int i = 0; i < N; ++i)
			threads[i].join();
		
		System.out.println("완료");
	}
}
