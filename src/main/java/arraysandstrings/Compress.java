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
            curCount++;
            if (c != curChar && curChar != '\0') {
                sb.append(curChar);
                sb.append(curCount);
                curCount = 1;
            }
            curChar = c;

//            if (curChar == '\0') {
//
//            } else if (c != curChar && curChar != '\0') {
//                sb.append(curChar);
//                sb.append(curCount);
//                curCount = 1;
//            } else {
//                curCount++;
//            }
//            curChar = c;
        }
        String newString = sb.toString();
        return newString.length() < s.length() ? newString : s;
    }

    public static void main(String[] args) {
        String s1 = "aabcccccaaa";
        System.out.println(compress(s1));
    }
}
