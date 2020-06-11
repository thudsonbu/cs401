public class HashTableEmployee {
    private LinkedListEmployee[] hashArray;
    private static final int SIZE = 10;

    // Hash table constructor (creates new linked lists for the array)
    public HashTableEmployee() {
        hashArray = new LinkedListEmployee[SIZE];
        for (int i = 0; i < SIZE; i++){
            hashArray[i] = new LinkedListEmployee();
        }
    }

    // Uses the employees first name to create a hash
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
    public boolean containsEmployee(Employee target){
        int hash = computeHash(target.getName());
        LinkedListEmployee list = hashArray[hash];
        if (list.contains(target)) {
            return true;
        } else {
            return false;
        }
    }

    public void put(Employee employee){
        int hash = computeHash(employee.getName());
        LinkedListEmployee list = hashArray[hash];
        if (!list.contains(employee)){
            // Only will add a target if it is not already in the list
            hashArray[hash].addToStart(employee);
        }
    }

    public Employee get(String name){
        Employee newEmployee = new Employee(name, new Date(1,1,1998));
        int hash = computeHash(name);
        LinkedListEmployee list = hashArray[hash];
        System.out.println(list.findData(newEmployee));
    }
}
