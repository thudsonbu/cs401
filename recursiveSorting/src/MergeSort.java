public class MergeSort {

    public static void main(String[] args) {
        int[] unsortedArray = new int[100000];
        System.out.println("Generating Array.");
        for (int i = 0; i < 100000; i++) {
            int randomNumber = (int) (Math.random() * 100000);
            unsortedArray[i] = randomNumber;
        }
        System.out.println("Sorting Array.");
        long startTime = System.nanoTime();
        int[] sortedArray = mergeSort(unsortedArray,0,99999);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Array sorted in " + (duration/1000000) + " milliseconds.");
    }

    public static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create two new temp arrays to be merged later
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data from original array into each temp array
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = l;
        while (i < n1 && j < n2) { // while there are items left in each subarray
            if (L[i] <= R[j]) { // compare current items in left and right
                arr[k] = L[i]; // insert least item
                i++; // move to next item in left array
            }
            else {
                arr[k] = R[j]; // insert least item
                j++; // move to next item in right array
            }
            k++; // move to next item in outer array
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static int[] mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }

        return arr;
    }
}
