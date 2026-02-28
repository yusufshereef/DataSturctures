package linkedList;

public class CLL {
    private class Node {
        int data;
        Node next;

        private Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    //***imp**//
    public void insertAtHead(int data){
        Node node = new Node(data);
        if(head == null) {
            head = node;
            node.next = node;
        }
        else {
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            node.next = head;
            temp.next = node;
            head = node;
        }
    }

    public void insertAtEnd(int data){
        Node node = new Node(data);
        if(head == null){
            node.next = node;
            head = node;
        }else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = node;
            node.next = head;
        }
    }

    //*****important*****//
    public void insertAtPos(int data, int pos){
        Node node = new Node(data);
        if(pos == 1){
            if(head == null){
                node.next = node;
                head = node;
            }else{
                Node temp = head;
                while(temp.next == head){
                    temp = temp.next;
                }
                node.next = head;
                temp.next = node;
                head = node;
            }
        }else{
            // if pos>=2 and head is null
            if(head == null){
                System.out.println("invalid pos");
                return;
            }
            Node temp = head;
            for(int i=1; i<pos-1; i++){
                temp = temp.next;
                if(temp == head){
                    System.out.println("invalid pos");
                    return;
                }
            }
            //handles end and middle
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void deleteAtHead(){
        if(head == null){
            System.out.println("ll is empty");
        }
        else if(head.next == head){
            head = null;
        }else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
        }
    }

    public void deleteAtEnd(){
        if(head == null){
            System.out.println("ll is empty");
        }
        else if(head.next == head){
            head = null;
        }else{
            Node temp = head;
            while(temp.next.next !=head){
                temp=temp.next;
            }
            temp.next = head;
        }
    }

    public void deleteData(int data){
        if(head == null){
            System.out.println("ll is empty");
        }
        else if(head.data == data){
            if(head.next == head){
                head = null;
            }else{
                Node temp = head;
                while(temp.next != head){
                    temp = temp.next;
                }
                head = head.next;
                temp.next=head;
            }
        }else{
            Node temp = head;
            while(temp.next.data != data){
                temp = temp.next;
                if(temp.next == head){
                    System.out.println("data not found");
                    return;
                }
            }
            temp.next = temp.next.next;
        }
    }


    public void display(){
        if(head == null){
            System.out.println("ll is empty");
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.data+" ");
            temp = temp.next;
        }while(temp != head);
        System.out.println();
    }
}
