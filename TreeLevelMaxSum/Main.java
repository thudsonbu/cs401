import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        
        Node root = new Node( 5, null, null );

        double highestSum = root.buildRandomTree();

        if ( root.value > highestSum ) highestSum = root.value;

        assert highestSum == highestLevelSum( root ) : "Error";

        System.out.println(highestSum);

    }

    public static double highestLevelSum( Node root ) {

        HashMap<Double,Double> levelSumMap = new HashMap<Double,Double>();

        highestLevelSumHelper( root, levelSumMap, 0);

        double maxSum = Double.NEGATIVE_INFINITY;

        double currentLevel = 0;

        while ( levelSumMap.containsKey(currentLevel) ) {
            double levelSum = levelSumMap.get(currentLevel);
            if ( levelSum > maxSum ) {

                maxSum = levelSum;
            }
        }

        return maxSum;
    }

    public static void highestLevelSumHelper( Node root, HashMap<Double,Double> map, double level ){

        double currentValue = map.getOrDefault( level, 0.0 );

        map.put( level, currentValue + root.value );

        if ( root.left != null ) {
            highestLevelSumHelper( root.left, map, level+1 );
        }

        if ( root.right != null ) { 
            highestLevelSumHelper( root.right, map, level+1 );
        }

    }
}