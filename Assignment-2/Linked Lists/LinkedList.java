public class LinkedList {
    private class DoubleNode {
        String data;
        DoubleNode prev, next;

        public DoubleNode(String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private DoubleNode head;
    private DoubleNode tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtBeginning(String data) {
        DoubleNode newNode = new DoubleNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(String data) {
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
        if (head == null) { System.out.println("Error: list empty");}
        if (head == tail) {
            head = tail = null;
        }else {
            head = head.next;
            head.prev = null;
        }
    }

    public void removeFromEnd() {
        if (tail == null) { System.out.println("Error: list empty");}
        if (head == tail) {
            head = tail = null;
        }else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void insertBefore(String node, String data) {
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
            }else {
                head = newNode;
            }
            current.prev = newNode;
        }else {
            insertAtEnd(data);
        }
    }

    public void insertAfter(String node, String data) {
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
            }else {
                tail = newNode;
            }
            current.next = newNode;
        }else {
            insertAtEnd(data);
        }
    }

    public void removeNode(String node) {
        DoubleNode current = head;
        while (current != null && !current.data.equals(node)) {
            current = current.next;
        }
        if (current != null) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void moveToFront(String data) {
        removeNode(data);
        insertAtBeginning(data);
    }

    public void moveToEnd(String data) {
        removeNode(data);
        insertAtEnd(data);
    }

    public void printList() {
        DoubleNode current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current != tail) { System.out.print("->"); }
            current = current.next;
        }
        System.out.println();
    }
}


//public class DoubleNode {
//    private DoubleNode prev;
//    private DoubleNode next;
//    private String value;
//
//    public DoubleNode() {}
//    public DoubleNode(DoubleNode prv, DoubleNode nxt, String data) {
//        prev = prv;
//        value = data;
//        next = nxt;
//    }
//
//    // get/set methods
//    public DoubleNode getPrev() {
//        return prev;
//    }
//    public DoubleNode getNext() {
//        return next;
//    }
//    public void setPrev(DoubleNode n) {
//        prev = n;
//    }
//    public void setNext(DoubleNode n) {
//        next = n;
//    }
//
//}