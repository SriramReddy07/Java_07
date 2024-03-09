import java.util.*;

public class Zigzagll {
    public class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addfirst(int data) {

    Node nn = new Node(data);

    if(head == null) {

        head = tail = nn;
        return;
    }

    nn.next = head;
    head = nn;

   }


    public void zigzagll() {

         Node slow = head;
         Node fast = head.next;

         while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;

        while(curr != null) {

            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node lf = head;
        Node rh = prev;

         while(lf != null && rh != null) {

            Node nextlf = lf.next;
            lf.next = rh;
            Node nextrh = rh.next;
            rh.next = nextlf;
            lf = nextlf;
            rh = nextrh;
        }

    }


    public void print() {

        Node temp = head;

        while(temp != null) {

             System.out.print(temp.data + "->");
             temp = temp.next;
        }
         System.out.println("null");
    }

    public static void main(String args[]) {

        Zigzagll ll = new Zigzagll();

        ll.addfirst(1);
        ll.addfirst(2);
        ll.addfirst(3);
        ll.addfirst(4);
        ll.addfirst(5);
        ll.print();   
        ll.zigzagll();
        ll.print();


    }
}