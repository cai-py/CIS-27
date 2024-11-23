package generics;

/**
 * 
 * Non Generic Pair.  First and Second are any type of Object.  Not safe.
 * 
 */
public class NonGenericPair {
    
    private Object first;
    private Object second;
    
    NonGenericPair(Object first, Object second){
        this.first = first;
        this.second = second;
    }
    
    public Object getFirst(){
        return first;
    }
    
    public void setFirst(Object first){
        this.first = first;
    }

    public Object getSecond(){
        return second;
    }
    
    public void setSecond(Object second){
        this.second = second;
    } 
    
    public static void main(String[] args){
        NonGenericPair integerPair = new NonGenericPair(5, 6);
        
        NonGenericPair stringPair = new NonGenericPair("Hello", "World");
        
        //Assignments
        NonGenericPair p1 = integerPair;    //Assign to Integer pair
        int x = (Integer) p1.getFirst();
        System.out.println("Integer: " + x );
        
        p1 = stringPair;                    //Assign to String pair
        String s = (String) p1.getFirst();
        System.out.println("String: " + s);
        
    }
}

/*
OUTPUT:

run:
Integer: 5
String: Hello
BUILD SUCCESSFUL (total time: 1 second)

*/