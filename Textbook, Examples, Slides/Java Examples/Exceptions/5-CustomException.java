package exceptionsexamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author pthananjeyan
 */
public class CustomException {
  
    public static void main(String[] args) {

        int a = 10, b = 0;
        String s;

        int z = (int) (4 * Math.random());

        try {
            System.out.println("Before file operation in M1");
            divide(a, b);
            System.out.println("After file operation in M1");
                    
        } catch (MyException e) {
            System.out.println("Exception caught MyException");
            e.printStackTrace();
            System.out.println("Value = " + e.getValue());
        }
        finally {
            System.out.println("Code in finally block");
        }
        
        System.out.println("Continue after catch block");
    }
    
    /*
    * Throws FileNotFoundException.  Exceptions thrown in this method are not
    * explicitly caught.
    */
    
   public static void divide(int x, int y) throws MyException {

        if (y == 0) {
            throw new MyException(y);
        }

        int z = x / y;
        System.out.println("Z = " + z);
    }
}


class MyException extends Exception {
    
    private int value;
    
    MyException (int value){
        super("Invalid denominator:" + value);
        this.value = value;
    }
    
    double getValue(){
        return value;
    }
}

/*
OUTPUT:
run:
Before file operation in M1
Exception caught MyException
Value = 0.0
exceptionsexamples.MyException: Invalid denominator:0
Code in finally block
Continue after catch block
	at exceptionsexamples.CustomException.divide(CustomException.java:45)
	at exceptionsexamples.CustomException.main(CustomException.java:22)
BUILD SUCCESSFUL (total time: 0 seconds)

*/

