package Geek;

public class GeneratingUniqueScoreboardCode {
    private static char minNumChar = '0';
    private static char maxNumChar = '9';

    private static char minSymbChar = 'a';
    private static char maxSymbChar = 'z';

    private static String getNextCode(String code) {
        char[] codeChars = code.toCharArray();
        boolean shouldBreak = false;
        int idx;
        for (idx = codeChars.length - 1; idx >= 0; idx--) {

            if (idx % 2 == 0) {
                if (codeChars[idx] < maxSymbChar) {
                    codeChars[idx]++;
                    break;
                } else {
                    codeChars[idx] = minSymbChar;
                }

            } else {
                if (codeChars[idx] < maxNumChar) {
                    codeChars[idx]++;
                    break;
                } else {
                    codeChars[idx] = minNumChar;
                }
            }
        }


        if (idx == -1) {
            int newCodeLength = codeChars.length / 2 + 1;

            return new String(new char[newCodeLength]).replace("\0", "a0");
        }
        return new String(codeChars);
    }

    public static void main(String[] args) {
        String nextCode = getNextCode("a0a1");
        System.out.println(nextCode);
    }
}
