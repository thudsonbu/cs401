
public class Person implements Comparable<Person> {
    // instance variables
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    // CONSTRUCTORS
    // full arg constructor
    public Person(String first, String last, int age, double salary){
        this.setFirst(first);
        this.setLast(last);
        this.setAge(age);
        this.setSalary(salary);
    }

    // other constructors not relevant

    // GET METHODS

    // get first name
    String getFirst() {
        return this.firstName;
    }

    // get last name
    String getLast() {
        return this.lastName;
    }

    // get age
    int getAge() {
        return this.age;
    }

    // get salary
    double getSalary() {
        return this.salary;
    }

    // SET METHODS

    // set first name
    boolean setFirst(String first) {
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
            this.firstName = formattedFirst;
        }
        return set;
    }

    // set last name
    boolean setLast(String last) {
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
            this.lastName = formattedLast;
        }
        return set;
    }

    // set age
    boolean setAge(int age) {
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
    boolean setSalary(double salary) {
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

    // to string
    public String toString(){
        return this.getFirst() + " " + this.getLast() + " " + this.getSalary();
    }

//    // compare to last name
//    public int compareTo(Person otherPerson){
//        int out = 0;
//        // if calling persons last name is short give priority to otherPerson
//        if (this.getLast().length() < otherPerson.getLast().length()){
//            out = 1;
//            // if calling persons last name is longer give priority to calling person
//        } else if (this.getLast().length() > otherPerson.getLast().length()){
//            out = -1;
//        }
//        // otherwise neither get priority
//        return out;
//    }

//    // compare to lower salary based
//    public int compareTo(Person otherPerson){
//        int out = 0;
//        // if calling persons salary is higher other person gets priority
//        if (this.getSalary() > otherPerson.getSalary()){
//            out = 1;
//            // if calling persons salary is lower calling person gets priority
//        } else if (this.getSalary() < otherPerson.getSalary()){
//            out = -1;
//        }
//        // otherwise neither get priority
//        return out;
//    }

    // compare to higher salary based
    public int compareTo(Person otherPerson){
        int out = 0;
        // if other persons salary is higher he gets priority
        if (this.getSalary() < otherPerson.getSalary()){
            out = 1;
            // if calling persons salary is higher calling person gets priority
        } else if (this.getSalary() > otherPerson.getSalary()){
            out = -1;
        }
        // otherwise neither get priority
        return out;
    }

}
