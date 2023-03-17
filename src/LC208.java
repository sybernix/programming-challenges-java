public class LC208 {
    public static void main(String[] args) {
        String word = "apple";

        Trie trie = new Trie();
        trie.insert(word);
//        boolean search = trie.search(word);
//        boolean startsWith = trie.startsWith("app");
        boolean s2 = trie.search("app");
        boolean sw2 = trie.startsWith("apl");
        System.out.println(word);
    }
}
