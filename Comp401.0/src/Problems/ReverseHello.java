package Problems;


/*
Write a program called ReverseHello.java that creates a thread (let's call it Thread 0).
 Thread 0 creates another thread (Thread 1); Thread 1 creates Thread 2; and so on, up to Thread 50.
 Each thread should print "Hello from Thread <num>!",

 but you should structure your program such that the threads print their greetings in reverse order.

 such as:
Hello from thread 50!
Hello from thread 49!
Hello from thread 48!
Hello from thread 47!
Hello from thread 46!
...
...
Hello from thread 0!

 */

//this is as far as i got
public class ReverseHello {
	 public static void main(String[] args) throws InterruptedException {
	        System.out.println("Thread count before starting: " + Thread.activeCount());

	       
	        Runnable runnable = new Runnable() {
	        	
	        
				public void run() {
				
	                for (int i = 0; i < Thread.activeCount(); i++) {
	                    System.out.println("hello from thread " + i);
	                    //this pauses our thread for 1 second
	                    try {
	                        Thread.sleep(1000);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        
	        };
	 }
}
