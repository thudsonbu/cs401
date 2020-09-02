import java.util.HashMap;

public class HashMapSubThread implements Runnable {
    HashMap<Integer, Integer> map;

    HashMapSubThread(HashMap<Integer, Integer> hash){
        this.map = hash;
    }

    public void run() {
        System.out.println("Thread running");
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long difference = endTime - startTime;
        
        int i = 10000;
        while (difference < 5000){
            int insert = 0;
            if ( i % 7 == 0 ) {
                insert = i;
            } else if ( i % 4 == 0 && i % 10 == 2){
                insert = i;
            }
            if ( insert > 0 && map.containsKey(i) ){
                int currentValue = map.get(i);
                map.put(i, currentValue + 1);
            } else if ( insert > 0 ) {
                map.put(i, 1);
            }
            i++;
            if (i > 99999) {
                i = 10000;
            }
            endTime = System.currentTimeMillis();
            difference = endTime - startTime;
        }
    }
}