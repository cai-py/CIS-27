public class DoubleNode {
    private DoubleNode prev;
    private DoubleNode next;

    public DoubleNode() {}
    public DoubleNode(DoubleNode i, DoubleNode j) {

    }

    // get/set methods
    public DoubleNode getPrev() {
        return prev;
    }
    public DoubleNode getNext() {
        return next;
    }
    public void setPrev(DoubleNode n) {
        prev = n;
    }
    public void setNext(DoubleNode n) {
        next = n;
    }

}
