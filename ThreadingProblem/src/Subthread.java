import java.util.*;

public class Subthread implements Runnable {
    HashMap<Integer, Integer> map;

    Subthread(HashMap<Integer, Integer> hash){
        this.map = hash;
    }

    public void run() {
        for (int i = 10000; i < 99999; i++) {
            if ( i / 7 == 0 ) {
                int old_count = map.get(i);
                try {
                    map.put(i, old_count += 1);
                } catch(Error e) {
                    map.put(i, 0);
                }
            }
        }
    }
}