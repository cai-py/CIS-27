package exceptionsexamples;

import java.io.*;

/**
 * In this example we will redirect the System.out and System.out to files.
 * 
 * By default System.in is connected to the keyboard and System.out and
 * System.err are connected to the monitor.  We will explicitly redirect the
 * output to two different files.
 * 
 * The rest are similar to Example 1
 * 
 * @author P. Thananjeyan
 */
public class RedirectExceptions {

    public static void main(String[] args) throws IOException {

        // Open FileoutputStream and connect to files.
        FileOutputStream errWriter = new FileOutputStream("MyErrorFile.txt");
        FileOutputStream outWriter = new FileOutputStream("MyoutFile.txt");

        //Redirect System.err and System,out to files.
        System.setErr(new PrintStream(errWriter));
        System.setOut(new PrintStream(outWriter));

        System.out.println("Checking Output Stream ");

        int a = 10, b = 0;

        for (int i = 0; i < 4; i++) {

            System.out.println("Running Iteration : " + i);

            try {
                int z = (Math.random() > 0.5) ? 1 : 2;

                switch (z) {
                    case 1:
                        divide(a, b);
                        break;
                    case 2:
                        divide1(a, b);
                        break;
                }
                System.out.println("----------------------------");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        errWriter.close();
        outWriter.close();

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
