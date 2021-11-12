package trie;

public class Trie2 {
    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        Trie trie= new Trie();
        for (String x:
             arr) {
            trie.insert(x);
        }
        for (String x:
                arr) {
            System.out.println(trie.returnMatchingPrefix(x));
        }

    }
}
