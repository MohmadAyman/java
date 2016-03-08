
public class example_3 implements Runnable {
   
    // 2. Implement the run method
    public void run() {
        try {
            do_work();
        }
        catch (InterruptedException x) {
            return;
        }
    }
 
    public void do_work() throws InterruptedException {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread isInterrupted()="+ Thread.currentThread().isInterrupted());
                break;
            }
        }
    }


    // 3. Implement the main method
    public static void main(String args[]) {
        // 4. Create a new object of type runnable and give it to the thread
        Thread t = new Thread(new example_3());
        t.start();

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException x) {
            return;
        }

        t.interrupt();
    }

}