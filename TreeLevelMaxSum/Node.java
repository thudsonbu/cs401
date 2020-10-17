public class Node {
    // Instance variables
    public double value;
    public Node left;
    public Node right;

    // Constructor
    public Node( double value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public double buildRandomTree(){

        double largestRowSum = 0;

        double[] level1 = randArr(2);
        double[] level2 = randArr(4);

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

    public static double arrSum(double[] level) {
        
        double sum = 0;

        for (double num : level){
            sum += num;
        }

        return sum;
    }

    public static double[] randArr(int length) {

        double[] arr = new double[length];

        for (int i = 0; i < length; i++) {
            double nextNum = Math.random() * 100;
            arr[i] = nextNum;
        }

        return arr;
    }
}
