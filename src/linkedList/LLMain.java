package linkedList;

public class LLMain {
    public static void main(String[] args) {
        SLL l = new SLL();
        l.insert(10, 0);
        l.insert(20, 1);
        l.insert(15, 1);
        l.insert(30,2);
        l.deleteData(20);
        l.display();
    }
}
