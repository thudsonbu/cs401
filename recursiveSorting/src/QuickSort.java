public class QuickSort {
    public static void main(String[] args) {
        int[] unsortedArray = new int[100000];
        System.out.println("Generating Array.");
        for (int i = 0; i < 100000; i++) {
            int randomNumber = (int) (Math.random() * 100000);
            unsortedArray[i] = randomNumber;
        }
        System.out.println("Sorting Array.");
        long startTime = System.nanoTime();
        int[] sortedArray = quickSort(unsortedArray, 0, 99999);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Array sorted in " + (duration/1000000) + " milliseconds.");
    }


    public static int[] quickSort(int[] input, int low, int high) {
        if (low < high) {
            int pi = setPartition(input, low, high);
            quickSort(input, low, pi - 1);
            quickSort(input, pi + 1, high);
        }
        return input;
    }

    // Get partition finds the location in the subarray where
    // the pivot can be placed and have no smaller numbers
    // to its right. It is thus in its final position.
    public static int setPartition(int[] arr, int low, int high) {
        // Set the pivot equal to end of range
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element
        // Search for potential pivot location
        for (int j = low; j < high; j++) {
            // If current element smaller the pivot
            // Then move potential pivot location (arr[i]) because we cant have smaller on right
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp; // arr[j] is current element we are testing
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}