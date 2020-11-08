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

    public static int[] shellSort(int[] arr, int startGap){
        // begin with large gap between elements being compared and reduce gap size each iteration
        for(int gap = startGap; gap > 0; gap /= 2){
            // from the gap location forward iterate elements
            for(int i = gap; i < arr.length; i++){

                int key = arr[i];
                // search for location where key (right element is greater)
                int j;
                for(j = i; j >= gap && arr[j-gap] > key; j-= gap){

                    arr[j] = arr[j-gap];
                }
                // swap right element to location where it is greater
                arr[j] = key;
            }
        }

        return arr;
    }
}
