public class Tester {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        myList.insertAtEnd("C");
        myList.insertAtEnd("O");
        myList.insertAtEnd("M");
        myList.insertAtEnd("P");
        myList.insertAtEnd("U");
        myList.insertAtEnd("T");
        myList.insertAtEnd("E");

        System.out.println("1. Print the contents of the list");
        System.out.println("C->O->M->P->U->T->E");
        myList.printList(); // C->O->M->P->U->T->E

        System.out.println("2. Insert M at the beginning of the list");
        myList.insertAtBeginning("M");
        System.out.println("M->C->O->M->P->U->T->E");
        myList.printList(); // M->C->O->M->P->U->T->E

        System.out.println("3. Insert R at the end");
        myList.insertAtEnd("R");
        System.out.println("M->C->O->M->P->U->T->E->R");
        myList.printList(); // M->C->O->M->P->U->T->E->R

        System.out.println("4. Remove from the beginning");
        myList.removeFromBeginning();
        System.out.println("C->O->M->P->U->T->E->R");
        myList.printList(); // C->O->M->P->U->T->E->R

        System.out.println("5. Remove from the end");
        myList.removeFromEnd();
        System.out.println("C->O->M->P->U->T->E");
        myList.printList(); // C->O->M->P->U->T->E

        System.out.println("6. Insert M before P");
        myList.insertBefore("P", "M");
        System.out.println("C->O->M->M->P->U->T->E");
        myList.printList(); // C->O->M->M->P->U->T->E

        System.out.println("7. Insert H before M");
        myList.insertBefore("M", "H");
        System.out.println("C->O->H->M->M->P->U->T->E");
        myList.printList(); // C->O->H->M->M->P->U->T->E

        System.out.println("8. Insert B before A");
        myList.insertBefore("A", "B");
        System.out.println("C->O->H->M->M->P->U->T->E->B");
        myList.printList(); // C->O->H->M->M->P->U->T->E->B

        System.out.println("9. Insert C after P");
        myList.insertAfter("P", "C");
        System.out.println("C->O->H->M->M->P->C->U->T->E->B");
        myList.printList(); // C->O->H->M->M->P->C->U->T->E->B

        System.out.println("10. Insert L after M");
        myList.insertAfter("M", "L");
        System.out.println("C->O->H->M->L->M->P->C->U->T->E->B");
        myList.printList(); // C->O->H->M->L->M->P->C->U->T->E->B

        System.out.println("11. Remove M");
        myList.removeNode("M");
        System.out.println("C->O->H->L->M->P->C->U->T->E->B");
        myList.printList(); // C->O->H->L->M->P->C->U->T->E->B

        System.out.println("12. Remove G");
        myList.removeNode("G");
        System.out.println("C->O->H->L->M->P->C->U->T->E->B");
        myList.printList(); // C->O->H->L->M->P->C->U->T->E->B

        System.out.println("13. Move P to the front of the list");
        myList.moveToFront("P");
        System.out.println("P->C->O->H->L->M->C->U->T->E->B");
        myList.printList(); // P->C->O->H->L->M->C->U->T->E->B

        System.out.println("14. Move L to the end of the list");
        myList.moveToEnd("L");
        System.out.println("P->C->O->H->M->C->U->T->E->B->L");
        myList.printList(); // P->C->O->H->M->C->U->T->E->B->L
    }
}
