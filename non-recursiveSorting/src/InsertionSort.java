public class InsertionSort {
    public static void main(String args[]){
        int[] unsortedArray = {0,5,2,7,5,8,4,3,7,1,7,5,5,3,7,8,5};
        int[] sortedArray = insertionSort(unsortedArray);
        for(int i : sortedArray){
            System.out.print(i + ", ");
        }
    }

    public static int[] insertionSort(int[] input){
        for(int i = 1; i < input.length; i++) { // iterate through each item in array everything less then i is sorted
            int target = input[i]; // current target to be relocated
            int j = i - 1; // position before target
            while(j >= 0 && input[j] > target){  // while j is indexible and target is smaller then item to its left
                input[j + 1] = input[j]; // move item larger then target right
                j = j-1; // continue iteration
            }
            input[j+1] = target; // target placed where the item left is smaller
        }
        return input;
    }
}
