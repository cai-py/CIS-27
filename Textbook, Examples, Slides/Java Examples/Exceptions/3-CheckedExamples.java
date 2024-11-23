package exceptionsexamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Examples of checked examples.  Checked examples must be either
 * explicitly caught in the method that throws it or must be declared
 * with a 'throws' at the top of the function.
 * 
 * @author P. Thananjeyan
 */
public class CheckedExamples {
    public static void main(String[] args) {

        int a = 10, b = 0;
        String s;

        int z = (int) (4 * Math.random());

        try {
            System.out.println("Before file operation in M1");
            M1();
            System.out.println("After file operation in M1");
                    
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught in FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception caught in IOException");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Exception caught in Exception catch block");
            e.printStackTrace();
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
    
    public static void M1() throws IOException {

        FileInputStream fis = null;
        
        //The next line throws FileNotFoundException
        fis = new FileInputStream("C://time//myfile.txt");
        
	int k; 
        
        //The read() method throws IOException
      while(( k = fis.read() ) != -1) 
	{ 
		System.out.print((char)k); 
	} 

	/*The method close() method throws IOException*/
	fis.close(); 
    }
}

 
/*
OUTPUT:
run:
Before file operation in M1
Exception caught in FileNotFoundException
java.io.FileNotFoundException: C:\time\myfile.txt (The system cannot find the path specified)
Code in finally block
Continue after catch block
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(FileInputStream.java:195)
	at java.io.FileInputStream.<init>(FileInputStream.java:138)
	at java.io.FileInputStream.<init>(FileInputStream.java:93)
	at exceptionsexamples.CheckedExamples.M1(CheckedExamples.java:47)
	at exceptionsexamples.CheckedExamples.main(CheckedExamples.java:21)
BUILD SUCCESSFUL (total time: 0 seconds)
*/