public class LC443 {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int ans = compress(chars);
        System.out.println(ans);
    }

    public static int compress(char[] chars) {
//        StringBuilder sb = new StringBuilder();
        char lastChar = chars[0];
        int lastVal = 1;
        int newLength = 0;

        for (int i=1; i<chars.length; i++) {
            if (chars[i] == lastChar) {
                lastVal += 1;
            } else {
                chars[newLength++] = lastChar;
                if (lastVal > 1) {
                    String counterString = String.valueOf(lastVal);
                    for (int r=0; r<counterString.length(); r++) {
                        chars[newLength++] = counterString.charAt(r);
                    }
                }
                lastChar = chars[i];
                lastVal = 1;
            }
            if (i == chars.length - 1) {
                chars[newLength++] = lastChar;
                if (lastVal > 1) {
                    String counterString = String.valueOf(lastVal);
                    for (int r=0; r<counterString.length(); r++) {
                        chars[newLength++] = counterString.charAt(r);
                    }
                }
            }
        }
        return newLength;
    }
}
