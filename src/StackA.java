import java.util.EmptyStackException;

public class StackA<T> {
    private int top;
    private T[] arr;
    public StackA() {
        top = -1;
        arr = (T[]) new Object[10];
    }

    public StackA(int capacity) {
        top = -1;
        arr = (T[]) new Object[capacity];
    }

    public boolean isFull() {
        return arr.length == size();
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public T seek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public void push(T value) {
        if(isFull()) {
            throw new RuntimeException("Stack is full !!!");
        }
        top++;
        arr[top] = value;
    }

    public T pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is Empty !!!");
        }
        T result = arr[top];
        top--;
        return result;
    }

    public static void main(String[] args) {
        int value;
        StackA<Integer> stack = new StackA(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        value = stack.seek();
        System.out.println(value);
        stack.pop();
        value = stack.seek();
        System.out.println(value);
    }
}