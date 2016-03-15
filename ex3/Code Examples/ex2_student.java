import java.util.Scanner;

class ex2 {
	 public static void main(String... args) throws InterruptedException {
	 	BookStock b = new BookStock (10);
	 	Thread t0 = new Thread (new Supplier(b)); t0.setName ("Supplier");
	 	Thread t1 = new Thread (new StoreBranch(b)); t1.setName ("Giza branch");
	 	Thread t2 = new Thread (new StoreBranch(b)); t2.setName ("Cairo branch");
	 	Thread t3 = new Thread (new StoreBranch(b)); t3.setName ("Daqahley branch");

	 	t0. start(); 
	 	t1. start();
	 	t2. start();
	 	t3. start();

    }
}

class BookStock {
	private int book_count;
	private int max;
	public BookStock  (int max) {
		this.max = max;
	}
	public void produce() {
		book_count++;
	}

	public void consume () {
		book_count--;
	}

	public int getCount () {
		return book_count;
	}
}

class Supplier implements Runnable {
	private BookStock b;

	public Supplier (BookStock b) {
		this.b = b;
	}

	public void run () {
		while (true) {
			b.produce();
			System.out.println (Thread.currentThread().getName() + " provided a book, total " +b.getCount());
			try {
				Thread.sleep (1000);
			} catch (InterruptedException e) {
				System.out.println (Thread.currentThread().getName() + "is awaken");
			}
        }
	}

}
class StoreBranch implements Runnable {
	private BookStock b;

	public StoreBranch (BookStock b) {
		this.b = b;
	}

	public void run () {
		while (true) {
			b.consume();
			System.out.println (Thread.currentThread().getName() + " sold a book");
			try {
				Thread.sleep (2000);
			} catch (InterruptedException e) {
				System.out.println (Thread.currentThread().getName() + "is awaken");
			}
        }
	}
}