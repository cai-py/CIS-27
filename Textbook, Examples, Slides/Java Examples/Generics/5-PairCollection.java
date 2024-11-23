package generics;

/**
 *
 * @author PThananjeyan
 */
public class PairCollection<T> {
    
    // Declare an array of T items.
    Pair<T> [] Items;
    int count;
    
    // See the use of the arrays.
    PairCollection(int size){
        Items = (Pair<T> []) new Object[size];
    }
    

    
}
