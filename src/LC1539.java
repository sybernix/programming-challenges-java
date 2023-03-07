public class LC1539 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,7,11};
        int k = 5;
        int ans = findKthPositive(arr, k);
        System.out.println("hi");
    }
    public static int findKthPositive(int[] arr, int k) {
        int last = 0;
        int numMissing = 0;
        for (int num: arr) {
            int diff = num - last - 1;
            if (numMissing + diff >= k) {
                return last + k - numMissing;
            } else {
                numMissing += diff;
                last = num;
            }
        }
        return last + k - numMissing;
    }
}
