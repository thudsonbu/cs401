public class Node1 {
// INSTANCE VARIABLES
    private Employee employee;
    private int count;
    private Node1 link;

// CONSTRUCTORS
    // No argument constructor
    public Node1(){
        employee = null;
        count = 0;
        link = null;
    }

    // Full argument constructor
    public Node1(Employee employee, int count, Node1 linkValue){
        setData(employee, count);
        link = linkValue;
    }

// SET
    // Add link data method
    public void setData(Employee newEmployee, int newCount){
        employee = newEmployee;
        count = newCount;
    }

    // Add link method
    public void setLink(Node1 newLink) {
        link = newLink;
    }

// GET
    public Employee getEmployee() {
        return employee;
    }

    public int getCount() {
        return count;
    }

    public Node1 getLink() {
        return link;
    }
}
