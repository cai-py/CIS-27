import java.util.*;
import java.util.Random;
import java.util.HashMap;
import java.util.Scanner;

public class RandomMatches {
    public static boolean binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == n) {
                return true;
            } else if (arr[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

//    public static void sort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1; j++) {
//                if (arr[j] > arr[j+1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//    }

    public static void printHashMap(HashMap<Integer, Double> map) {
        for (Integer key : map.keySet()) {
            Double value = map.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }

    public static void main(String[] args) {

        // create a Hashmap of results
        // "\T trials \N values  -  average matches
        HashMap<Integer, Double> Results = new HashMap<>();
        int[] NValues = {1000, 10000, 100000, 1000000};
        // get T
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many trials would you like to run: ");
        int T = scanner.nextInt();
        //System.out.println(T);

        for (int N : NValues) {
            int totalMatches = 0;

            for (int trial = 0; trial < T; trial++) {
                Random rand = new Random();
                int[] A1 = new int[N];
                int[] A2 = new int[N];

                // create random array
                for (int i = 0; i < N; i++) {
                    A1[i] = rand.nextInt(900000) + 100000;
                    A2[i] = rand.nextInt(900000) + 100000;
                }


                // sort arrays
                Arrays.sort(A1);

                // testing at least 1 match (delete later)
                A1[0] = 111111;
                A2[0] = 111111;

                // search for matches
                int matches = 0;
                for (int a : A2) {
                    if (binarySearch(A1, a)) {
                        matches++;
                    }
                }

                // add up matches
                totalMatches += matches;
            }
            // calculate averages and add to map
            double average = (double) totalMatches / T;
            Results.put(N, average);
            //System.out.println("Trial N = " + N + ": " + totalMatches + " matches");
        }
        printHashMap(Results);
        System.out.println("N Average Matches");
        for (int N : NValues) {
            System.out.println(N + ": " + Results.get(N));
        }

    }
}

/*
// COLLECT USER INPUT
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // creates scanner object
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Your name is " + name);

        scanner.close();
    }



// GENERATE RANDOM 6 DIGIT INTIGER (inside class)
    // instance of random class
    Random rand = new Random();

    // generate random 6 digit integer
    int sixDigitRandomNumber = rand.nextInt(900000) + 100000;


// Create a hashmap of the array and copmpare the second array
    // check them for matches
    // loop through first array and populate a hash map
    HashMap<Integer, Integer> A1Map = new HashMap<Integer, Integer>();
    for (int i = 0; i < A1.length; i++) {
        //System.out.println(N);
        A1Map.put(i, A1[i]);
    }
    // loop through 2nd array and compare to elements in hashmap
    int count = 0; // tracks amount of matches
    for (int i = 0; i < A2.length; i++) {
        for (Integer N : A1Map.values()) {
            if (A2[i] == N) {
                count++;
            }
        }
    }


 */