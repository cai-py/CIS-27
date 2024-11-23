package exceptionsexamples;

/**
 * This example shows the throwing and catching of Runtime Exceptions.
 * Runtime exceptions are also known as 'Unchecked Excpetions' -- they do
 * not fall under the 'catch or declare' rule. Sub classes of RuntimeExceptions
 * need not be checked or declared.
 * 
 * Examples of unchecked examples are: NullPointerException, 
 * ArithmeticExcpetion, ArrayIndexOutofBoundsException, 
 * IllegalArgumentExcpetion.
 * 
 * You can also create and throw unchecked exceptions.
 * 
 * @author P. Thananjeyan
 */
public class RuntimeExamples {

    public static void main(String[] args) {

        int a = 10, b = 0;
        
        //Randomly choose divide 1 or divide 2.
        int z = (Math.random() > 0.5) ? 1 : 2;
        
        switch (z) {
            case 1:
                divide(a,b);
                break;
            case 2:
                divide1(a,b);
                break;
        }
 
    }
    
    // Method throws arithmetic exception -- initiated by JVM
    public static void divide(int x, int y){
        
        int z = x / y;      // Will by zero will create Arithmetic Exception.
        System.out.println("Z = "  + z);
    }
    
    
    // Method throws arithmetic exception -- explicitly thrown by program
    public static void divide1(int x, int y){
            
        //Check for y and explictly throw the exception.
        if (y == 0)
            throw new IllegalArgumentException("Denominator Error: " + y);
        
        int z = x / y;
        System.out.println("Z = "  + z);
    }
    
}

/*
Output for calling divide:
run:
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at exceptionsexamples.RuntimeExamples.divide(RuntimeExamples.java:20)
	at exceptionsexamples.RuntimeExamples.main(RuntimeExamples.java:12)
C:\Users\P. Thananjeyan\AppData\Local\NetBeans\Cache\8.2\executor-snippets\run.xml:53: Java returned: 1
BUILD FAILED (total time: 0 seconds)
    
   
Output for calling divide:
run:
Exception in thread "main" java.lang.IllegalArgumentException: Denominator Error: 0
	at exceptionsexamples.RuntimeExamples.divide1(RuntimeExamples.java:29)
	at exceptionsexamples.RuntimeExamples.main(RuntimeExamples.java:16)
C:\Users\P. Thananjeyan\AppData\Local\NetBeans\Cache\8.2\executor-snippets\run.xml:53: Java returned: 1
BUILD FAILED (total time: 6 seconds)
*/