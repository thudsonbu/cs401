import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class HashTableString {
    private LinkedListString[] hashArray;
    private static final int SIZE = 15000;

    // Hash table constructor (creates new linked lists for the array)
    public HashTableString() {
        hashArray = new LinkedListString[SIZE];
        for (int i = 0; i < SIZE; i++){
            hashArray[i] = new LinkedListString();
        }
    }

    public int computeHash(String word){
        int hash = 0;
        // Setup MD5 for hash creation
        try {
            // Specify which hashing algorithm for message digest to use
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Message digest takes in name
            md.update(word.getBytes());
            // Create byte array of what md computes the hash to be
            byte byteData[] = md.digest();
            // Create a byte butter out of the hash so that it can be modified
            ByteBuffer wrapped = ByteBuffer.wrap(byteData);
            // Convert the hash to an integer
            int openHash = wrapped.getInt();
            // Take remainder of hash / size of hashmap which will give the hash a position
            hash = openHash % SIZE;
        } catch(Exception e){
            System.out.println("Hashing failed.");
        }
        return Math.abs(hash);
    }

    /**
     * Returns true if the target is in the hash table,
     * false if it is not
     */
    public boolean containsString(String target){
        int hash = computeHash(target);
        LinkedListString list = hashArray[hash];
        if (list.contains(target)) {
            return true;
        } else {
            return false;
        }
    }

    public void put(String string){
        int hash = computeHash(string);
        LinkedListString list = hashArray[hash];
        if (!list.contains(string)){
            // Only will add a target if it is not already in the list
            hashArray[hash].addToStart(string);
        }
    }

    public String get(String string){
        int hash = computeHash(string);
        LinkedListString list = hashArray[hash];
        return list.findByData(string);
    }
}