import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        
        int[] nums = { 1, 3, 5, 2, 7, 9, 9 };

        int[] medians = runningMedian( nums );
        
        for ( int i : medians ) {
            System.out.print(i + " ");
        }
    }

    public static int[] runningMedian( int[] nums ) {

        if ( nums.length <= 1 ) {
            return nums;
        }

        int[] runningMedian = new int[nums.length+1];
        runningMedian[1] = nums[0];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        if ( nums[0] > nums[1] ) {
            minHeap.add( -nums[1] ); // min heap values are negative to reverse comparator
            maxHeap.add( nums[0] );
        } else {
            minHeap.add( -nums[0] ); // min heap values are negative to reverse comparator
            maxHeap.add( nums[1] );
        }

        for ( int i = 2; i < nums.length; i++ ) {

            int newMedian = getMedian(minHeap, maxHeap );
            runningMedian[i] = newMedian;

            int newNum = nums[i];

            addNum( newNum, minHeap, maxHeap );

            rebalanceHeaps( minHeap, maxHeap );
        }

        int newMedian = getMedian(minHeap, maxHeap );
        runningMedian[nums.length] = newMedian;

        return runningMedian;
    }

    public static void addNum( int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap ) {

        int currentMedian =  ( maxHeap.peek() - minHeap.peek() )/2 ; // min heap values are negative to reverse comparator

        if ( num > currentMedian ) {
            maxHeap.add( num ); 
        } else {
            minHeap.add( -num ); // min heap values are negative to reverse comparator
        }
    }

    public static void rebalanceHeaps( PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap ) {

        int minHeapSize = minHeap.size();
        int maxHeapSize = maxHeap.size();

        // If there is an imbalance between the two heaps greater then 1 rebalance
        if ( minHeapSize > maxHeapSize + 1 ) {

            int swap = minHeap.poll();
            maxHeap.add( -swap );

        } else if ( maxHeapSize > minHeapSize + 1 ) {

            int swap = maxHeap.poll();
            minHeap.add( -swap );
        }
    }

    public static int getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {

        if ( minHeap.size() > maxHeap.size() ) {

            return -minHeap.peek(); // min heap values are negative to reverse comparator

        } else if ( maxHeap.size() > minHeap.size() ) {

            return maxHeap.peek(); 
        }

        return ( maxHeap.peek() - minHeap.peek() )/2;
    }
}