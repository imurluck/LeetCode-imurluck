package classification.dp.easy;

public class NumberOfLines806 {

    public int[] numberOfLines(int[] widths, String S) {
        int lines = S.length() > 0 ? 1 : 0;
        int width = 0;

        for (int i = 0; i < S.length(); i++) {
            width += widths[S.charAt(i) - 'a'];
            if (width > 100) {
                lines++;
                width = widths[S.charAt(i) - 'a'];
            }
        }
        return new int[] {lines, width};
    }
}
