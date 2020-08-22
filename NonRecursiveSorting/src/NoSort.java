import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NoSort {
    public static void main(String args[]){
        ArrayList<Integer> unsortedArray = new ArrayList<Integer>(25);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i=0; i<25; i++) {
            Integer r = rand.nextInt() % 256;
            unsortedArray.add(r);
        }
        System.out.println(NoSort(unsortedArray));
    }

    public static ArrayList<Integer> NoSort(ArrayList<Integer> input){
        for(int num : input) {
            if (num > 0) {
                System.out.print(".");
            }
        }
        System.out.print("\n");
        return input;
    }
}
