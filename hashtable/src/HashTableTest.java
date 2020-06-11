public class HashTableTest {
    public static void main(String[] args){

        Employee bob = new Employee("Bob", new Date(1,1,1998));

        HashTableEmployee table = new HashTableEmployee();

        table.put(bob);

        System.out.println(table.containsEmployee(bob));
    }
}
