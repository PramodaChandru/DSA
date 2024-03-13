public class ReverseString {

    private String reverseString(String str) {
        char[] carr = str.toCharArray();
        StackA<Character> stackA = new StackA<>(carr.length);
        for(char c: carr) {
            stackA.push(c);
        }
        for(int i = 0; i < carr.length; i++) {
            carr[i] = stackA.pop();
        }
        return new String(carr);
    }

    public static void main(String[] args) {
        String str = "abc";
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseString(str));
    }
}
