import java.util.HashMap;


public class TrieNode {
    
    int count = 0;
    HashMap<String, TrieNode> children = new HashMap<>();

    public TrieNode() {

        this.count = 0;
        this.children = new HashMap<>();
    }
}