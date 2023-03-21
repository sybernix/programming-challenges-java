import java.util.HashMap;
import java.util.Map;

class LC2348 {

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,0,2,0,0};
        long ans = zeroFilledSubarray(nums);
        System.out.println(ans);
    }
    private static Map<Integer, Long> sumMap = new HashMap<>();
    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int arrLength = 0;
        for (int num: nums) {
            if (num == 0) {
                arrLength++;
            } else {
                if (arrLength > 0) {
                    ans += findSum(arrLength);
                    arrLength = 0;
                }
            }
        }
        if (arrLength > 0) {
            ans += findSum(arrLength);
            arrLength = 0;
        }
        return ans;
    }

    public static Long findSum(int num) {
        if (sumMap.containsKey(num)) {
            return sumMap.get(num);
        } else {
            long sum = 0;
            for (int i=1; i<= num; i++) {
                sum += i;
            }
            sumMap.put(num, sum);
            return sum;
        }
    }
}