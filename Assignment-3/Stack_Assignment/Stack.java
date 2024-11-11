public class Stack<Item> {
    private Node<Item> first = null; // top of stack
    private int size = 0; // size of the stack

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public Item pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        return first.item;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String stack = "";
        for (Node<Item> n = first;n != null; n = n.next){
            stack += n.item.toString();
        }

        return stack;
    }
}
