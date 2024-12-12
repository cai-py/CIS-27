import java.util.ArrayList;
import java.util.Collections;

public class Tester {
    public static void main(String[] args) {
        int min = 0;
        int max = 100;
        int size = 1_000_000; // 10^3, 10^4, 10^5, 10^6
        int trials = 10; // trails / threshold
        int maxThreshold = 30;

        // random list of integers
        ArrayList<Integer> myList = new ArrayList<>();
        for (int j = 0; j < size; j++) {
            myList.add((int) (Math.random() * (max - min + 1) + min));
        }

        // Test sorting with different thresholds
        for (int threshold = 0; threshold <= maxThreshold; threshold++) {
            long totalTime = 0;
            OptimizedQuickSort sorter = new OptimizedQuickSort(threshold);

            for (int i = 0; i < trials; i++) {

                long start = System.nanoTime();
                sorter.quickSort(myList, 0, myList.size() - 1);
                long finish = System.nanoTime();

                Collections.shuffle(myList);

                totalTime += (finish - start);
            }

            long averageTime = totalTime / trials;
            System.out.println("Threshold " + threshold + ": Average Time = " + averageTime + " ns");
        }
    }
}






/*
import o3wQS.*;
import java.util.*;

public class o3wQuickSortTester{
	public static void main(String[] args) {
		int min = 0;
		int max = 100;

		int size = 1000000; // needs to be 10 to the power of 3, 4, 5, 6
		int trials = 10;
		int m = 31;

		ArrayList<Integer> myList = new ArrayList<>();
		for(int j = 0; j < size; j++){
			myList.add((int)Math.floor(Math.random() * (max - min + 1) + min));
		}

		for(int k = 0; k < m; k++){
			long time = 0;
			o3wQuickSort sortedList = new o3wQuickSort(k);

			for(int i = 0; i < trials; i++){

				long start = System.nanoTime();
				sortedList.quickSort(myList, 0, myList.size() -1);
				long finish = System.nanoTime();

				Collections.shuffle(myList);

				time += (finish - start);

				//sortedList.printList();
			}

			long averageTime = time / (long) trials;

			//System.out.println("The running time: size " + size + " and an m value of " + k + " had a running time of ");
			System.out.print(averageTime);
			System.out.println();
		}
	}
}
 */