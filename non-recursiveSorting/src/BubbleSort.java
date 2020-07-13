import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String args[]){
        ArrayList<Integer> unsortedArray = new ArrayList<Integer>(Arrays.asList(0,4,6,2,7,8,3,5,9,0));
        System.out.println(bubbleSort(unsortedArray));
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> input){
        int remaining = input.size(); // remaining items
        while(remaining > 0){ // iterate for each item
            int position = 0; // position in iteration
            while(position < remaining-1){ // iterate through array
                int left = input.get(position); // item on left
                int right = input.get(position + 1); // item on right
                if (left > right) { // if out of order swap position
                    input.set(position, right); // set left as right
                    input.set(position + 1, left); // set right as left
                }
                position ++; // continue iteration
            }
            remaining --;
        }
        return input; // increase size of sorted partition
    }
}
