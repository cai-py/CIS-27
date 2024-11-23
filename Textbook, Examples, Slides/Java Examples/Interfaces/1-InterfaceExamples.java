package interfaceexamples;

/**
 * This example shows how to implement and use an interface.  The class that 
 * implements interface should use the 'implements' keyword and declare the
 * list of interfaces implemented by the class. Any class that declares to 
 * implement an interfaces must implement all the methods in the interfaces
 * or declare the class as an abstract class.
 * 
 * @author P. Thananjeyan
 */
public class InterfaceExamples {

    public static void main(String[] args) {

        SelectionSorter sorter = new SelectionSorter();

        Animal[] x = new Animal[]{new Animal(60), new Animal(50),
            new Animal(90), new Animal(40), new Animal(10)};

        System.out.println("Animal Before Sorting");
        for (Animal a : x) {
            System.out.println(a + "  ");
        }
        System.out.println();

        sorter.Sort(x);

        System.out.println("Animal After sorting");
        for (Animal a : x) {
            System.out.println(a + "  ");
        }
        System.out.println();
        System.out.println("------------------------------------");

        //Create a list vehicles and sort using sort method.
        Vehicle[] y = new Vehicle[]{new Vehicle(2020), new Vehicle(2015),
            new Vehicle(2005), new Vehicle(1960), new Vehicle(2018)};

        System.out.println("Vehicle Before Sorting");
        for (Vehicle a : y) {
            System.out.println(a + "  ");
        }
        System.out.println();

        sorter.Sort(y);

        System.out.println("Vehicle After sorting");
        for (Vehicle a : y) {
            System.out.println(a + "  ");
        }
        System.out.println();
        System.out.println("------------------------------------");
    }

}


/**
 * The Animla class implements the non-generic version of the Comparable
 * interface.  There is a single method compareTo in the Comparable interface.
 *
 */
class Animal implements Comparable {

    private int id;

    Animal(int id) {
        this.id = id;
    }

    int getID() {
        return id;
    }

    /**
     * Implement the non-generic method Comparable using the Object as the
     * parameter.  The Object parameter needs to be cast to an Animal Object
     * before making comparisons.
     */
    public int compareTo(Object other) {
        Animal a = (Animal) other;
        return this.id - a.id;
    }

    public String toString() {
        return "Animal id: " + id;
    }

}


/**
 * The vehicle class implements the generic version of the Comparable
 * interface. There is a single method compareTo in the Comparable interface.
 * 
 * @author pthananjeyan
 */
class Vehicle implements Comparable<Vehicle> {

    private int year;

    Vehicle(int year) {
        this.year = year;
    }

    int getYear() {
        return year;
    }

    /*
     * Implement the compareTo with Vehicle parameter
    */
    public int compareTo(Vehicle other) {
        return this.year - other.year;
    }

    public String toString() {
        return "Vehicle Year: " + year;
    }

}


/**
 * The following class implements the selection sort method.  It
 * takes a array of objects that implement the Comparable interface.
 * 
 * @author pthananjeyan
 */
class SelectionSorter {

    SelectionSorter() {

    }

    public void Sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            Comparable temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}

/*
run:
run:
Animal Before Sorting
Animal id: 60  
Animal id: 50  
Animal id: 90  
Animal id: 40  
Animal id: 10  

Animal After sorting
Animal id: 10  
Animal id: 40  
Animal id: 50  
Animal id: 60  
Animal id: 90  

------------------------------------
Vehicle Before Sorting
Vehicle Year: 2020  
Vehicle Year: 2015  
Vehicle Year: 2005  
Vehicle Year: 1960  
Vehicle Year: 2018  

Vehicle After sorting
Vehicle Year: 1960  
Vehicle Year: 2005  
Vehicle Year: 2015  
Vehicle Year: 2018  
Vehicle Year: 2020  

------------------------------------
BUILD SUCCESSFUL (total time: 0 seconds)
*/
