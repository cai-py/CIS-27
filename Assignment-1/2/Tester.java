public class Tester {
    public static void main (String [] args) {
        Person P1 = new Person("Sponge", "Bob");
        Person P2 = new Person("Spider", "Man");

        // test get methods
        System.out.println(P1);
        System.out.println(P1.getFirstName());
        System.out.println(P1.getLastName());
        System.out.println(P1.getFullName());
        System.out.println(P1.getId());

        System.out.println(P2);
        System.out.println(P2.getFirstName());
        System.out.println(P2.getLastName());
        System.out.println(P2.getFullName());
        System.out.println(P2.getId());

        // Test setter methods
        P1.setFirstName("Alan");
        P1.setLastName("Turing");

        P2.setFirstName("Miles");
        P2.setLastName("Davis");

        System.out.println(P1);
        System.out.println(P1.getFirstName());
        System.out.println(P1.getLastName());
        System.out.println(P1.getFullName());
        System.out.println(P1.getId());

        System.out.println(P2);
        System.out.println(P2.getFirstName());
        System.out.println(P2.getLastName());
        System.out.println(P2.getFullName());
        System.out.println(P2.getId());
    }
}