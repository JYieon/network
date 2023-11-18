package network.chap05;

class SumTaskF extends Thread{
	int from, to;
	long result;
	
	public SumTaskF(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public void run() {
		long sum = 0;
		for(int i = from; i<=to; ++i)
			sum += i;
		result = sum;
	}
	public long getResult() {
		return result;
	}
}

public class Example2f {

	public static void main(String[] args) throws InterruptedException{
		SumTaskF sumTask1 = new SumTaskF(1, 5000000);
		SumTaskF sumTask2 = new SumTaskF(1, 6000000);
		SumTaskF sumTask3 = new SumTaskF(1, 7000000);
		
		sumTask1.start();
		sumTask2.start();
		sumTask3.start();
		
		sumTask1.join();
		sumTask2.join();
		sumTask3.join();
		
		System.out.println(sumTask1.getResult());
		System.out.println(sumTask2.getResult());
		System.out.println(sumTask3.getResult());
	}
}
