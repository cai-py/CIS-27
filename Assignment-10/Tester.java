public class Tester {
    public static void main(String[] args) {
        // initialize red-black tree
        RedBlackBST<Integer, String> rbTree = new RedBlackBST<>();

        // insert 60 keys
        for (int i = 1; i <= 60; i++) {
            rbTree.put(i, "value " + i);
        }
        System.out.println("tree size: " + rbTree.size());

        System.out.println("in order:");
        rbTree.printInOrder();
        System.out.println("\nvisual representation of the tree:");
        // rbTree.printTree(); // decided not to implement printTree() for now

        // delete keys 1 to 20
        for (int i = 1; i <= 20; i++) {
            rbTree.delete(i);
        }
        System.out.println("size of the tree after deleting 20 keys: " + rbTree.size());

        System.out.println("in order:");
        rbTree.printInOrder();
    }
}
