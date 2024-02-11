package xyz.toddlasley.random.arraysandstrings;

public class RecursiveEncryption {
    private static void encryptHelper(final String s, final int lowIndex, final int highIndex, final StringBuilder sb) {
        if (highIndex < lowIndex) {
            return;
        }

        final int mid = lowIndex + ((highIndex - lowIndex) / 2);

        sb.append(s.charAt(mid));

        encryptHelper(s, lowIndex, mid - 1, sb);
        encryptHelper(s, mid + 1, highIndex, sb);
    }

    public static String encrypt(final String s) {
        final StringBuilder sb = new StringBuilder(s.length());

        encryptHelper(s, 0, s.length() - 1, sb);

        return sb.toString();
    }
}
