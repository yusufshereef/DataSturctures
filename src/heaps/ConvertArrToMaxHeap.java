package heaps;

public class ConvertArrToMaxHeap {
    public void heapify(int[] a, int size){
        for(int i=size/2; i>0; i--){
            adjust(a, i, size);
        }
    }

    //adjust a parent node ( time-complexity is O(logn) )
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

    public void heapSortAscendingOrder(int[] a, int size){
        //construct initial max heap
        heapify(a, size);
        //swap root node (max ele) with last leaf node and adjust wrt to root node
        // doing this for ntimes makes the array sorted in descending order
        int n = a.length-1;
        for(int i=0; i<n; i++){
            //swap root node with last node
            int temp = a[1];
            a[1] = a[size];
            a[size] = temp;

            //now decrease the size to exclude the swapped node
            size--;

            //call adjust wrt to the root node as it is the only node which was disturbed
            adjust(a, 1, size);
        }
    }
}
