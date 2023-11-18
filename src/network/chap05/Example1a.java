package network.chap05;

public class Example1a {

	static class TestThread extends Thread {
		String message;
		
		public TestThread(String message) {
			this.message = message;
		}
		@Override
		public void run() {
			for (int count = 0; count < 4; ++count)
				System.out.printf("%s %d\n", message, count);
		}
	}
	
	public static void main(String[] args) {
		Thread threadA = new TestThread("threadA");
		threadA.start();
		
		Thread threadB = new TestThread("threadB");
		threadB.start();
		
		new TestThread("threadC").start();
	}
}
