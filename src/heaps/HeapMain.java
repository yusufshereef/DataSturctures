package heaps;

public class HeapMain {
    public static void main(String[] args) throws Exception{
//        Heap heap = new Heap(10);
//        heap.add(10);
//        heap.add(20);
//        heap.add(30);
//        heap.add(15);
//        heap.add(5);
//        //either use try catch or use throws in method signature
//       heap.poll();
//        heap.display();

        ConvertArrToMaxHeap h = new ConvertArrToMaxHeap();
        //size = a.length-1;
        //elements are from 1 to size
        int a[] = {0, 10, 20, 15, 40, 50, 100, 25, 45, 5, 35};
        int size = a.length-1;
//        h.heapify(a, size);
//        for(int ele : a){
//            System.out.print(ele+" ");
//        }
        h.heapSortAscendingOrder(a, size);
        for(int ele : a){
            System.out.print(ele + " ");
        }
    }
}
