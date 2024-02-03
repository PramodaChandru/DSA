public class SinglyLinkedList_01 {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.data +" --> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public int length() {
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        System.out.println("Length of the singly linked list is " + count);
        return count;
    }

    public void insertFirst(int val) {
        ListNode newNode = head;
        head = new ListNode(val);
        head.next = newNode;
    }

    public void insertEnd(int val) {
        ListNode newNode = new ListNode(val);
        if(head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAtPosition(int val, int position) {
        ListNode node = new ListNode(val);
        if(position != 0 && position <= length()) {
            if (position == 1) {
                node.next = head;
                head = node;
            } else {
                ListNode previous = head;
                int count = 1;
                while (count < position - 1) {
                    previous = previous.next;
                    count++;
                }
                ListNode curr = previous.next;
                node.next = curr;
                previous.next = node;
            }
        } else {
            System.out.println("Invalid position number");
        }
    }

    public ListNode deleteFirstNode() {
        if(head.next == null) {
            return null;
        } else {
           ListNode temp =  head;
           head = head.next;
           temp.next = null;
           return temp;
        }
    }

    private ListNode deleteEndNode() {
        if(head.next == null) {
            return null;
        } else {
            ListNode currNode = head;
            ListNode prevNode = null;
            while(currNode.next != null) {
                prevNode = currNode;
                currNode = currNode.next;
            }
            prevNode.next = null;
            return currNode;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList_01 sl = new SinglyLinkedList_01();

//        sl.head = new ListNode(10);
//        ListNode second = new ListNode(1);
//        ListNode third = new ListNode(8);
//        ListNode fourth = new ListNode(11);
//
//        sl.head.next = second;  //10 --> 1
//        second.next = third;//10 --> 1 --> 8
//        third.next = fourth;//10 --> 1 --> 8 --> 11 --> null

        sl.insertFirst(11);
        sl.insertFirst(8);
        sl.insertFirst(1);
        sl.insertFirst(10);

        sl.display();

        sl.insertEnd(15);
        sl.display();

        sl.insertAtPosition(20, 7);
        sl.display();


        sl.deleteFirstNode();
        sl.display();
        sl.insertFirst(10);

        sl.deleteEndNode();
        sl.display();
        sl.insertEnd(10);

    }


}
