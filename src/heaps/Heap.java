package heaps;

public class Heap {
    private int[] a;
    private final int capacity;
    private int size;

    public Heap(int capacity){
        this.capacity = capacity;
        a = new int[capacity];
    }

    private void swap(int first, int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    private int parentIndex(int index){
        return (index-1)/2;
    }
    private int leftIndex(int index) {
        return 2*index+1;
    }
    private int rightIndex(int index){
        return 2*index+2;
    }

    public void add(int value){
        if(size == capacity) {
            System.out.println("heap is full");
            return;
        }
        a[size] = value;
        upheap(size);
        size++;
    }

    private void upheap(int index){
        if(index == 0){
            return;
        }
        int pIndex = parentIndex(index);
        if(a[pIndex]>a[index]){
            swap(pIndex, index);
        }
        upheap(pIndex);
    }

    public int poll() throws Exception{
        if(size == 0){
            throw new Exception("heap is empty");
        }
        int element = a[0];
        int lastElement = a[size-1];
        size--;
        if(size != 0){
            a[0] = lastElement;
            downHeap(0);
        }
        return element;
    }

    private void downHeap(int index){
        int minIndex = index;
        int lIndex = leftIndex(index);
        int rIndex = rightIndex(index);

        if(lIndex < size && a[lIndex]<a[index]){
            minIndex = lIndex;
        }
        if(rIndex < size && a[rIndex]<a[index]){
            minIndex = rIndex;
        }

        if(minIndex != index){
            swap(minIndex, index);
            downHeap(minIndex);
        }
    }

    public void display(){
        if(size == 0) {
            System.out.println("heap is empty");
            return;
        }
        for(int i=0; i<size; i++){
            System.out.print(a[i] + " ");
        }
    }
}
