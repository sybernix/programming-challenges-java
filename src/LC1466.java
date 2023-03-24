import java.util.ArrayList;
import java.util.List;

public class LC1466 {
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int ans = minReorder(n, connections);
        System.out.println("hi");
    }

    public static int minReorder(int n, int[][] connections) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i< n; i++) {
            edges.add(new ArrayList<>());
        }

        for (var edge: connections) {
            int from = edge[0];
            int to = edge[1];
            edges.get(from).add(to);
            edges.get(to).add(-from);
        }
        return dfs(edges, new boolean[n], 0);
    }

    public static int dfs(List<List<Integer>> edges, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (var to: edges.get(from)) {
            if (!visited[Math.abs(to)]) {
                change += dfs(edges, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }
        return change;
    }
}
