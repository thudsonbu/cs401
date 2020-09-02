import java.util.HashMap;

public class HashMapMainThread {

    public static void main(String args[]) throws InterruptedException {
        int NUM_THREADS = 3;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new HashMapSubThread(map));
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].start();
        }

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long difference = endTime - startTime;
        
        while (difference < 10000){
            endTime = System.currentTimeMillis();
            difference = endTime - startTime;
        }

        for (int i=0; i < NUM_THREADS; ++i) {
            threads[i].join();
        }

        for (Integer i : map.keySet()) {
            System.out.println("Key " + i + " Value: " + map.get(i));
        }
    }
}

// Exception in thread "Thread-1" Thread running
// java.lang.NullPointerException
// at HashMapSubThread.run(HashMapSubThread.java:20)
// at java.base/java.lang.Thread.run(Thread.java:834)