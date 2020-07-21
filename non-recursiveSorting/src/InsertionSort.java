public class InsertionSort {
    public static void main(String args[]){
        int[] unsortedArray = new int[100000];
        System.out.println("Generating Array.");
        for (int i = 0; i < 100000; i++){
            int randomNumber = (int)(Math.random()*100000);
            unsortedArray[i] = randomNumber;
        }
        System.out.println("Sorting Array.");
        long startTime = System.nanoTime();
        int[] sortedArray = insertionSort(unsortedArray);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Array sorted in " + duration + " milliseconds.");
    }

    public static int[] insertionSort(int[] input){
        for(int i = 1; i < input.length; i++) { // iterate through each item in array everything less then i is sorted
            int target = input[i]; // current target to be relocated
            int j = i - 1; // position before target
            while(j >= 0 && input[j] > target){  // while j is indexible and target is smaller then item to its left
                input[j + 1] = input[j]; // move item larger then target right (overwrites first item)
                j = j-1; // move left
            }
            input[j+1] = target; // target placed where the item left is smaller
        }
        return input;
    }
}
