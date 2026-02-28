package linkedList;

import java.util.Scanner;

public class DLL {
    private class Node {
        private Node prev;
        private int data;
        private Node next;

        private Node(int data) {
            this.prev = null;
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void create(){
        int ch;
        int data;
        Node temp=head;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("enter data for new node: ");
            data = sc.nextInt();
            Node node = new Node(data);
            if(head == null){
                head = node;
            }else {
                node.prev = temp;
                temp.next = node;
            }
            temp = node;
            System.out.println("enter 1 to create new node and 0 to exit");
            ch = sc.nextInt();
        }while(ch != 0);
    }

    public void insertAtHead(int data){
        Node node = new Node(data);
        if(head != null){
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public void insertAtEnd(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next = node;
        node.prev = temp;
    }

    public void insert(int data, int pos){
        Node node = new Node(data);
        if(pos == 1){
            if(head != null){
                node.next = head;
                head.prev = node;
            }
            head = node;
        }else{
            if(head == null){
                System.out.println("invalid pos");
                return;
            }
            Node temp = head;
            for(int i=1; i<pos-1; i++){
                temp=temp.next;
                if(temp == null){
                    break;
                }
            }
            if(temp == null) {
                System.out.println("invalid pos");
                return;
            }
            if(temp.next!=null){
                node.next = temp.next;
                temp.next.prev = node;
            }
            node.prev = temp;
            temp.next = node;
        }
    }

    public void deleteAtHead(){
        if(head == null){
            System.out.println("ll is empty ");
        }
        else if(head.next == null){
            head = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteAtEnd(){
        if(head == null){
            System.out.println("ll is empty");
        }
        else if(head.next == null){
            head = null;
        }
        else {
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.prev.next = null;
        }
    }

    public void deleteData(int data){
        if(head == null){
            System.out.println("ll is empty");
        }
        else if(head.data == data){
            head = head.next;
            if(head != null){
                head.prev = null;
            }
        }
        else {
            Node temp = head;
            while(temp != null && temp.data != data){
                temp = temp.next;
            }
            if(temp!=null){
                temp.prev.next = temp.next;
                if(temp.next != null){
                    temp.next.prev = temp.prev;
                }
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
