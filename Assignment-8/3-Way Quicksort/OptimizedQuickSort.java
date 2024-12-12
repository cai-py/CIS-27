import java.util.*;

public class OptimizedQuickSort {
    int threshold;

    public OptimizedQuickSort(int threshold) {
        this.threshold = threshold;
    }

    public void quickSort(ArrayList<Integer> list, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        if (hi - lo + 1 < threshold) {
            insertionSort(list, lo, hi);
            return;
        }

        int left = lo;
        int current = lo + 1;
        int right = hi;
        int pivot = getPivot(list, lo, hi); // The pivot is now moved to 'lo'

        while (current <= right) {
            int cmp = list.get(current).compareTo(pivot);

            if (cmp < 0) {
                swap(list, left++, current++);
            } else if (cmp > 0) {
                swap(list, current, right--);
            } else {
                current++;
            }
        }

        // Recursively sort the left and right partitions
        quickSort(list, lo, left - 1);
        quickSort(list, right + 1, hi);
    }

    private int getPivot(ArrayList<Integer> list, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        swap(list, lo, mid); // Move the pivot to the beginning
        return list.get(lo);
    }

    private void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public void insertionSort(ArrayList<Integer> list, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int current = list.get(i);
            int j = i - 1;

            while (j >= lo && list.get(j) > current) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
    }

}

/*

package o3wQS;
import java.util.*;

public class o3wQuickSort{
	private int mValue;

	public o3wQuickSort(int m){
		this.mValue = m;
	}
	public void quickSort(ArrayList<Integer> l, int lo, int hi){
		if(hi <= lo){
			return;
		}
		if(hi - lo + 1 < mValue){
			insertionSort(l, lo, hi);
			return;
		}

		int lt = lo;
		int i = lo+1;
		int gt = hi;

		int pivot = getPivot(l, lo, hi);
		int m = mValue;
		//l.get(lo);

		while(i <= gt){
			int cmp = l.get(i).compareTo(pivot);
			if(cmp < 0){
				exch(l, lt++, i++);
			}else if(cmp > 0){
				exch(l, i, gt--);
			}else{
				i++;
			}
		}

		quickSort(l, lo, lt-1);
		quickSort(l, gt+1, hi);

	}

	public static void exch(ArrayList<Integer> a, int i, int j){
		int t = a.get(i);
		a.set(i, a.get(j));
		a.set(j, t);
	}

	public static int getPivot(ArrayList<Integer> a, int lo, int hi){
		return a.get(lo);
	}

	public void insertionSort(ArrayList<Integer> a, int lo, int hi){

		for (int i = lo + 1; i <= hi; i++) {
	        int currentElement = a.get(i);
	        int j = i - 1;

	        while (j >= lo && a.get(j) > currentElement) {
	            a.set(j + 1, a.get(j));
	            j--;
	        }
	        a.set(j + 1, currentElement);
	    }

		//quickSort(a, lo, hi);
	}

	//public void printList(){System.out.println(list);}

}

 */