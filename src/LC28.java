public class LC28 {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        int index = strStr(haystack, needle);
        System.out.println("hi");
    }

    public static int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        for (int i = 0; i < haystack.length() - needleLength; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
