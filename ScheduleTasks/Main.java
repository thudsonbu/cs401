import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args){

    }

    public HashMap<String, Integer> readTasksToMap(String[] arr){

        HashMap<String, Integer> map = new HashMap<>();

        for(String task : arr){

            if(map.containsKey(task)){
                
                int currentCount = map.get(task);

                map.put(task, currentCount + 1);
            } else {

                map.put(task, 1);
            }
        }

        return map;
    }

    public PriorityQueue<Task> readTasksMapToQueue(HashMap<String, Integer> map){

        PriorityQueue<Task> taskQueue = new PriorityQueue<Task>(100);

        map.forEach( (String key, Integer value) -> { taskQueue.add(new Task(key, value)); });

        return taskQueue;
    }
}