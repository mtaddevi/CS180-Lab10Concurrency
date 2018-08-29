import java.util.concurrent.Semaphore;

/**
 * This class implements a concurrent grading queue that may simultaneously process grading jobs.
 */
public class ConcurrentGradingQueue {
	Semaphore s;
    /**
     * The constructor should initialize as an instance variable a Semaphore with maxConcurrentJobs number of slots.
     */
    public ConcurrentGradingQueue (int maxConcurrentJobs) {
    	//Semaphore q;
    	 s = new Semaphore(maxConcurrentJobs);
    	
    }

    /**
     * This method should instantiate a ConcurrentGradingJob with the Semaphore stored in this object. It should then
     * create a new Thread with the ConcurrentGradingJob (which is a Runnable) and start the thread with the start()
     * method.
     */
    public void addToQueue (Submission submission) {
    	ConcurrentGradingJob h = new ConcurrentGradingJob(submission, s);
    	Thread t = new Thread(h); // create a thread from a runnable
    	t.start(); // start the thread
    }

}
