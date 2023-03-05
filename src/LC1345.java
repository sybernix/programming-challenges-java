import java.util.*;

public class LC1345 {
//    public class Node {
//        List<Node> neighbours = new ArrayList<>();
//        boolean isStart = false;
//        boolean isEnd = false;
//
//        public void addNeighbour(Node node) {
//            neighbours.add(node);
//        }
//
//        public List<Node> getNeighbours() {
//            return neighbours;
//        }
//
//        public void setStart() {
//            isStart = true;
//        }
//
//        public void setEnd() {
//            isEnd = true;
//        }
//    };

    public static void main(String[] args) {
        int[] arr = new int[]{100,-23,-23,404,100,23,23,23,3,404};
        int ans = minJumps(arr);

        System.out.println("hi");
    }

    public static int minJumps(int[] arr) {
        int n = arr.length;

        if (n==1) {
            return 0;
        }

        Map<Integer, List<Integer>> neighbours = new HashMap<>();
        for (int i=0; i<n; i++) {
            neighbours.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> storeIndex = new LinkedList<>();
        boolean[] visited = new boolean[n];
        storeIndex.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!storeIndex.isEmpty()) {
            int size = storeIndex.size();
            while (size-- > 0) {
                int currentIndex = storeIndex.poll();
                if (currentIndex == n-1) {
                    return steps;
                }

                List<Integer> jumpNextIndices = neighbours.get(arr[currentIndex]);
                jumpNextIndices.add(currentIndex - 1);
                jumpNextIndices.add(currentIndex + 1);
                for (int jumpNextIndex : jumpNextIndices) {
                    if (jumpNextIndex >= 0 && jumpNextIndex < n && !visited[jumpNextIndex]) {
                        storeIndex.offer(jumpNextIndex);
                        visited[jumpNextIndex] = true;
                    }
                }
                jumpNextIndices.clear();
            }
            steps++;
        }
        return -1;

    }
}
