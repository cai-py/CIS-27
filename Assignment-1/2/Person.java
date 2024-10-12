public class Person {
    private static int nextId = 1000;
    // variables
    private String firstName;
    private String lastName;
    private int id;

    // constructors
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = nextId++;
    }

    // get methods
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public int getId() {return id;}
    public String getFullName() {return firstName + " " + lastName;}

    // set methods
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    // to string method
    /* 
    %s %s (ID: %d): This format string specifies how the object's data should be presented:
        * The first %s will be replaced by the value of firstName.
        * The second %s will be replaced by the value of lastName.
        * The %d will be replaced by the value of id, which is expected to be an integer.
     */
    public String toString() {return String.format("%s %s (ID: %d)", firstName, lastName, id);}
}

