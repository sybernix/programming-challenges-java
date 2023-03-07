public class LC912 {
    public static void main(String[] args) {
        int[] nums = new int[] {5,2,3,1};
        mergeSort(nums, 0, nums.length-1);
        System.out.println("hi");
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        int p = left;
        for (int num: temp) {
            nums[p++] = num;
        }
    }
    public static int[] bubbleSort(int[] nums) {
        while(true) {
            boolean isSwitch = false;
            for (int i=0; i<nums.length - 1; i++) {
                if (nums[i] > nums[i+1]) {
                    nums[i] = nums[i] + nums[i+1];
                    nums[i+1] = nums[i] - nums[i+1];
                    nums[i] = nums[i] - nums[i+1];
                    isSwitch = true;
                }
            }
            if (!isSwitch) {
                return nums;
            }
        }
    }
}
