public class Interview {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5, 5};
        int[] arr2 = new int[]{4, 7, 9, 11};
        int[] ans = mergeArrays(arr1, arr2);
        System.out.println(ans);
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length + arr2.length];

        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < ans.length; i++) {
            if (arr1[p1] <= arr2[p2]) {
                ans[i] = arr1[p1];
                if (p1 < arr1.length - 1) {
                    p1++;
                } else {

                }
            } else {
                ans[i] = arr2[p2];
                p2++;
            }
        }
        return ans;
    }
}
