public class Tester {
    public static void main(String[] args) {
        Person P1 = new Person("John", "Doe"); //1000
        Person P2 = new Person("Jane", "Doe"); //1001
        Person P3 = new Person("Marry", "Jane"); //1002
        Person P4 = new Person("John", "Jane"); //1003

        // Constructor
        AddressBook<Person> myAddressBook = new AddressBook<>();
        myAddressBook.addPerson(P1);
        myAddressBook.addPerson(P2);
        myAddressBook.addPerson(P3);
        myAddressBook.addPerson(P4);

        // add duplicate
        myAddressBook.addPerson(P4);

        // Get methods
        System.out.println("First Name Match: " + myAddressBook.getPersonByFirstName("John"));
        System.out.println("Last Name Match: " + myAddressBook.getPersonByLastName("Doe"));
        System.out.println("ID Match: " + myAddressBook.getPersonById(1000));

        // Delete Person
        myAddressBook.deletePerson(P4);
        
        //list all 
        System.err.println("\nList All");
        myAddressBook.listPeople();
    }
}