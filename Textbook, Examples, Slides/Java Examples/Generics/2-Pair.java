package generics;

/**
 * 
 * Generic class Pair. Uses the type parameter T to indicate the type of Object.
 * 
 * @param <T> 
 */
public class Pair<T> {
    
    private T first;
    private T second;
    
    Pair(T first, T second){
        this.first = first;
        this.second = second;
    }
    
    public T getFirst(){
        return first;
    }
    
    public void setFirst(T first){
        this.first = first;
    }

    public T getSecond(){
        return second;
    }
    
    public void setSecond(T second){
        this.second = second;
    }  
    
    
    public static void main(String[] args){
        Pair<Integer> integerPair = new Pair<Integer>(5, 6);
        
        Pair<String> stringPair = new Pair<String>("Hello", "World");
        
        //Assignments
        Pair<Integer> p1 = integerPair;     //Assign to Integer pair
        //Pair<String> p2 = ip;             //Incompatible types
        
        //Pair<Object> p3 = ip;             //Will not work
        Pair<?> p3 = integerPair;           //Do this instead
        
        System.out.println("Printing Pairs 1----------------------");
        printPair1(p3);        
        
        p3 = stringPair;
        printPair1(p3);
        
        //Non-generic use of generic pair
        Pair nonGenericPair = new Pair("Hello", 6); 
        printPair1(nonGenericPair); 
    }
    
    // public static void printPair(Pair<T> p){          // Will not work
    // Use an unbounded wildcard as the paramenter.
    public static void printPair1(Pair<?> p){           
        System.out.println("Printing Pair1:  instance of: " + p.getClass());
        System.out.println("First: " + p.getFirst() + ", Second: " 
                + p.getSecond());
    }

    //Can only use the Object methods
    public static void printPair2(Pair<Object> p){
        System.out.println("Printing Pair1:  instance of: " + p.getClass());
        //System.out.println("First: " + p.getFirst() + ", Second: " 
        //        + p.getSecond());
    }
    
}
/*
OUTPUT:

run:
Printing Pairs 1----------------------
Printing Pair1:  instance of: class generics.Pair
First: 5, Second: 6
Printing Pair1:  instance of: class generics.Pair
First: Hello, Second: World
Printing Pair1:  instance of: class generics.Pair
First: Hello, Second: 6
BUILD SUCCESSFUL (total time: 1 second)

*/