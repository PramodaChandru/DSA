import java.util.NoSuchElementException;

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int value) {
            this.data = value;
            this.next = null;
        }
    }

    public Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enQueue(int value) {
        ListNode node = new ListNode(value);
        if(isEmpty()) {
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
        length++;
    }

    public int deQueue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        int result = front.data;
        front = front.next;
        if(front == null) {
            rear = null;
        }
        length--;
        return result;
    }

    public void print() {
        ListNode temp = front;
        while(temp.next != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.print();
        queue.deQueue();
        queue.print();
    }
}
