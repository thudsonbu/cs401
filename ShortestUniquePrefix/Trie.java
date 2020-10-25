public class Trie {
    
    TrieNode root = new TrieNode();

    public Trie(){

        this.root = new TrieNode();
    }

    public void insert(String word){

        TrieNode currNode = this.root;

        for (int i = 0; i < word.length(); i++) {

            String letter = word.substring(i, i+1);

            if (!currNode.children.containsKey(letter)) {

                currNode.children.put(letter, new TrieNode());
            }
            currNode = currNode.children.get(letter);
            currNode.count += 1;
        }
    }

    public String findUniquePrefix(String word){

        TrieNode currNode = this.root;

        String prefix = "";

        for (int i = 0; i < word.length(); i++) {

            String letter = word.substring(i, i+1);

            currNode = currNode.children.get(letter);

            prefix += letter;

            if (currNode.count == 1) {
                return prefix;
            }
        }
        return "error";
    }
}
