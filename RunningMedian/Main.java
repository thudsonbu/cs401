import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        
        


    }

    public static int[] runningMedian( int[] nums ) {

        if ( nums.length <= 1 ) {
            return nums;
        }

        int[] runningMedian = new int[nums.length];
        runningMedian[0] = nums[0];
        runningMedian[1] = nums[1];

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();

        if ( nums[0] > nums[1] ) {
            minHeap.add( nums[1] );
            maxHeap.add( nums[0] );
        } else {
            minHeap.add( nums[0] );
            maxHeap.add( nums[1] );
        }

        



    }

    public static void addNum( int num, PriorityQueue<Integer> min_heap, PriorityQueue<Integer> max_heap ) {

        if ( min_heap.size() == 0 && max_heap.size() == 0 ) {
            // min_heap.add
        }
    }
}