package linkedList;

import java.util.Scanner;

public class SLL {
    private class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void create() {
        Scanner sc = new Scanner(System.in);
        int ch;
        Node temp=null;
        do {
            System.out.println("Enter data: ");
            int data = sc.nextInt();
            Node node = new Node(data);
            if(head == null) {
                head = node;
            }else{
                temp.next = node;
            }
            temp = node;
            System.out.println("Enter 1 to enter new data and 0 to exit: ");
            ch = sc.nextInt();
        }while(ch != 0);
    }

    public void insert(int data, int index){
        Node node = new Node(data);
        if(index == 0){
            node.next=head;
            head = node;
        }
        else{
            Node temp = head;
            for(int i=0; i<index-1; i++){
                temp=temp.next;
                if(temp==null){
                    break;
                }
            }
            if(temp!=null){
                node.next = temp.next;
                temp.next = node;
            }else{
                System.out.println("invalid index");
            }
        }
    }

    public void deleteData(int data){
        if(head == null){
            System.out.println("ll is empty");
        }
        else if(head.data == data){
            head = head.next;
        }
        else{
            Node temp = head;
            while(temp.next!=null && temp.next.data != data){
                temp= temp.next;
            }
            if(temp.next!=null){
                temp.next = temp.next.next;
            }else{
                System.out.println("data not found");
            }
        }
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
