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
        // while right remaining copy to original (there will be no left remaining)
        while(rightLocation < sortedRight.length){
            arr[originalLocation] = sortedRight[rightLocation];
            originalLocation++;
            rightLocation++;
        }
        // while left remaining copy to original (there will be no right remaining)
        while(leftLocation < sortedLeft.length){
            arr[originalLocation] = sortedLeft[leftLocation];
            originalLocation++;
            leftLocation++;
        }
        return arr;
    }

    public static int[] heapSort(int[] arr){
        // build a heap
        int len = arr.length;
        // for every subtree createHeap
        for(int i = (len/2)-1; i >= 0; i--){
            createHeap(arr, len, i);
        }
        // for each element
        for(int i = len-1; i > 0; i-- ){
            // swap last heap element and root
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap; // will be cut off when i is decremented
            // call createHeap on tree to re-balance
            createHeap(arr, i, 0);
        }
        return arr;
    }

    public static void createHeap(int[] arr, int n, int root){
        int largest = root;
        int left = 2*root + 1; // left branch
        int right = 2*root + 2; // right branch
        // check if left child is larger then root
        if(left < n && arr[left] > arr[largest]) largest = left;
        // check if right child is larger then root (and left)
        if(right < n && arr[right] > arr[largest]) largest = right;
        // if the largest is not root
        if(largest != root){
            // swap positions of largest and greater branch
            int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;
            // call createHeap on edited branch
            createHeap(arr, n, largest);
        }
    }

    public static int[] quickSort(int[] arr, int len){
        // base case return value
        if(len <= 1){
            return arr;
        }
        // decide on partition (lets use middle)
        int partLoc = len/2;
        int part = arr[partLoc];
        // create lower and higher arrays
        int[] low = new int[len];
        int[] high = new int[len];
        // copy from original arr to lower and higher
        int lowInd = 0;
        int highInd = 0;
        for(int i = 0; i < len; i++){
            // skip part location
            if(i == partLoc) continue;
            int num = arr[i];
            // if num is greater then part add to high
            if(num > part){
                high[highInd] = num;
                highInd++;
            } else { // otherwise add to low
                low[lowInd] = num;
                lowInd++;
            }
        }
        int arrInd = 0;
        // call quick sort on low if there are items in it
        if(lowInd > 0) {
            low = quickSort(low, lowInd);
            // add low elements to original
            for(int i = 0; i < lowInd; i++){
                arr[arrInd] = low[i];
                arrInd++;
            }
        }
        // add partition
        arr[arrInd] = part;
        arrInd++;
        // call quick sort on high if there are items in it
        if(highInd > 0) {
            high = quickSort(high, highInd);
            // add high elements to original
            for(int i = 0; i < highInd; i++){
                arr[arrInd] = high[i];
                arrInd++;
            }
        }
        return arr;
    }
}
