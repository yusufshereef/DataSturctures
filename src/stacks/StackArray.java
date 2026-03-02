package stacks;

public class StackArray {
    int[] a;
    int top;
    int size;

    public StackArray(int size){
        this.size = size;
        a = new int[size];
        this.top=-1;
    }
    
    public void push(int data){
        if(top==size-1){
            System.out.println("stack is full");
            return;
        }
        a[++top] = data;
    }

    public int pop() throws RuntimeException{
        if(top == -1){
            throw new RuntimeException("stack is empty");
        }
        int x = a[top];
        top--;
        return x;
    }

    public void display(){
        for(int i=top; i>=0; i--){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}