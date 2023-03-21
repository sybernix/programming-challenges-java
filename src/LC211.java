import java.util.List;

public class LC211 {
    static WordNode root;

    public static void main(String[] args) {
        root = new WordNode("root");
        addWord("bad");
        addWord("dad");
        boolean ans = search("bad");
        boolean ans2 = search("b.d");
        System.out.println("hi");
    }

    public static void addWord(String word) {
        String[] wordArray = word.split("");
        WordNode cur = root;
        for (String val: wordArray) {
            cur = cur.addChild(val);
        }
        cur.addChild("_");
    }

    public static boolean search(String word) {
        String[] wordArray = word.split("");
        return searchHelper(root, wordArray, 0);
    }

    public static boolean searchHelper(WordNode node, String[] wordArray, int start) {
        // WordNode cur = node;
        int len = wordArray.length;
        for (int i=0; i< len; i++) {
            if (wordArray[i].equals(".")) {
                List<WordNode> children = node.getChildren();
                for (WordNode child: children) {
                    if (searchHelper(child, wordArray, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                node = node.getChild(wordArray[i]);
                if (node == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
