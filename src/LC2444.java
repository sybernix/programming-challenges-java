public class LC2444 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,2,7,5};
        int minK = 1, maxK = 5;
        long ans = countSubarrays(nums, minK, maxK);
        System.out.println("hi");
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int lastMin = -1;
        int lastMax = -1;
        int leftBound = -1;
        int size = nums.length;
        long count = 0;

        for (int i=0; i<size; i++) {
            if (nums[i] <= maxK && nums[i] >= minK) {
                lastMin = (nums[i] == minK) ? i : lastMin;
                lastMax = (nums[i] == maxK) ? i : lastMax;
                count += Math.max(0, Math.min(lastMin, lastMax) - leftBound);
            } else {
                leftBound = i;
                lastMax = -1;
                lastMin = -1;
            }
        }
        return count;
    }
}
