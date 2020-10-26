public class Task implements Comparable<Task> {

    String name;
    int count;

    public Task(String name, int count){

        this.name = name;
        this.count = count;
    }

    public int compareTo(Task compTask){

        if (compTask.count < this.count){

            return -1;
        } else {

            return 1;
        }
    }

    public boolean equals(Object otherObject) {

        if (otherObject == null){

            return false;

        } else if(this.getClass() != otherObject.getClass()){

            return false;

        } else {

            Task otherTask = (Task)otherObject;

            return otherTask.name.equals(this.name);
        }
    }
}