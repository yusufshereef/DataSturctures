package heaps;

public class HeapMain {
    public static void main(String[] args) throws Exception{
        Heap heap = new Heap(10);
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(15);
        heap.add(5);
        //either use try catch or use throws in method signature
//        heap.poll();
        heap.display();
    }
}
