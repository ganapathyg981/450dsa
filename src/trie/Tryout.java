package trie;

import java.util.ArrayList;

public class Tryout {
    public static void main(String[] args) {
        Trie trie = new Trie();
      String  contact[] = {"geeikistest", "geeksforgeeks",
                "geeksfortest"};
        for (String string:
             contact) {
            trie.insert(string);
        }

        trie.insert("hari");
        trie.insert("ganapathy");
        trie.insert("Siddarth");
        for (String x:
             trie.returnAll()) {
            System.out.println(x);
        }


    }
}
