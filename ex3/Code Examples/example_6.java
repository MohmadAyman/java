public class example_6 {
	public static void main (String [] args) throws InterruptedException {
		MyCounter counter = new MyCounter();

		Thread t1 = new Thread (new CounterRunnable(counter));
		Thread t2 = new Thread (new CounterRunnable(counter));

		t1.start(); t2.start();
		t1.join(); t2.join();
		
		System.out.println(counter.value());

	}
}

class CounterRunnable implements Runnable {
	private MyCounter counter;

	public CounterRunnable (MyCounter counter) {
	this.counter = counter;
	}

	public void run () {
		for (int i = 0 ; i < 1000; i++) 
			counter.increment();
	}
}

class MyCounter  {
	private int c =0;
	public void increment () {c++;}
	public int value () {return c;}
}