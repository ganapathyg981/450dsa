package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Trie4 {
    public static void main(String[] args) {
       String words[] = {"act","god","cat","dog","tac"};
        System.out.println(groupAnagrams(words));
    }
    static ArrayList<ArrayList<String>> groupAnagrams(String [] words){
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for (String in:
             words) {
            char [] charArray=in.toCharArray();
            Arrays.sort(charArray);
            String arranged=new String(charArray);  // important note
            if(map.get(arranged)==null){
                map.put(arranged,new ArrayList<String>());
                map.get(arranged).add(in);
            }
            else{
                map.get(arranged).add(in);
            }
        }
            return new ArrayList<>(map.values());    // important note
    }
}
