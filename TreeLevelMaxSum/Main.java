package treeLevelMaxSum;

import java.util.HashMap;

public class Main{
    public static void main(String[] args){
        
        Node root = new Node( 5, null, null);

        int highestSum = root.buildRandomTree();

        if ( root.value > highestSum ) { 
            highestSum = root.value;
        }

        
        


    }
}