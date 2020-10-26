import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        String[] tasks = {"a", "b", "a", "c", "d", "c", "a", "c"};

        ArrayList<String> taskSchedule = scheduleTasks(tasks, 2);

        for(String task : taskSchedule){

            System.out.print(task + ", ");
        }
    }

    public static ArrayList<String> scheduleTasks(String[] tasks, int downTime){

        ArrayList<String> scheduledTasks = new ArrayList<>();

        HashMap<String, Integer> taskCountMap = readTasksToMap(tasks); // keep track of tasks and remaining runs

        PriorityQueue<Task> queue = readTasksMapToQueue(taskCountMap); // keep track of which tasks to schedule next

        ArrayList<Task> runningTasks = new ArrayList<>(); // keep track of running tasks and wait

        for(String task : tasks){

            // if there are tasks in the queue schedule them and add them to running
            if(queue.size() > 0){

                Task nextTask = queue.poll();

                int remaining = taskCountMap.get(nextTask.name);

                taskCountMap.put(nextTask.name, remaining - 1);

                runningTasks.add(new Task(nextTask.name, downTime));

                scheduledTasks.add(nextTask.name);

            } else {

                scheduledTasks.add("none");
            }

            // re add to queue tasks which have "cooled down" and decrement wait
            for(Task runningTask : runningTasks){

                if(runningTask.count == 0){ // task should be added back if no remaining wait

                    int count = taskCountMap.get(runningTask.name); // get how many remaining runs

                    if(count > 0){ // only add back if task has remaining runs

                        queue.add(new Task(runningTask.name, count));
                    }
                } else {

                    runningTask.count--; // decrement remaining wait
                }
            }
        }

        return scheduledTasks;
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

        PriorityQueue<Task> taskQueue = new PriorityQueue<>(100);

        map.forEach( (String key, Integer value) -> taskQueue.add(new Task(key, value)));

        return taskQueue;
    }
}
