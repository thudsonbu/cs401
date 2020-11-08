public class Sorter {

    public static int[] insertionSort(int[] arr){

        for(int i = 1; i < arr.length; i++){

            int j = i-1; // location to check
            int cur = arr[i]; // current node

            // while number to check is greater then current number
            while(j >= 0 && arr[j] > cur){
                // copy value right (above current node)
                arr[j+1] = arr[j];
                // move position left
                j--;
            }
            // place current number
            arr[j+1] = cur;
        }

        return arr;
    }

    public static int[] bubbleSort(int[] arr){

        boolean sorted = false;
        // while the array is not sorted
        while(!sorted) {

            sorted = true;
            // iterate through elements
            for(int i = 1; i < arr.length; i++){
                // key is the right element
                int key = arr[i];
                // if the right element is greater then the left
                if(arr[i-1] > key){
                    // swap elements
                    arr[i] = arr[i-1];
                    arr[i-1] = key;

                    sorted = false;
                }
            }
        }

        return arr;
    }
}
