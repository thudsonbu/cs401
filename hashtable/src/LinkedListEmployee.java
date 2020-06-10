public class LinkedListEmployee<Employee> {

    // Node class
    private class Node<Employee> {
        // INSTANCE VARIABLES
        private Employee data;
        private Node<Employee> link;

        // CONSTRUCTORS
        public Node( ){
            data = null;
            link = null;
        }

        public Node(Employee newData, Node<Employee> newLink){
            data = newData;
            link = newLink;
        }
    }

// INSTANCE VARIABLES
    // Head node
    private Node<Employee> head;

// CONSTRUCTORS
    // No arg constructor
    public LinkedListEmployee( ){
        head = null;
    }

// METHODS
    // Add a new node (first in the list)
    public void addToStart(Employee employee){
        head = new Node<Employee>(employee, head);
    }

    // Delete the head node
    public boolean deleteHeadNode( ){
        if (head != null){
            head = head.link;
            return true;
        } else {
            return false;
        }
    }

    // Length
    public int size( ){
        int count = 0;
        Node<Employee> position = head;
        while (position != null) {
            count++;
            position = position.link;
        }
        return count;
    }

    // Contains
    public boolean contains(Employee employee){
        return(find(employee) != null);
    }

    // Find searches for the first node that matches target or returns null
    private Node<Employee> find(Employee target){
        Node<Employee> position = head;
        Employee nodeEmployee;
        // Iterate through each link changing to the nodes link each time
        while (position != null) {
            nodeEmployee = position.data;
            if (nodeEmployee.equals(target)){
                return position;
            }
            position = position.link;
        }
        return null; // if target was not found null is returned
    }

    // Find returns the reference to a node if target is found
    public Employee findData(Employee target){
        return find(target).data;
    }

    // Prints all employees in teh list
    public void outputList( )
    {
        Node<Employee> position = head;
        while (position != null)
        {
            System.out.println(position.data);
            position = position.link;
        }
    }

    public boolean isEmpty( )
    {
        return (head == null);
    }

    public void clear( )
    {
        head = null;
    } // Garbage collector required for this to work

    /*
     For two lists to be equal they must contain the same data items in
     the same order. The equals method of T is used to compare data items.
    */
    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            LinkedListEmployee<Employee> otherList = (LinkedListEmployee<Employee>)otherObject;
            if (size( ) != otherList.size( ))
                return false;
            Node<Employee> position = head;
            Node<Employee> otherPosition = otherList.head;
            while (position != null)
            {
                if (!(position.data.equals(otherPosition.data)))
                    return false;
                position = position.link;
                otherPosition = otherPosition.link;
            }
            return true; //no mismatch was not found
        }
    }

}

