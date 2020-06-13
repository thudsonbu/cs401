public class LinkedListString<T> {

    // Node class
    private class Node<T> {
        // INSTANCE VARIABLES
        private T data;
        private Node<T> link;

        // CONSTRUCTORS
        public Node( ){
            data = null;
            link = null;
        }

        public Node(T newString, Node<T> newLink){
            data = newString;
            link = newLink;
        }
    }

    // INSTANCE VARIABLES
    // Head node
    private Node<T> head;

    // CONSTRUCTORS
    // No arg constructor
    public LinkedListString( ){
        head = null;
    }

    // METHODS
    // Add a new node (first in the list)
    public void addToStart(T data){
        head = new Node<T>(data, head);
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
        Node<T> position = head;
        while (position != null) {
            count++;
            position = position.link;
        }
        return count;
    }

    // Contains
    public boolean contains(T data){
        return(find(data) != null);
    }

    // Find searches for the first node that matches target or returns null
    private Node<T> find(T target){
        Node<T> position = head;
        T nodeString;
        // Iterate through each link changing to the nodes link each time
        while (position != null) {
            nodeString = position.data;
            if (nodeString.equals(target)){
                return position;
            }
            position = position.link;
        }
        return null; // if target was not found null is returned
    }

    // Find returns the reference to a node if target is found
    public T findString(T target){
        return find(target).data;
    }


    // Prints all employees in the list
    public void outputList( )
    {
        Node<T> position = head;
        while (position != null)
        {
            System.out.println(position.data);
            position = position.link;
        }
    }

    // findByName returns the employee in a list by searching by name
    public String findByData(String name){
        Node<T> position = head;
        String nodeString;
        String out = null;
        // Iterate through each link changing to the nodes link each time
        while (position != null) {
            nodeString = (String)position.data;
            if (nodeString.equals(name)){
                out = nodeString;
            }
            position = position.link;
        }
        return out;
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
            LinkedListString<T> otherList = (LinkedListString<T>)otherObject;
            if (size( ) != otherList.size( ))
                return false;
            Node<T> position = head;
            Node<T> otherPosition = otherList.head;
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