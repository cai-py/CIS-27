package exceptionsexamples;

/**
 * This examples shows how to use the assert statement. Insert the assert
 * statement at the point where you want to verify that the program satisfies a
 * certain condition at that point in the program. The program will fail with
 * the assertion error if the condition is not met.
 *
 * Assertion can be turned on or off at run time. By default assertions are
 * disabled. To enable assertions you must run the program with the -ea or
 * -enableassertions option.
 *
 * verify
 *
 * @author P. Thananjeyan
 */
public class AssertionsTest {

    public static void main(String[] args) {

        int x = 10;
        int y = 0;

        System.out.println("Calling Divide");
        divide(x, y);
        System.out.println("End of Divide");

        System.out.println("End of program");
    }

    // Method fails with the AssertionError -- initiated by JVM
    public static void divide(int x, int y) {

        assert y != 0 : "y = 0";

        int z = x / y;
        System.out.println("Z = " + z);
    }

}


/*
OUTPUT:

WITHOUT Assertion Enabled

run:
Calling Divide
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at exceptionsexamples.AssertionsTest.divide(AssertionsTest.java:36)
	at exceptionsexamples.AssertionsTest.main(AssertionsTest.java:25)
C:\Users\pthananjeyan\AppData\Local\NetBeans\Cache\12.4\executor-snippets\run.xml:111: The following error occurred while executing this line:
C:\Users\pthananjeyan\AppData\Local\NetBeans\Cache\12.4\executor-snippets\run.xml:94: Java returned: 1
BUILD FAILED (total time: 0 seconds)


OUTPUT:

WITH assertion enabled.

run:
Calling Divide
Exception in thread "main" java.lang.AssertionError: y = 0
	at exceptionsexamples.AssertionsTest.divide(AssertionsTest.java:34)
	at exceptionsexamples.AssertionsTest.main(AssertionsTest.java:25)
C:\Users\pthananjeyan\AppData\Local\NetBeans\Cache\12.4\executor-snippets\run.xml:111: The following error occurred while executing this line:
C:\Users\pthananjeyan\AppData\Local\NetBeans\Cache\12.4\executor-snippets\run.xml:94: Java returned: 1
BUILD FAILED (total time: 0 seconds)
 */
