public class Tester {
    public static void main(String[] args) {
        String nodes = "COMPUTE";

        DoubleNode n1 = new DoubleNode();
        n1.addNext();

        for (int i = 0; i < nodes.length(); i++) {
            n1.addNext(nodes.charAt(i));
        }
    }
}
