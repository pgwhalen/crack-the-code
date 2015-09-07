package arraysandstrings;

import java.util.BitSet;

/**
 * Created by paul on 9/7/15.
 *
 * 1.3 Given two strings, write a method to determine is one is a permutation of the other.
 */
public class Permutation {

    // this is O(n^2), could it be better? i'm thinking no, since you have to search for each char you match.  i could
    // go without the bitset alloc and just use one of the strings to mark chars as you match them (with some special char)
    // but whatever.
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        BitSet foundInC2 = new BitSet(c2.length);

        for (int i = 0; i < c1.length; i++) {
            boolean found = false;
            for (int j = 0; j < c2.length; j++) {
                if (c1[i] == c2[j] && !foundInC2.get(j)) {
                    found = true;
                    foundInC2.set(j);
                    break;
                }
            }
            if (!found) return false;
        }

        return true;
    }

    public static boolean isPerm(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        return false;
    }

    public static void main(String[] args) {
        String a1 = "abcde";
        String a2 = "acebd";
        System.out.println("A: " + isPermutation(a1, a2));

        String b1 = "abcde";
        String b2 = "acegd";
        System.out.println("B: " + isPermutation(b1, b2));

        String c1 = "abbcde";
        String c2 = "acegdq";
        System.out.println("C: " + isPermutation(c1, c2));

        String d1 = "abbcde";
        String d2 = "acedbb";
        System.out.println("D: " + isPermutation(d1, d2));

    }
}
