import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String args[]){
        ArrayList<Integer> unsortedArray = new ArrayList<Integer>(Arrays.asList(0,4,6,2,7,8,3,5,9,0));
        System.out.println(insertionSort(unsortedArray));
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> input){
        int iterations = 0; // iteration count used to specify sorted partition
        while (iterations < input.size()) { // Iterate though the list searching for smallest
            int position = iterations; // iteration will mark start of unsorted partition
            int target = input.get(position); // number at start location
            while(position < input.size()){ // iterate though unsorted partition
                if(input.get(position) < input.get(target)){ // compare integers for smallest
                    target = position; // if smaller set a new target
                }
                position ++; // continue to next item
            }
            input.add(iterations,input.get(target)); // insert target into new partition
            input.remove(target+1); // remove old target
            iterations ++; // continue with iterations
        }
        return input;
    }
}
