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


    public static void main(String[] args){
        int size = 15;

        HeapArray myHeap = new HeapArray(size);

        for (int i = 0; i <size; i++) {
            int a = (int)( (Math.random()*100) + 1);
            myHeap.add(a,myHeap.leafIndex);
        }

        for (int i = 0; i < myHeap.leafIndex; i++){
            System.out.print(myHeap.heap[i] + " ");
        }
    }
}
