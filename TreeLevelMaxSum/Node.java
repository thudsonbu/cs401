package treeLevelMaxSum;


public class Node {
    // Instance variables
    public int value;
    public Node left;
    public Node right;

    // Constructor
    public Node( int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int buildRandomTree(){

        int largestRowSum = 0;

        int[] level1 = randArr(2);
        int[] level2 = randArr(4);

        // check which row has higher sum (this will be used in testing)
        if ( arrSum(level1) > arrSum(level2) ) {
            largestRowSum = arrSum(level1);
        } else {
            largestRowSum = arrSum(level2);
        }

        // CREATE TEST TREE
        // bottom row
        Node node7 = new Node( level2[0], null, null);
        Node node6 = new Node( level2[1], null, null);
        Node node5 = new Node( level2[2], null, null);
        Node node4 = new Node( level2[3], null, null);
        // second row
        Node node3 = new Node( 11, node6, node7);
        Node node2 = new Node( 13, node4, node5);
        // root
        this.left = node2;
        this.right = node3;

        return largestRowSum;
    }

    public static int arrSum(int[] level) {
        
        int sum = 0;

        for (int num : level){
            sum += num;
        }

        return sum;
    }

    public static int[] randArr(int length) {

        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            int nextNum = (int) Math.random() * 100;
            arr[i] = nextNum;
        }

        return arr;
    }
}
