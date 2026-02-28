package linkedList;

public class LLMain {
    public static void main(String[] args) {
//        SLL l = new SLL();
//        l.insertAtPos(10, 1);
//        l.insertAtPos(20, 2);
//        l.iinsertAtPos(15, 2);
//        l.iinsertAtPos(12,1);
//        l.deleteData(10);
//        l.display();

//        DLL l = new DLL();
//        l.create();
//        l.display();

        CLL l = new CLL();
        l.insertAtHead(10);
        l.insertAtHead(20);
        l.insertAtHead(30);
        l.insertAtEnd(40);
        l.insertAtEnd(15);
        l.display();
        l.insertAtPos(35, 7);
        l.display();
    }
}
