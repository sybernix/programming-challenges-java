public class LC72 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int distance = minDistance(word1, word2);
        System.out.println("hi");

    }

    public static int minDistance(String word1, String word2) {
        int[][] editsMatrix = new int[word2.length() + 1][word1.length() + 1];
        for (int i = 0; i < editsMatrix.length; i++) {
            editsMatrix[i][0] = i;
        }
        for (int i = 0; i < editsMatrix[0].length; i++) {
            editsMatrix[0][i] = i;
        }
        for (int i = 1; i < editsMatrix.length; i++) {
            for (int j = 1; j < editsMatrix[0].length; j++) {
                if (word1.charAt(j-1) == word2.charAt(i-1)) {
                    editsMatrix[i][j] = editsMatrix[i-1][j-1];
                } else {
                    int minDist = Math.min(editsMatrix[i-1][j], editsMatrix[i][j-1]);
                    minDist = Math.min(minDist, editsMatrix[i-1][j-1]) + 1;
                    editsMatrix[i][j] = minDist;
                    System.out.println(minDist);
                }
            }
        }
        return editsMatrix[word2.length() + 1][word1.length() + 1];
    }
}
