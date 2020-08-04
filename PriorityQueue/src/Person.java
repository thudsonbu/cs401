public class Person {
    // instance variables
    private String firstname;
    private String lastname;
    private int age;
    private double salary;

    // CONSTRUCTORS
    // full arg constructor
    public Person(String first, String last, int age, double salary){

    }

    // other constructors not relevant

    // GET METHODS

    // get first name
    private String getFirst() {
        return this.firstname;
    }

    // get last name
    private String getLast() {
        return this.lastname;
    }

    // get age
    private int getAge() {
        return this.age;
    }

    // get salary
    private double getSalary() {
        return this.salary;
    }

    // SET METHODS

    // set first name
    private boolean setFirst(String first) {
        boolean set = true;
        // check if between 1 and 30 characters
        if (first.length() > 30 || first.length() < 1){
            // if not between 1 and 30 characters do not set
            set = false;
            System.out.println("First name must be between 1 and 30 characters");
        // name must be valid
        } else {
            // format name by upper casing and trimming spaces
            String formattedFirst = first.toUpperCase().trim();
            // set first name
            this.firstname = formattedFirst;
        }
        return set;
    }

    // set last name
    private boolean setLast(String last) {
        boolean set = true;
        // check if between 1 and 30 characters
        if (last.length() > 30 || last.length() < 1){
            // if not between 1 and 30 characters do not set
            set = false;
            System.out.println("Last name must be between 1 and 30 characters");
        // name must be valid
        } else {
            // format name by upper casing and trimming spaces
            String formattedLast = last.toUpperCase().trim();
            // set last name
            this.lastname = formattedLast;
        }
        return set;
    }

    // set age
    private boolean setAge(int age) {
        boolean set = true;
        // check if age is between 1 and 125
        if (age < 1 || age > 125){
            // if age is not between 1 and 125 age is invalid do not set
            set = false;
            System.out.println("Age must be between 1 and 125.");
        // age must be valid
        } else {
            // set age
            this.age = age;
        }
        return set;
    }

    // set salary
    private boolean setSalary(double salary) {
        boolean set = true;
        // check if salary is between 0 and 1,000,000
        if (salary < 0 || salary > 1000000){
            // if salary is not between 0 and 1,000,000 salary is invalid
            set = false;
            System.out.println("Salary must be between 0 and 1000000.");
        // salary must be valid
        } else {
            this.salary = salary;
        }
        return set;
    }
}
