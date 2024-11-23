package generics;

/**
 * 
 * Generic Two Parameter Pair.
 * 
 * @param <T1>
 * @param <T2> 
 */
public class DifferentPair<T1, T2> {
        
    private T1 first;
    private T2 second;
    
    DifferentPair(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }
    
    public T1 getFirst(){
        return first;
    }
    
    public void setFirst(T1 first){
        this.first = first;
    }

    public T2 getSecond(){
        return second;
    }
    
    public void setSecond(T2 second){
        this.second = second;
    } 

    
    public static void main(String[] args){
        DifferentPair<Integer, Integer> integerPair 
                = new DifferentPair<>(5, 6);
        
        DifferentPair<String, String> stringPair 
                = new DifferentPair<>("Hello", "World");
        
        //Assignments
        DifferentPair<Integer, Integer> p1 = integerPair;     
                                            //Assign to Integer pair
        
        //DifferentPair<Object, Object> p3 = integerPair;   
                                                    //Will not work
        DifferentPair<?, ?> p3 = integerPair;       //Do this instead
        
        System.out.println("Printing Pairs 1----------------------");
        printPair1(p3);        
        
        p3 = stringPair;
        printPair1(p3);
        
        //Non-generic use of generic pair
        DifferentPair nonGenericPair = new DifferentPair("Hello", 6); 
        printPair1(nonGenericPair); 
    }
    
    //public static void printPair(Pair<T, T> p){          //Will not work
    public static void printPair1(DifferentPair<?,?> p){
        System.out.println("Printing Pair1:  instance of: " + p.getClass());
        System.out.println("First: " + p.getFirst() + ", Second: " 
                + p.getSecond());
    }
}

/*
OUTPUT:

run:
Printing Pairs 1----------------------
Printing Pair1:  instance of: class generics.DifferentPair
First: 5, Second: 6
Printing Pair1:  instance of: class generics.DifferentPair
First: Hello, Second: World
Printing Pair1:  instance of: class generics.DifferentPair
First: Hello, Second: 6

*/