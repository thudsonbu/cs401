public class HashTableString {
    private LinkedListString[] hashArray;
    private static final int SIZE = 10;

    // Hash table constructor (creates new linked lists for the array)
    public HashTableString() {
        hashArray = new LinkedListString[SIZE];
        for (int i = 0; i < SIZE; i++){
            hashArray[i] = new LinkedListString();
        }
    }

    // Uses the strings first name to create a hash
    private int computeHash(String name){
        int hash = 0;
        for (int i = 0; i < name.length(); i++){
            hash += name.charAt(i);
        }
        return hash % SIZE;
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