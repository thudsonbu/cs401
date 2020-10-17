import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        
        Node root = new Node( 5, null, null );

        int highestSum = root.buildRandomTree();

        if ( root.value > highestSum ) highestSum = root.value;

        assert highestSum == highestLevelSum( root ) : "Error";

    }

    public static int highestLevelSum( Node root ) {

        HashMap<Integer,Integer> levelSumMap = new HashMap<Integer,Integer>();

        highestLevelSumHelper( root, levelSumMap, 0);

        int maxSum = 0;

        int currentLevel = 0;

        while ( levelSumMap.containsKey(currentLevel) ) {
            int levelSum = levelSumMap.get(currentLevel);
            if ( levelSum > maxSum ) {

                maxSum = levelSum;
            }
        }

        return maxSum;
    }

    public static void highestLevelSumHelper( Node root, HashMap<Integer,Integer> map, int level ){

        int currentValue = map.getOrDefault( level, 0 );

        map.put( level, currentValue + root.value );

        if ( root.left != null ) {
            highestLevelSumHelper( root.left, map, level+1 );
        }

        if ( root.right != null ) { 
            highestLevelSumHelper( root.right, map, level+1 );
        }

    }
}