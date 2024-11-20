import java.util.ArrayList;

public class Tester{
    public static void main (String[] args) {
        Person P1 = new Person("Sponge", "Bob");
        System.out.println(P1);
        System.out.println("First Name: " + P1.getFirstName());
        System.out.println("Last Name: " + P1.getLastName());
        System.out.println("Full Name: " + P1.getFullName());
        System.out.println(P1.getId());
        System.out.println();

        FullTimeEmployee P2 = new FullTimeEmployee("Spider", "Man", "Avengers", 100000);
        System.out.println(P2);
        System.out.println("First Name: " + P2.getFirstName());
        System.out.println("Last Name: " + P2.getLastName());
        System.out.println("Full Name: " + P2.getFullName());
        System.out.println("Department: " + P2.getDepartment());
        System.out.println("Yearly Salary: " + P2.getSalary());
        System.out.println("ID: " + P2.getId());
        System.out.println();

        HourlyEmployee P3 = new HourlyEmployee("Papa", "John", "Food Service", 7, 40);
        System.out.println(P3);
        System.out.println("First Name: " + P3.getFirstName());
        System.out.println("Last Name: " + P3.getLastName());
        System.out.println("Full Name: " + P3.getFullName());
        System.out.println("Department: " + P3.getDepartment());
        System.out.println("Hourly Rate: " + P3.getHourlyRate());
        System.out.println("Hours per week: " + P3.getHoursPerWeek());
        System.out.println("Hours per 4 weeks: " + P3.getTotalHours());
        System.err.println("Pay per 4 weeks: " + P3.getTotalWage());
        System.out.println("ID: " + P3.getId());
        System.out.println();

        // test course class
        //Course temp = new Course("CIS 27: Data Structures and Algorithms", "A");
        //System.out.println(temp.getCourse());
        //System.out.println(temp.getGrade());

        ArrayList<Course> courses = new ArrayList<Course>();
        Course C1 = new Course("Math 1B: Calculus 2", "A");
        Course C2 = new Course("CIS 27: Data Structures and Algorithms", "A");
        Course C3 = new Course("Psych 61: Intro to Biological Psychology", "A");
        courses.add(C1);
        courses.add(C2);
        courses.add(C3);
        Student P4 = new Student("Cairo", "Flores", courses);
        System.out.println(P4);
        System.out.println("First Name: " + P4.getFirstName());
        System.out.println("Last Name: " + P4.getLastName());
        System.out.println("Full Name: " + P4.getFullName());
        System.out.println("\n ***** Transcript ***** \n" + P4.getCourses());
        System.out.println("ID: " + P4.getId());
        System.out.println();
    }
}












/*

public class Tester{
    public static void main (String[] args) {
        //test constructor
        Person P1 = new Person("Sponge", "Bob");
        Person P2 = new Person("Spider", "Man");

        // test get methods
        System.out.println(P1);
        System.out.println(P1.getFirstName());
        System.out.println(P1.getLastName());
        System.out.println(P1.getFullName());
        System.out.println(P1.getId());
        System.out.println();

        System.out.println(P2);
        System.out.println(P2.getFirstName());
        System.out.println(P2.getLastName());
        System.out.println(P2.getFullName());
        System.out.println(P2.getId());
        System.out.println();

        // test set methods
        P1.setFirstName("Alan");
        P1.setLastName("Turing");

        P2.setFirstName("Miles");
        P2.setLastName("Davis");

        // test get methods
        System.out.println(P1);
        System.out.println(P1.getFirstName());
        System.out.println(P1.getLastName());
        System.out.println(P1.getFullName());
        System.out.println(P1.getId());
        System.out.println();

        System.out.println(P2);
        System.out.println(P2.getFirstName());
        System.out.println(P2.getLastName());
        System.out.println(P2.getFullName());
        System.out.println(P2.getId());
        System.out.println();
    }
}

 */

