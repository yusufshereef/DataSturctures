package stacks;

public class StackMain {
    public static void main(String[] args) throws RuntimeException{
        StackArray st = new StackArray(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st.pop());
        st.display();
    }
}
