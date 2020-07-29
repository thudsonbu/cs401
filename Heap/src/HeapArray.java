import javax.swing.text.AsyncBoxView;

public class HeapArray {
    // variables
    private int defaultSize;
    private int[] heap;
    private int leafIndex;

    // constructor
    public HeapArray(int size){
        defaultSize = size;
        leafIndex = 0;
        heap = new int[defaultSize];
    }

    // heap add method (uses recursion)
    public void add(int value,int insertIndex){
        //insert item at end of array
        heap[insertIndex] = value;
        int parentIndex = insertIndex/2;
        // check if parent node is less
        if (heap[parentIndex] < heap[insertIndex]){
            // if parent node is less swap positions
            int parent = heap[parentIndex];
            heap[insertIndex] = parent;
            add(value,parentIndex);
        } else {
            leafIndex += 1;
        }
    }

    // poll method
    public int poll(){
        // swap root (element to be removed) with leaf
        int out = heap[0];
        int swim = heap[leafIndex-1];
        heap[leafIndex-1] = 0;
        leafIndex -=1;
        // swim down tree to place out of order root element
        swim(swim, 0);
        return out;
    }

    public void swim(int value, int insertIndex){
        heap[insertIndex] = value;
        int leftChildIndex = ((2*insertIndex) + 1) < leafIndex ? ((2*insertIndex) + 1) : 0;
        int rightChildIndex = ((2*insertIndex) + 2) < leafIndex ? ((2*insertIndex) + 2) : 0;

        int swapIndex = -1;
        // Determine which index to swap if any
        // both children larger
        if (heap[leftChildIndex] > value && heap[rightChildIndex] > value){
            // left smaller or equal
            if (heap[leftChildIndex] >= heap[rightChildIndex]){
                swapIndex = leftChildIndex;
            } else {
                swapIndex = rightChildIndex;
            }
        }
        // left is large
        else if (heap[leftChildIndex] > value){
            swapIndex = leftChildIndex;
        }
        // right is large
        else if (heap[rightChildIndex] > value){
            swapIndex = rightChildIndex;
        }
        // perform swap
        if (swapIndex > 0){
            int child = heap[swapIndex];
            heap[insertIndex] = child;
            swim(value, swapIndex);
        }
    }

    public static void main(String[] args){
        int size = 15;

        HeapArray myHeap = new HeapArray(size);

        for (int i = 0; i <size; i++) {
            int a = (int)( (Math.random()*10) + 1);
            myHeap.add(a,myHeap.leafIndex);
        }

        for (int i = 0; i < myHeap.leafIndex; i++){
            System.out.print(myHeap.heap[i] + " ");
        }

        myHeap.poll();

        System.out.println();
        for (int i = 0; i < myHeap.leafIndex; i++) {
            System.out.print(myHeap.heap[i] + " ");
        }
    }
}
