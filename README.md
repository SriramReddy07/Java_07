# Java_07

import java.util.*;

public class LinkedList {
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

        public void print() {

        Node temp = head;

        while(temp != null) {

        System.out.print(temp.data + "->");
        temp = temp.next;

    }

    System.out.println("null");
    return;
   }



        public void reverse() {

         Node prev = null;
         Node curr = tail = head;
         Node next;

         while(curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
         }

         head = prev;
        }

        public void deleteNthNode(int n) {

            int size = 0;

            Node temp = head;

            while(temp != null) {

                temp = temp.next;
                size++;
            }

            if(n==size) {

                head = head.next;
                return;
            }

            int i = 1;
            int j = size-n;
            Node prev = head;

            while(i<j) {

                prev = prev.next;
                i++;
            }

            prev.next = prev.next.next;
           return;
            

        }

        public Node midnode(Node head) {

            Node slow = head;
            Node fast = head;

            while(fast != null && fast.next != null) {

                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        public boolean palindrome() {

            if(head == null || head.next == null) {

                return true;
            }

            Node prev = null;
            Node curr = midnode(head);
            Node next;

            while(curr != null) {

                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node right = prev;
            Node left = head;

            while(right != null) {

                if(left.data != right.data) {

                    return false;
                }

                right = right.next;
                left = left.next;
            }

            return true;
        }

    

     public static void main(String args[]) {
        
        LinkedList rr = new LinkedList();

        rr.addfirst(1);
        rr.addfirst(2);
        rr.addfirst(2);
        rr.addfirst(1);
        rr.print();
        //rr.reverse();
        //rr.print();
        //rr.deleteNthNode(3);
        //rr.print();
        System.out.println(rr.palindrome());

     }
}
