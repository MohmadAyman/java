public class lab2Req implements Runnable {

    private int[] data ;

    public lab2Req(int[] a){

    }
	public void run () {
		int prio = Thread.currentThread().getPriority();
		System.out.println("Hello from "+ Thread.currentThread().getName());
		System.out.println("Priority " + prio);
		
		
		// if prio = 0 Print 0 ->4 elements else print 5->10
		for (int i = prio ; i< prio+5; i++ )
			System.out.println("Thread "+ Thread.currentThread().getName()+": "+i);
	}

	 // 3. Implement the main method
    public static void main(String args[]) throws Exception {
        
        System.out.println("enter arrayy of integers");
        int ch;
        int i=0;
        while ((ch = System.in.read ()) != '\n')
        {
         i++;
        }
         // Get a handler on the current main thread
        Thread t0 = Thread.currentThread();

        // 4. Create 2 threads
        Thread t1 = new Thread(new lab2Req(this.data));
        Thread t2 = new Thread(new lab2Req(this.data));

        // 5. Set the name of each thread
        t0.setName("Main Thread");

        // Thread.MAX_PRIORITY = 10
        // Thread.NORM_PRIORITY = 5 
        // Thread.MIN_PRIORITY = 1 
        t1.setName("Thread 1"); t1.setPriority(Thread.MIN_PRIORITY);
        t2.setName("Thread 2"); t1.setPriority(Thread.MAX_PRIORITY);

        // 6. Start threads (t0 already running)
        t1.start();
        t2.start();

        // 7. Wait for them to join the current thread
        t1.join(); 
        t2.join(); 

        System.out.println("All printed");
    }
}

