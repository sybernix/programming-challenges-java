import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordNode {
    String val;
    Map<String, WordNode> children;

    public WordNode(String val) {
        this.val = val;
        this.children = new HashMap<>();
    }

    public WordNode addChild(String val) {
        if (!children.containsKey(val)) {
            WordNode child = new WordNode(val);
            children.put(val, child);
            return child;
        }
        return children.get(val);
    }

    public WordNode getChild(String val) {
        return children.get(val);
    }

    public List<WordNode> getChildren() {
        return new ArrayList<>(children.values());
    }
}
