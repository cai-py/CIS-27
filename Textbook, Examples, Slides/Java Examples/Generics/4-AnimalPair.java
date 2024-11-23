package generics;

/**
 *
 * @author pthananj
 */
public class AnimalPair extends Pair<Animal>{
    
    private String description;
    
    AnimalPair(Animal a, Animal b, String desc){
        super(a, b);
        description = desc;
    }
    
    
    public static void main(String[] args) {
        
        AnimalPair animalPair = new AnimalPair(new Animal("Animal 1"), 
                new Animal("Animal 2"), "Animal Pair");
        System.out.println("Printing Animal Pair");
        printPair(animalPair);
        
        AnimalPair birdPair = new AnimalPair(new Bird("Bird 1"), 
                new Bird("Bird 2"), "Bird Pair");
        System.out.println("Printing Bird Pair");
        printPair(birdPair);
    }
    
    //public static void printPair(Pair<T> p){          //Will not work
    public static void printPair(Pair<?> p){
        System.out.println("Printing Pair1:  instance of: " + p.getClass());
        System.out.println("First: " + p.getFirst() + ", Second: " 
                + p.getSecond());
    }
    
    public static void setExample(Pair<? super Bird> pair){

        //Animal a = pair.getFirst();
        //Bird b = pair.getFirst();
        //Hummingbird hb = pair.getFirst();
        
        //pair.setFirst(new Animal("Animal 2");
        pair.setFirst(new Bird("Bird 2"));
        pair.setFirst(new Hummingbird("Humming Bird 2"));
    }
    
    public static void getExample(Pair<? extends Bird> pair){

        Animal a = pair.getFirst();
        Bird b = pair.getFirst();
        //Hummingbird hb = pair.getFirst();
        
        //pair.setFirst(new Animal("Animal 2"));
        //pair.setFirst(new Bird("Bird 2"));
        //pair.setFirst(new Hummingbird("Humming Bird 2"));
    }    
}

/*
OUTPIUT:

run:
Printing Animal Pair
Printing Pair1:  instance of: class generics.AnimalPair
First: Animal 1, Second: Animal 2

Printing Bird Pair
Printing Pair1:  instance of: class generics.AnimalPair
First: Bird 1, Second: Bird 2
BUILD SUCCESSFUL (total time: 1 second)

*/