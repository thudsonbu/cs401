import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String args[]){
        int[] unsortedArray = {0,5,2,7,5,8,4,3,7,1,7,5,5,3,7,8,5};
        int[] sortedArray = bubbleSort(unsortedArray);
        for(int i : sortedArray){
            System.out.print(i + ", ");
        }
    }

    public static int[] bubbleSort(int[] input){
        for(int i = 0; i < input.length-1; i++) { // for each item in array
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
