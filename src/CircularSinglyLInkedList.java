import java.util.List;
import java.util.NoSuchElementException;

public class CircularSinglyLInkedList {
    private ListNode last;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLInkedList() {
        last = null;
        length = 0;
    }

    private int length() {
        return length;
    }

    private boolean isEmpty() {
        return length == 0;
    }

    private void createCLL() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    private void print() {
        if(last == null) {
            return;
        }
        ListNode first = last.next;
        while(first != last) {
            System.out.print(first.data + " ----> ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    private void insertFirst(int val) {
        ListNode temp = new ListNode(val);
        if(last == null) {
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    private void insertLast(int val) {
        ListNode temp = new ListNode(val);
        if(last == null) {
            last = temp;
            temp.next = temp;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    private ListNode removeNode() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        ListNode prev = null;
        ListNode temp = last.next;
        if(last.next == last) {
            last =  null;
        } else {
            while(temp != last) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = last.next;
            temp.next = null;
            last = prev;
        }
        return temp;
    }


    public static void main(String[] args) {
        CircularSinglyLInkedList csll = new CircularSinglyLInkedList();
        csll.createCLL();
        csll.print();
        csll.insertFirst(0);
        csll.print();
        csll.insertLast(5);
        csll.print();
        System.out.println(csll.removeNode());
        csll.print();
    }
}