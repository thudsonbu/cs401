import java.util.Random;

public class BubbleSort {
    public static void main(String args[]){
        int[] unsortedArray = new int[100000];
        System.out.println("Generating Array.");
        for (int i = 0; i < 100000; i++){
            int randomNumber = (int)(Math.random()*100000);
            unsortedArray[i] = randomNumber;
        }
        System.out.println("Sorting Array.");
        long startTime = System.nanoTime();
        int[] sortedArray = bubbleSort(unsortedArray);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Array sorted in " + (duration/1000000) + " milliseconds.");
    }

    public static int[] bubbleSort(int[] input){
        for(int i = 0; i < input.length - 1; i++) { // for each item in array
            for (int j = 0; j < input.length - i - 1; j++) { // iterate through array
                if (input[j] > input[j + 1]) {
                    int temp = input[j]; // hold left number
                    input[j] = input[j + 1]; // swap left number with right number
                    input[j + 1] = temp; // swap right number with left number
                }
            }
        }
        return input;
    }
}
