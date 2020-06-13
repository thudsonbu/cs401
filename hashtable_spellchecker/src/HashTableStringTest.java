public class HashTableStringTest {
    public static void main(String[] args){
        String word1 = "potato";

        HashTableString dictionary = new HashTableString();

        dictionary.put(word1);

        System.out.println(dictionary.containsString(word1));

        System.out.println("potato");
    }
}
