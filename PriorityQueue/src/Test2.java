import java.util.*;

public class Test2 {

    public static void main(String[] args){
        // decide how many people we want
        int length = 3;

        // create generic people data array
        String[] firstNames = { "Adam", "Alex", "Aaron", "Ben", "Carl", "Dan", "David", "Edward", "Fred", "Frank", "George", "Hal", "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", "Mark", "Nathan", "Otto", "Paul", "Peter", "Roger", "Roger", "Steve", "Thomas", "Tim", "Ty", "Victor", "Walter"};
        String[] lastNames = { "Anderson", "Ashwoon", "Aikin", "Bateman", "Bongard", "Bowers", "Boyd", "Cannon", "Cast", "Deitz", "Dewalt", "Ebner", "Frick", "Hancock", "Haworth", "Hesch", "Hoffman", "Kassing", "Knutson", "Lawless", "Lawicki", "Mccord", "McCormack", "Miller", "Myers", "Nugent", "Ortiz", "Orwig", "Ory", "Paiser", "Pak", "Pettigrew", "Quinn", "Quizoz", "Ramachandran", "Resnick", "Sagar", "Schickowski", "Schiebel", "Sellon", "Severson", "Shaffer", "Solberg", "Soloman", "Sonderling", "Soukup", "Soulis", "Stahl", "Sweeney", "Tandy", "Trebil", "Trusela", "Trussel", "Turco", "Uddin", "Uflan", "Ulrich", "Upson", "Vader", "Vail", "Valente", "Van Zandt", "Vanderpoel", "Ventotla", "Vogal", "Wagle", "Wagner", "Wakefield", "Weinstein", "Weiss", "Woo", "Yang", "Yates", "Yocum", "Zeaser", "Zeller", "Ziegler", "Bauer", "Baxster", "Casal", "Cataldi", "Caswell", "Celedon", "Chambers", "Chapman", "Christensen", "Darnell", "Davidson", "Davis", "DeLorenzo", "Dinkins", "Doran", "Dugelman", "Dugan", "Duffman", "Eastman", "Ferro", "Ferry", "Fletcher", "Fietzer", "Hylan", "Hydinger", "Illingsworth", "Ingram", "Irwin", "Jagtap", "Jenson", "Johnson", "Johnsen", "Jones", "Jurgenson", "Kalleg", "Kaskel", "Keller", "Leisinger", "LePage", "Lewis", "Linde", "Lulloff", "Maki", "Martin", "McGinnis", "Mills", "Moody", "Moore", "Napier", "Nelson", "Norquist", "Nuttle", "Olson", "Ostrander", "Reamer", "Reardon", "Reyes", "Rice", "Ripka", "Roberts", "Rogers", "Root", "Sandstrom", "Sawyer", "Schlicht", "Schmitt", "Schwager", "Schutz", "Schuster", "Tapia", "Thompson", "Tiernan", "Tisler" };
        Person[] people = new Person[length];
        for (int i = 0; i < people.length; i++) {
            String first = firstNames[i];
            String last = lastNames[i];
            int age = (int)(Math.random() * 123);
            double salary = Math.round((Math.random() * 100000000))/100.0;
            Person newPerson = new Person(first, last, age, salary);
            people[i] = newPerson;
        }

        PriorityQueue<Person> pq = new PriorityQueue<Person>(5, new PersonComparator()); 
            for (Person p : people) {
                pq.add(p);
            }
            // poll and peek priority queue
            Person firstPerson = pq.poll();
            System.out.println("\nFirst person is " + firstPerson);
            Person secondPerson = pq.peek();
            System.out.println("Second person is " + secondPerson);
            pq.poll();
            Person thirdPerson = pq.poll();
            System.out.println("Third person is " + thirdPerson);
        }  
    } 
 
  
    class PersonComparator implements Comparator<Person>{

        public int compare(Person callingPerson, Person otherPerson){
            int out = 0;
            // if calling persons salary is higher other person gets priority
            if (callingPerson.getSalary() > otherPerson.getSalary()){
                out = 1;
                // if calling persons salary is lower calling person gets priority
            } else if (callingPerson.getSalary() < otherPerson.getSalary()){
                out = -1;
            }
            // otherwise neither get priority
            return out;
        }
    }




