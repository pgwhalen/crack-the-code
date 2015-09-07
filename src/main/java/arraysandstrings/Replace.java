package arraysandstrings;

/**
 * Created by paul on 9/7/15.
 *
 * 1.4 Write a method to replace all spaces in a string with '%20.' You may assume that the string has sufficient space at
 * the end of the string to hold the additional characters, and that you are given the "true" length of the string.
 * (Using char array for java so it's C-like)
 */
public class Replace {

    static char[] REPLACE = new char[]{'%', '2', '0'};

    // for this solution i need a buffer the length of the string.  pretty sure that's the right space constraint.
    // time constraint is O(2n) which has to be as good as it gets.
    // this is kinda special-casey what with the hard coded indices and all
    // (in place).
    public static void replace(char[] c, int len) {
        char[] buf = new char[len];
        int bufHead = 0;
        int writeHead = 0;
        for (int readHead = 0; readHead < len; readHead++) {
            if (c[readHead] == ' ') { // this char is a space; buffer the next part of the string and do the replace
                System.out.println("readHead " + readHead);
                buf[bufHead++] = c[readHead + 1];
                buf[bufHead++] = c[readHead + 2];

                c[writeHead++] = REPLACE[0];
                c[writeHead++] = REPLACE[1];
                c[writeHead++] = REPLACE[2];
            } else if (bufHead != 0) { // this char is not a space, but we have something in the buffer so let's empty it
                char bufChar;
                while ((bufChar = buf[bufHead++]) != '\0') {
                    System.out.println("bufHead: " + bufHead);
                    c[writeHead++] = bufChar;
                }
                bufHead = 0;
            } else { // not a space and nothing in the buffer, just write the readHead at writeHead
                c[writeHead++] = c[readHead];
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "Hi there Sam    ";
        char[] c = s1.toCharArray();
        replace(c, 12);
        System.out.println(new String(c));
    }
}
