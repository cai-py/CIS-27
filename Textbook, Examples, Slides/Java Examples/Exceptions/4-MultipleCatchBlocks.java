package exceptionsexamples;

/**
 * 
 * This example shows how to catch different exceptions in different catch
 * blocks. Catching these in different catch blocks can help different
 * catch code for each exception.
 * 
 * @author P. Thananjeyan
 */
public class MultipleCatchBlocks {

    public static void main(String[] args) {

        int a = 10, b = 0;
        String s;

        //Randomly choose different method.
        int z = (int) (4 * Math.random());

        try {
            switch (z) {
                case 0:
                    divide(a, b);               //ArithmeticException
                    break;
                case 1:
                    divide1(a, b);              //IllegalArgumentException
                    break;
                case 2:
                    s = null;
                    M1(s);                      //NullPointerException
                    break;
                case 3:
                    s = "Hello Exceptions World";      //No exception
                    M1(s);
            }
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in arithmetic catch block");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in illegal arg catch block");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Exception caught in exception catch block");
            e.printStackTrace();
        }
        finally {
            System.out.println("Code in finally block");
        }
        
        System.out.println("Continue after catch block");

    }

    // Method throws arithmetic exception -- initiated by JVM
    public static void divide(int x, int y) {

        int z = x / y;
        System.out.println("Z = " + z);
    }

    // Method throws arithmetic exception -- explicitly thrown by program
    public static void divide1(int x, int y) {

        if (y == 0) {
            throw new IllegalArgumentException("Denominator Error: " + y);
        }

        int z = x / y;
        System.out.println("Z = " + z);
    }
    
    public static void M1(String s){
        int x = s.length();
        System.out.println("No Error: Printing string = " + s);
    }
}

/*
No error output:
run:
No Error: Printing string = Hello Exceptions World
Code in finally block
Continue after catch block
BUILD SUCCESSFUL (total time: 0 seconds)



Exception output 1:
run:
Exception caught in illegal arg catch block
java.lang.IllegalArgumentException: Denominator Error: 0
Code in finally block
Continue after catch block
	at exceptionsexamples.MultipleCatchBlocks.divide1(MultipleCatchBlocks.java:61)
	at exceptionsexamples.MultipleCatchBlocks.main(MultipleCatchBlocks.java:22)
BUILD SUCCESSFUL (total time: 0 seconds)

Exception output 2:
run:
Exception caught in illegal arg catch block
java.lang.IllegalArgumentException: Denominator Error: 0
Code in finally block
Continue after catch block
	at exceptionsexamples.MultipleCatchBlocks.divide1(MultipleCatchBlocks.java:61)
	at exceptionsexamples.MultipleCatchBlocks.main(MultipleCatchBlocks.java:22)
BUILD SUCCESSFUL (total time: 0 seconds)

*/
