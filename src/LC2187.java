import java.util.Arrays;

public class LC2187 {
    public static void main(String[] args) {
        int[] time = new int[] {5, 10, 10};
        int totalTrips = 9;
        long ans = minimumTime(time, totalTrips);
        System.out.println("hi");
    }

    public static boolean timeEnough(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;
        for (int t : time)
            actualTrips += givenTime / t;
        return actualTrips >= totalTrips;
    }
    public static long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        int max_time = 0;
        for (int t : time) {
            max_time = Math.max(max_time, t);
        }
        long right = (long) max_time * totalTrips + 1;
        while (left < right) {
            int currentTrips = 0;
            long mid = (left + right) / 2;
            if (timeEnough(time, mid, totalTrips)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
