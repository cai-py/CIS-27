import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        int items = 100;

        // create list and shuffle
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < items; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        // convert to array
        Integer[] keys = list.toArray(new Integer[0]);

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(keys));

        // ternary heapsort
        TernaryHeapsort sorter = new TernaryHeapsort();
        sorter.heapSort(keys);

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(keys));
    }
}





