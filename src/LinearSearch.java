public class LinearSearch {

    public int search(int arr[], int n, int x) {
        for(int i = 0; i < n; i++) {
            if(arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();
        int result = ls.search(new int[]{5,1,9,2,10,15,20},7, 10);
        System.out.println(result);
    }
}
