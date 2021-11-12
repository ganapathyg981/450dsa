package trie;

import java.util.Arrays;
import java.util.List;

public class Trie3 {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "love", "ice", "cream");
        Trie trie = new Trie();
        for (String x :
                dict) {
            trie.insert(x);
        }
        System.out.println(trie.returnAll());
        String str1 = "iloveicecreamandmango"; // for first test case
        String str2 ="ilovesamsungmobile";
        System.out.println(wordSearch(str1,trie));
//        System.out.println(wordSearch(str2,trie));
    }

   static boolean wordSearch(String search, Trie trie) {
        if (search.length() == 0) {
            return true;
        }
            for (int i = 1; i <= search.length(); i++) {
                if (trie.search(search.substring(0, i)) && wordSearch(search.substring(i), trie)) {
                    System.out.println(search.substring(0,i));
                    return true;
                }
            }
        return false;
    }
}
