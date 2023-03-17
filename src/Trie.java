import java.util.HashMap;
import java.util.Map;

class Trie {
    TrieTree root;

    public Trie() {
        root = new TrieTree("root");
    }

    public void insert(String word) {
        String[] wordArray = word.split("");
        TrieTree cur = root;
        for (String val: wordArray) {
            cur = cur.addChild(val);
        }
        cur.addChild("_");
    }

    public boolean search(String word) {
        String[] wordArray = word.split("");
        TrieTree cur = root;
        for (String val: wordArray) {
            cur = cur.getChild(val);
            if (cur == null) {
                return false;
            }
        }
        if (cur.getChild("_") != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        String[] wordArray = prefix.split("");
        TrieTree cur = root;
        for (String val: wordArray) {
            cur = cur.getChild(val);
            if (cur == null) {
                return false;
            }
        }
        return true;
    }
}

class TrieTree {
    String val;
    Map<String, TrieTree> children;

    public TrieTree(String val) {
        this.children = new HashMap<>();
        this.val = val;
    }

    public TrieTree addChild(String val) {
        if (!children.containsKey(val)) {
            TrieTree child = new TrieTree(val);
            children.put(val, child);
            return child;
        } else {
            return children.get(val);
        }
    }

    public TrieTree getChild(String val) {
        return children.get(val);
    }

}
