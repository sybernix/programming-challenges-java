public class LC875 {
    public static void main(String[] args) {
        int[] piles = new int[] {1000000000,1000000000};
        int h = 3;
        int ans = minEatingSpeed(piles, h);
        System.out.println("hi");
    }
    public static int minEatingSpeed(int[] piles, int h) {
        long max = -1;
        for (int pile: piles) {
            if (pile > max) {
                max = pile;
            }
        }
        long maxK = Math.max((long) Math.ceil(max * piles.length / (double) h), max);
        int minK = findMinK(piles, h, 0, maxK);
        return minK;
    }

    private static int findMinK(int[] piles, int h, long startK, long endK) {
        if (startK >= endK - 1) {
            return (int) endK;
        }
        int timeTaken = 0;
        long midK = (startK + endK ) / 2;
        for (int pile: piles) {
            timeTaken += Math.ceil(pile / (double) midK);
        }
        if (timeTaken <= h) {
            return findMinK(piles, h, startK, (long) midK);
        } else {
            return findMinK(piles, h, (long) midK, endK);
        }
    }
}
