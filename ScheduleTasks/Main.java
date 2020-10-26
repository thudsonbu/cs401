import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        String[] tasks = {"a", "b", "a", "c", "d", "c", "a"};

        

    }

    public static String[] scheduleTasks(String[] tasks, int downTime){

        ArrayList<String> scheduledTasks = new ArrayList<>();

        HashMap<String, Integer> taskCountMap = readTasksToMap(tasks);

        PriorityQueue<Task> queue = readTasksMapToQueue(taskCountMap);

        ArrayList<Task> runningTasks = new ArrayList<>();

        for(String task : tasks){

            Task maxTask = queue.poll();
            scheduledTasks.add(maxTask.name);

            for(int i = 0; i < downTime; i++){

                Task nextTask = queue.poll();

                for (Task runningTask : runningTasks){

                }
            }
        }

        return tasks;
    }

    public static HashMap<String, Integer> readTasksToMap(String[] arr){

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

    public static PriorityQueue<Task> readTasksMapToQueue(HashMap<String, Integer> map){

        PriorityQueue<Task> taskQueue = new PriorityQueue<Task>(100);

        map.forEach( (String key, Integer value) -> { taskQueue.add(new Task(key, value)); });

        return taskQueue;
    }
}