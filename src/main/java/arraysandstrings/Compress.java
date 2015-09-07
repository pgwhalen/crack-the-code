package arraysandstrings;

/**
 * Created by paul on 9/7/15.
 *
 * 1.5 Implement a method to perform basic string compression using the counts of repeated characters.  For example, the
 * string aabcccccaaa would become a2b1c5a3.  If the compressed string would not be smaller than the origin string,
 * your method should return the original string.
 */
public class Compress {

    // not in place, using a string builder
    public static String compress(String s) {
        char[] chars = s.toCharArray();
        char curChar = '\0';
        int curCount = 0;

        StringBuilder sb = new StringBuilder();

        for (char c : chars) {

            if (c != curChar && curChar != '\0') {
                sb.append(curChar);
                sb.append(curCount);
                curCount = 0;
            }

            curCount++;
            curChar = c;
        }
        sb.append(curChar);
        sb.append(curCount);

        String newString = sb.toString();
        return newString.length() < s.length() ? newString : s;
    }

    public static void main(String[] args) {
        String s1 = "aabcccccaaa";
        System.out.println(compress(s1));

        String s2 = "aabcde";
        System.out.println(compress(s2));

        String s3 = "aabcccccaaadjpppwwwww";
        System.out.println(compress(s3));

    }
}
