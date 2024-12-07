// Borrowed double-linked-list from assignment 2

public class LinkedList<T extends Comparable<T>> {
    private class DoubleNode {
        T data;
        DoubleNode prev, next;

        public DoubleNode(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private DoubleNode head;
    private DoubleNode tail;

    // sort methods
    // mergeSort(); start the sorting process
    public void mergeSort() {
        if (head == null || head.next == null) return; // already sorted
        head = mergeSort(head); // recursive sorting

        // Update tail after sorting
        DoubleNode current = head;
        while (current.next != null) {
            current = current.next; // loop to the last node
        }
        tail = current; // update tail
    }

    // mergeSort(DoubleNode); // recursive mergesort
    private DoubleNode mergeSort(DoubleNode start) {
        if (start == null || start.next == null) return start; // already sorted

        // split into two halves
        DoubleNode middle = splitList(start);
        DoubleNode secondHalf = middle.next;
        middle.next = null; // breaks list

        // recursively sort both halves - https://www.youtube.com/watch?v=mB5HXBb_HY8&t=1173s
        DoubleNode left = mergeSort(start);
        DoubleNode right = mergeSort(secondHalf);

        // print current state
        DoubleNode merged = mergeSortedLists(left, right);
        printCurrentState(merged);

        // merge the sorted halves
        return merged;

    }

    // splitList(DoubleNode); // returns the midpoint object of the list
    private DoubleNode splitList(DoubleNode start) {
        DoubleNode slow = start, fast = start;

        // Use two-pointer technique to find the middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
        }
        return slow; // Slow pointer points to the middle
    }


    // mergeSortedLists(DoubleNode, DoubleNode); // merge two sorted sub-lists
    private DoubleNode mergeSortedLists(DoubleNode left, DoubleNode right) {
        DoubleNode dummy = new DoubleNode(null); // Dummy node to simplify merging
        DoubleNode current = dummy;

        // Merge nodes from both lists
        while (left != null && right != null) {
            if (left.data.compareTo(right.data) <= 0) { // left <= right?; compareTo - compares objects and strings https://www.w3schools.com/java/ref_string_compareto.asp
                current.next = left;
                left.prev = current;
                left = left.next;
            } else {
                current.next = right;
                right.prev = current;
                right = right.next;
            }
            current = current.next;
        }

        // add remaining nodes
        if (left != null) {
            current.next = left;
            left.prev = current;
        }
        if (right != null) {
            current.next = right;
            right.prev = current;
        }

        dummy.next.prev = null; // Ensure the new head has no previous pointer
        return dummy.next; // Return the merged list starting from the first node
    }

    // print the current state of the list
    private void printCurrentState(DoubleNode node) {
        DoubleNode current = node;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }


    // editing methods
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtBeginning(T data) {
        DoubleNode newNode = new DoubleNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtEnd(T data) {
        DoubleNode newNode = new DoubleNode(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    public void removeFromBeginning() {
        if (head == null) {
            System.out.println("Error: list empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void removeFromEnd() {
        if (tail == null) {
            System.out.println("Error: list empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void insertBefore(T node, T data) {
        DoubleNode current = head;
        while (current != null && !current.data.equals(node)) {
            current = current.next;
        }
        if (current != null) {
            DoubleNode newNode = new DoubleNode(data);
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = newNode;
            } else {
                head = newNode;
            }
            current.prev = newNode;
        } else {
            insertAtEnd(data);
        }
    }

    public void insertAfter(T node, T data) {
        DoubleNode current = head;
        while (current != null && !current.data.equals(node)) {
            current = current.next;
        }
        if (current != null) {
            DoubleNode newNode = new DoubleNode(data);
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            current.next = newNode;
        } else {
            insertAtEnd(data);
        }
    }

    public void removeNode(T node) {
        DoubleNode current = head;
        while (current != null && !current.data.equals(node)) {
            current = current.next;
        }
        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
        }
    }

    public void moveToFront(T data) {
        removeNode(data);
        insertAtBeginning(data);
    }

    public void moveToEnd(T data) {
        removeNode(data);
        insertAtEnd(data);
    }

    // about methods
    public void printList() {
        DoubleNode current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current != tail) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }

    public int getLength() {
        int length = 0;
        DoubleNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }
}


