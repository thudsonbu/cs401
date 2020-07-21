import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    public static void main(String args[]){
        int[] unsortedArray = new int[100000];
        System.out.println("Generating Array.");
        for (int i = 0; i < 100000; i++){
            int randomNumber = (int)(Math.random()*100000);
            unsortedArray[i] = randomNumber;
        }
        System.out.println("Sorting Array.");
        long startTime = System.nanoTime();
        int[] sortedArray = shellSort(unsortedArray);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Array sorted in " + duration + " milliseconds.");
    }

    public static int[] shellSort(int[] input){
        int length = input.length;
        // Create a gap
        // This gap will decrease in size, at ever gap size the array will be insertion sorted at that gap size
        for (int gap = length/2; gap > 0; gap /= 2){
            // Use the gap to do an insertion short
            // thus performing large location shifts first
            for (int i = gap; i < length; i += 1){
                int temp = input[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && input[j - gap] > temp; j -= gap)
                    input[j] = input[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                input[j] = temp;

            }
        }
        return input;
    }
}
