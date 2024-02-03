import java.util.HashMap;
import java.util.Map;

public class Unique {

    public static int firstUniqueCharIndex(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Count occurrences of each character in the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
        }

        // Find the first unique character's index
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (charCount.get(currentChar) == 1) {
                return i + 1; // 1-based index
            }
        }

        return -1; // No unique character found
    }

    public static void main(String[] args) {
        // Example usage:
        String inputString = "caca";
        int result = firstUniqueCharIndex(inputString);
        System.out.println(result);
    }
}
