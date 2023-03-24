import java.util.HashSet;
import java.util.Set;

public class LC1319 {
    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0,1}, {0,2}, {1,2}};
        int ans = makeConnected(n, connections);
        System.out.println("hi");
    }

    public static int makeConnected(int n, int[][] connections) {
        Set<Integer> connectedComputers = new HashSet<>();
        int removableConnections = 0;

        for (int[] connection: connections) {
            if (connectedComputers.contains(connection[0]) && connectedComputers.contains(connection[1])) {
                removableConnections++;
            } else {
                connectedComputers.add(connection[0]);
                connectedComputers.add(connection[1]);
            }
        }
        int disconnectedComputers = n - connectedComputers.size();
//        int minConns = disconnectedComputers - 1;
        if (disconnectedComputers <= removableConnections) {
            return disconnectedComputers;
        } else {
            return -1;
        }
    }
}
