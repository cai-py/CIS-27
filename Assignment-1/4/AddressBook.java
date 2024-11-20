import java.util.ArrayList;
import java.util.List;

public class AddressBook <E extends Person> {
    private ArrayList<E> persons;

    // constructors
    public AddressBook() {
        persons = new ArrayList<>();
    }

    //methods
    public void addPerson (E person) {
        if (!persons.contains(person)){
            persons.add(person);
        }else {
            System.out.println("Error: Person already in address book.");
        }
    }

    public void deletePerson (E person) {
        persons.remove(person);
    }

    public List<E> getPersonByFirstName(String firstName) {
        List<E> results = new ArrayList<>();
        for (E person : persons) {
            if (person.getFirstName().equals(firstName)) {
                results.add(person);
            }
        }
        return results;
    }

    public List<E> getPersonByLastName(String lastName) {
        List <E> results = new ArrayList<>();
        for (E person : persons) {
            if (person.getLastName().equals(lastName)){
                results.add(person);
            }
        }
        return results;
    }

    public List<E> getPersonById(Integer id) {
        List<E> results = new ArrayList<>();
        for (E person : persons) {
            if (person.getId() == id) {
                results.add(person);
            }
        }
        return results;
    }

    public void listPeople() {
        for (E person : persons) {
            System.out.println(person);
        }
    }
}

