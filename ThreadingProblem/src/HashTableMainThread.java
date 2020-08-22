import java.util.Hashtable;

public class HashTableMainThread {

    public static void main(String args[]) throws InterruptedException {
        int NUM_THREADS = 3;
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();

        Thread[] threads = new Thread[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new HashTableSubThread(table));
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].start();
        }

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long difference = endTime - startTime;
        
        while (difference < 5000){
            endTime = System.currentTimeMillis();
            difference = endTime - startTime;
        }

        for (int i=0; i < NUM_THREADS; ++i) {
            threads[i].join();
        }

        for (Integer i : table.keySet()) {
            System.out.println("Key " + i + " Value: " + table.get(i));
        }
    }
}