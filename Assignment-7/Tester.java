public class Tester {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();


        // Test Case 1: Sorting a list of characters
        System.out.println("=== Test Case 1: Sorting an Unsorted List ===");
        String unsortedList = "MERGESORTEXAMPLE";

        // Insert characters into the list
        for (int i = 0; i < unsortedList.length(); i++) {
            list.insertAtEnd(unsortedList.charAt(i));
        }

        System.out.println("Unsorted List:");
        list.printList();

        // MergeSort
        System.out.println("***** Sorting Steps *****");
        list.mergeSort();

        System.out.println("Sorted List:");
        list.printList();
    }
}
