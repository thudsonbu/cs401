import java.util.HashMap;

public class HashMapSubThread implements Runnable {
    HashMap<Integer, Integer> map;

    HashMapSubThread(HashMap<Integer, Integer> hash){
        this.map = hash;
    }

    public void run() {
        System.out.println("Thread running");
        for (int i = 10000; i < 99999; i++) {
            int insert = 0;
            if ( i % 7 == 0 ) {
                insert = i;
            } else if ( i % 4 == 0 && i % 10 == 2) {
                insert = i;
            }
            if ( insert > 0 && map.containsKey(i) ) {
                int currentValue = map.get(i);
                map.put(i, currentValue + 1);
            } else if ( insert > 0 ) {
                map.put(i, 1);
            }
        }
    }
}