//컴파일에러나는 예제
/*package network.chap05;

class SumTaskB implements Runnable{
	int from, to;
	
	public SumTaskB(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public long run() {
		long sum = 0;
		for (int i = from; i <= to; ++i)
			sum += i;
		return sum;
	}
}

public class Example2b {
	public static void main(String[] args) {
		int from = 1, to = 5000000;	
		SumTaskB sumTask = new SumTaskB(from, to);
		Thread thread = new Thread(sumTask);
		long result = thread.start();
		System.out.print(from + "부터 " + to + " 까지 합계는 ");
		System.out.print(result);
	}
}
*/