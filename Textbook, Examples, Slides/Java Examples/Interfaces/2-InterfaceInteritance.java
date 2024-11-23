package interfaceexamples;

/**
 * The examples show the inheritance of interfaces.
 * 
 * @author P. Thananjeyan
 */

/**
 * Sortable interface has single method called sort.
 * 
 * @author pthananjeyan
 */
interface Sortable {
    
    void sort();
    
}

/**
 * Extend the Sortable interface and add the print method.
 */
interface SortedList extends Sortable {
    
    void print();
}


/**
 * Class A should implement the sort method.
 * 
 * @author pthananjeyan
 */
class A implements Sortable {
    
    public void sort(){
      // Implement the sort method  
    }
}


/**
 * Class B should implement the methods in the Sort and SortedList interface.
 * @author pthananjeyan
 */
class B implements SortedList {
    
    public void sort(){
        // Implement the sort method
    }
    
    public void print(){
        // Implement the print method
    } 
}

/**
 * Class C need not implement the Sort method since it is already in Class A.
 * 
 * @author pthananjeyan
 */
class C extends A implements SortedList {
    
    //Don't need to print another sort method.
    //OK to override but not necessary
    
    public void print(){
        // Implement the print method
    } 
}


/**
 * Class D implements the print method and also overrides the sort method.
 * @author pthananjeyan
 */
class D extends A implements SortedList {

    public void sort(){
    // This method overrides the A sort method
    }
   
    public void print(){
        // Implement the print method
    }   
}
