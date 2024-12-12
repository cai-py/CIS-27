
import java.util.*;

public class TernaryHeapsort {
    private int size;

    public void heapSort(Integer[] array) {
        size = array.length;

        // heapify
        for (int k = (size - 2) / 3; k >= 0; k--) { // (size - 2) / 3 finds last non-leaf node;
            sink(array, k);
        }

        // sort
        while (size > 1) {
            swap(array, 0, --size); // swap root with last, size--
            sink(array, 0); // restore heap
        }
    }

    private void sink(Integer[] array, int k) {
        while (3 * k + 1 < size) {
            int largest = 3 * k + 1; // first child
            int secondChild = largest + 1;
            int thirdChild = largest + 2;

            // second child
            if (secondChild < size && array[secondChild].compareTo(array[largest]) > 0) {
                largest = secondChild;
            }

            // third child
            if (thirdChild < size && array[thirdChild].compareTo(array[largest]) > 0) {
                largest = thirdChild;
            }

            // if parent > largest child -> stop sinking
            if (array[k].compareTo(array[largest]) >= 0) {
                break;
            }

            // swap and continue to next pair
            swap(array, k, largest);
            k = largest;
        }
    }

    private void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}




