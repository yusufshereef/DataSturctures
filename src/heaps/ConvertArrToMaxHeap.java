package heaps;

public class ConvertArrToMaxHeap {
    public void heapify(int[] a, int size){
        for(int i=size/2; i>0; i--){
            adjust(a, i, size);
        }
    }

    //adjust ith node
    private void adjust(int[] a, int i, int size){
        int key = a[i];
        int j = 2 * i;
        while(j <= size){
            //if j<size right child exits
            if(j < size && a[j]<a[j+1]){
                j++; // point to right child if right is greater that left child
            }
            // if key is greater no need of adjustment as parent is greater than all children
            if(key > a[j]) break;
            a[j/2] = a[j];
            j*=2;
        }
        a[j/2] = key;
    }

}
