package interfaceexamples;

import java.util.Comparator;

/**
 * The example shows the use of the Comparator interface.  The comparator
 * interface has the Compare method that takes two objects.  It should return
 * < 0, > 0, or 1, similar to the compareTo method in the Comparable interface.
 * 
 * @author P. Thananjeyan
 */
class City {

    private int population;
    private double area;

    City(double area, int pop) {
        this.area = area;
        this.population = pop;
              
    }

    double getArea() {
        return area;
    }

    int getPopupation(){
        return population;
    }
    
    public String toString() {
        return "City Area: " + area + ", Population: " + population;
    }

}


/**
 * AreaComparator takes two City objects and sorts them based on the area.
 * 
 * @author pthananjeyan
 */
class AreaComparator implements Comparator<City> {
    
    public int compare(City a, City b){
        return (int) (a.getArea() - b.getArea());
    }
    
}


/**
 * PopulationComparator takes two city objects and sorts them based on the area.
 * 
 * @author pthananjeyan
 */
class PopulationComparator implements Comparator<City> {
    
    public int compare(City a, City b){
        return a.getPopupation() - b.getPopupation();
    }  
}


/**
 * The ComparatorSorter class has a sort method (selection sort) that takes an
 * array of objects and a Comparator object.  It uses the Comparator object
 * to compare the object.
 * 
 * @author pthananjeyan
 */
class ComparatorSorter {

    ComparatorSorter() {

    }

    public void Sort(Comparator c, Object[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (c.compare(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            Object temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}


/**
 * Sort the list of City objects using area and population.
 * 
 * @author pthananjeyan
 */
public class ComparatorExample {
    
    public static void main(String[] args) {

        ComparatorSorter sorter = new ComparatorSorter();

        City[] x = new City[]{new City(500, 30000), new City(600, 10000),
            new City(900, 100000), new City(200, 70000), new City(400, 50000)};

        // Sort the list of cities based on population.
        
        System.out.println("City Before Sorting");
        for (City a : x) {
            System.out.println(a + "  ");
        }
        System.out.println();

        // Create a PopulationComparator and sort the list of Cities using 
        // using the Sorter.
        sorter.Sort(new PopulationComparator(), x);

        System.out.println("City After population sorting");
        for (City a : x) {
            System.out.println(a + "  ");
        }
        System.out.println();
        System.out.println("------------------------------------");

        // Create a AreaComparator and sort the same City list based on area.
        sorter.Sort(new AreaComparator(), x);       

        System.out.println("City After Area Sorting");
        for (City a : x) {
            System.out.println(a + "  ");
        }
        System.out.println();
        System.out.println("------------------------------------");
    }
}
/*
OUTPUT:
run:
City Before Sorting
City Area: 500.0, Population: 30000  
City Area: 600.0, Population: 10000  
City Area: 900.0, Population: 100000  
City Area: 200.0, Population: 70000  
City Area: 400.0, Population: 50000  

City After population sorting
City Area: 600.0, Population: 10000  
City Area: 500.0, Population: 30000  
City Area: 400.0, Population: 50000  
City Area: 200.0, Population: 70000  
City Area: 900.0, Population: 100000  

------------------------------------
City After Area Sorting
City Area: 200.0, Population: 70000  
City Area: 400.0, Population: 50000  
City Area: 500.0, Population: 30000  
City Area: 600.0, Population: 10000  
City Area: 900.0, Population: 100000  

------------------------------------
BUILD SUCCESSFUL (total time: 0 seconds)

*/

    

