import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LC1675 {
    public static int minimumDeviation(int[] nums) {
        TreeSet<Integer> numSet = new TreeSet<>();
        for (int num: nums) {
            numSet.add(num % 2 == 0 ? num : num * 2);
        }
        int minDev = Integer.MAX_VALUE;
        while (true) {
            int max = numSet.last();
            int min = numSet.first();
            minDev = Math.min(minDev, max - min);
            if (max % 2 == 0) {
                numSet.remove(max);
                numSet.add(max / 2);
            } else {
                break;
            }
        }
        return minDev;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int ans = minimumDeviation(nums);
        System.out.println("hi");
    }
}
