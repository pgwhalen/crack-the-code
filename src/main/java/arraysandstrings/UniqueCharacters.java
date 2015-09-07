package arraysandstrings;

import java.util.HashSet;

/**
 * Created by paul on 9/7/15.
 *
 * 1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data
 * structures?
 */
public class UniqueCharacters {

    public static boolean allUniqueCharacters(String s) {
        HashSet<Character> used = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            if (!used.add(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean allUniqueCharactersInPlace(String s) {
        char[] chars = s.toCharArray(); // this is an allocation, but the rest of the solution is in the spirit of the question

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (i != j && chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String one = "abcde";
        String two = "abcda";

        System.out.println("one: " + allUniqueCharactersInPlace(one));
        System.out.println("two: " + allUniqueCharactersInPlace(two));
    }
}
