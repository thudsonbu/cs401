public class test {
    
    public static void main(String args[]) {
        
        Trie myTrie = new Trie();
        String[] myWords = {"word", "potato", "tomato", "pockle"};
        String[] prefixes = new String[4];

        for(String word : myWords){
            myTrie.insert(word);
        }

        int i = 0;

        for(String word : myWords){
            prefixes[i] = myTrie.findUniquePrefix(word);
            System.out.println(prefixes[i]);
            i++;
        }
    }
}
