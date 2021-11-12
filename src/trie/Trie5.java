package trie;

import java.util.ArrayList;

public class Trie5 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String  contact[] = {"geeikistest", "geeksforgeeks",
                "geeksfortest"};
        for (String string:
                contact) {
            trie.insert(string);
        }
        ArrayList<ArrayList<String>> out=trie.returnMatching("geeips");
        for (ArrayList<String> x:
                out) {
            for (String y:
                    x) {
                System.out.print(
                        y+" "
                );
            }
            System.out.println();
        }
    }
}
