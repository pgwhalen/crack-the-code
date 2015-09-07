package arraysandstrings;

/**
 * Created by paul on 9/7/15.
 *
 * 1.2 Implement a function void(reverse(char* str) in C or C++ which reverses a null-terminated string.
 * (Can still do the spirit of this in Java)
 */
public class Reverse {

    // in place (plus the swap)
    public static String reverse(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] c = s.toCharArray();
        int len = c.length;
        char swap;
        for (int i = 0; i < len/2; i++) {
            swap = c[len - i - 1];
            c[len - i - 1] = c[i];
            c[i] = swap;
        }

        return new String(c);
    }

    public static void main(String[] args) {
        String f1 = "abcde";
        String r1  = "edcba";
        System.out.println(f1 + ":" + reverse(r1));

        String f2 = "qwerty";
        String r2  = "ytrewq";
        System.out.println(f2 + ":" + reverse(r2));
    }
}
