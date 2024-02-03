import java.util.Scanner;

public class RemoveEvenIntegers_Array {
    public static void main(String[] args) {
        int n = getArraySize();
        int[] arr = new int[n];
        arr = getArrayElements(n);
        arr = removeEvenIntegers(arr);
        ArrayUtil.printArray(arr);

    }

    private static int[] removeEvenIntegers(int[] arr) {
        int resultArr[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0) {
                //resultArr[i] =
            }
        }
        return resultArr;
    }

    public static int getArraySize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = sc.nextInt();
        return n;
    }

    public static int[] getArrayElements(int n) {
        int[] arr = new int[n];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            System.out.println("Enter array Elements");
            arr[i] = sc.nextInt();
        }
        return arr;
    }



}
