
import java.util.Hashtable;

public class HashTableSubThread implements Runnable {
    Hashtable<Integer, Integer> table;

    HashTableSubThread(Hashtable<Integer, Integer> hash){
        this.table = hash;
    }

    public void run() {
        System.out.println("Thread running");
        for (int i = 10000; i < 99999; i++) {
            int insert = 0;
            if ( i % 7 == 0 ) {
                insert = i;
            } else if ( i % 4 == 0 && i % 10 == 2){
                insert = i;
            }
            if ( insert > 0 && table.containsKey(i) ){
                int currentValue = table.get(i);
                table.put(i, currentValue + 1);
            } else if ( insert > 0 ) {
                table.put(i, 1);
            }
        }
    }
}