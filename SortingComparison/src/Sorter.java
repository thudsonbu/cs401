public class Sorter {

    public static int[] insertionSort(int[] arr){
        // iterate through each element starting from right moving it left
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
                    // if a swap happens array was not sorted
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
                // set new arr j when key was less
                for(j = i; j >= gap && arr[j-gap] > key; j-= gap) arr[j] = arr[j - gap];
                // swap right element to location where it is greater
                arr[j] = key;
            }
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr){
        // check if array can be returned
        if(arr.length < 2){
            return arr;
        }
        // create left and right arrays
        int splitPoint = arr.length /2;
        int[] left = new int[splitPoint];
        int[] right = new int[arr.length-splitPoint];
        // add elements to left array from original
        for(int i = 0; i < splitPoint; i++){
            left[i] = arr[i];
        }
        // add elements to right array from original
        for(int i = splitPoint; i < arr.length; i++){
            right[i-splitPoint] = arr[i];
        }
        // call merge sort on each sub array
        int[] sortedLeft = mergeSort(left);
        int[] sortedRight = mergeSort(right);
        // merge the arrays
        int leftLocation = 0;
        int rightLocation = 0;
        int originalLocation = 0;
        // while both have remaining items merge
        while(leftLocation < sortedLeft.length && rightLocation < sortedRight.length){
            // if left is smaller copy it to original array
            if(sortedLeft[leftLocation] < sortedRight[rightLocation]){
                arr[originalLocation] = sortedLeft[leftLocation];
                leftLocation++;
                originalLocation++;
            } else { // otherwise copy right to original array
                arr[originalLocation] = sortedRight[rightLocation];
                rightLocation++;
                originalLocation++;
            }
        }
        // while right remaining copy to original
        while(rightLocation < sortedRight.length){
            arr[originalLocation] = sortedRight[rightLocation];
            originalLocation++;
            rightLocation++;
        }
        // while left remaining copy to original
        while(leftLocation < sortedLeft.length){
            arr[originalLocation] = sortedLeft[leftLocation];
            originalLocation++;
            leftLocation++;
        }
        return arr;
    }
}
