package exceptionsexamples;

/**
 * 
 * This is very similar to Example 1 except that the exceptions are caught in 
 * a try-catch block.
 * 
 * @author P. Thananjeyan
 */
public class CatchExamples {

    public static void main(String[] args) {

        int a = 10, b = 0;

        int z = (Math.random() > 0.5) ? 1 : 2;

        try {
            switch (z) {
                case 1:
                    divide(a, b);
                    break;
                case 2:
                    divide1(a, b);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Exception caught in catch block");
            e.printStackTrace();
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
}

/*
Output:
run:
Exception caught in catch block
java.lang.ArithmeticException: / by zero
Continue after catch block
	at exceptionsexamples.CatchExamples.divide(CatchExamples.java:36)
	at exceptionsexamples.CatchExamples.main(CatchExamples.java:18)
BUILD SUCCESSFUL (total time: 0 seconds)
*/
