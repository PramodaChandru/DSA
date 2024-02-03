import java.util.List;

public class MaxSumArray {

    public static int maximizePositiveElements(List<Integer> arr) {
        int maxPositives = 0;
        int currentSum = 0;

        for (int num : arr) {
            if (currentSum + num > 0) {
                currentSum += num;
                maxPositives++;
            } else {
                break;
            }
        }

        return maxPositives;
    }

    public static void main(String[] args) {
        // Example usage:
        List<Integer> arr = List.of(-6, 3, 4 , -10);
        int result = maximizePositiveElements(arr);
        System.out.println("Maximum number of positive elements in psum: " + result);
    }
}
